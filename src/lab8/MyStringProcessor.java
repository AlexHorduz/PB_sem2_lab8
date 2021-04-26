package lab8;


import lab8.interfaces.IFileReader;
import lab8.interfaces.IStringProcessor;

import java.io.IOException;
import java.util.*;


public class MyStringProcessor implements IStringProcessor {
    IFileReader reader;

    public MyStringProcessor(IFileReader reader) {
        this.reader = reader;
    }

    public List<String> rarestWords(String filename) throws IOException {
        String text = reader.getContent(filename);
        String[] stringArray = text.split("[^\\wa-яА-ЯіІєЄґҐїЇгГ']+");
        HashMap<String, Integer> counter = new HashMap<>();
        for (String s : stringArray) {
            if(!counter.containsKey(s.toLowerCase())) {
                counter.put(s.toLowerCase(), 1);
            } else {
                counter.put(s.toLowerCase(), counter.get(s.toLowerCase()) + 1);
            }
        }
        int minValue = -1;
        List<String> minCountStrings = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() < minValue || minValue == -1) {
                minValue = entry.getValue();
                minCountStrings = new ArrayList<>();
                minCountStrings.add(entry.getKey());
            } else if (entry.getValue() == minValue) {
                minCountStrings.add(entry.getKey());
            }
        }
        return minCountStrings;
    }
}
