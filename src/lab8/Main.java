package lab8;

import lab8.interfaces.IStringProcessor;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IStringProcessor processor = new MyStringProcessor(new ByteFileReader(new ConsoleView()));
        try {
            List<String> rarestWords = processor.rarestWords("20_000bytesAND2_949words.txt");
            for (String s : rarestWords) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
