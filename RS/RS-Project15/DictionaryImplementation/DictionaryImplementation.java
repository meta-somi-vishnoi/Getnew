package dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class DictionaryImplementation implements Dictionary {
    public Map<String, String> tree;

    DictionaryImplementation() {
        tree = new TreeMap<String, String>();
    }

    public void addDictionaryEntry(String fileName) {
        try {
            if (fileName == null) {
                System.out.println("File not Found");
            }
            File jsonInputFile = new File(fileName);
            InputStream input = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(input);
            JsonObject jsonObj = reader.readObject();
            reader.close();
            Set<String> keys = jsonObj.keySet();
            Iterator<String> i = keys.iterator();
            while (i.hasNext()) {
                String key = (String) i.next();
                tree.put(key, jsonObj.get(key).toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found in addList");
        }
    }

    public String deleteDictionaryEntry(String key) {
        if (key != null) {
            tree.remove(key);
            return key;
        } else {
            throw new NullPointerException("Key is null");
        }
    }

    public String getValueOfKey(String key) {
        if (key != null) {
            return tree.get(key);
        } else {

            throw new NullPointerException("Key is null");
        }
    }

    public Map<String, String> sortKeyValue() {
        Set<Entry<String, String>> set = tree.entrySet();
        List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> firstWord, Map.Entry<String, String> secondWord) {
                if (secondWord.getValue() != null && firstWord.getValue() != null) {
                    return (secondWord.getValue()).compareTo(firstWord.getValue());
                } else {
                    throw new NullPointerException("Value is null for some key");
                }
            }
        });
        return tree;
    }

    public ArrayList<String> sortWithKeyValueSpecified(String smallerKey, String largerKey) {
        if (smallerKey.compareTo(largerKey) > 0) {
            throw new AssertionError("Larger key is smaller tha smaller key");
        }
        sortKeyValue();
        ArrayList<String> listOfValues = new ArrayList<String>();
        for (Map.Entry<String, String> entry : tree.entrySet()) {
            if (entry.getKey().compareTo(smallerKey) >= 0 && entry.getKey().compareTo(largerKey) <= 0 && entry.getKey() != null) {
                listOfValues.add(entry.getKey());
            } else {
                throw new NullPointerException("Value is null for some key");
            }
        }
        return listOfValues;
    }
}