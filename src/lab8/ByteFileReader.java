package lab8;

import lab8.interfaces.IFileReader;
import lab8.interfaces.IView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteFileReader implements IFileReader {
    IView view;

    public ByteFileReader() {
        view = null;
    }

    public ByteFileReader(IView view) {
        this.view = view;
    }

    public String getContent(String filename) throws IOException {
        String s = "";
        if (filename == null) {
            throw new NullPointerException("NULL passed as argument");
        }
        int fileSize = (int)(new File(filename)).length();
        byte[] content = new byte[fileSize];
        try (FileInputStream in = new FileInputStream(filename)) {
            byte[] buf = new byte[512];
            int totalRead = 0;
            int read = -1;

            while ((read = in.read(buf)) != -1) {
                for (int i = 0; i < read; i++) {
                    content[i + totalRead] = buf[i];
                }
                totalRead += read;
                if (view != null) {
                    view.update(totalRead, fileSize, "Reading '" + filename + "'");
                }
                s += new String(buf, 0, read);
            }
        }
        s = new String(content, "UTF-8");
        return s;
    }
}
