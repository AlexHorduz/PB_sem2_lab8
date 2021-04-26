package lab8.interfaces;

import java.io.IOException;
import java.util.List;

public interface IStringProcessor {
    List<String> rarestWords(String filename) throws IOException;
}
