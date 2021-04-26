package lab8.interfaces;

import java.io.IOException;

public interface IFileReader {
    String getContent(String filename) throws IOException;
}