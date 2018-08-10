package dictionarymanagement;

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
                throw new NullPointerException("Filename null is not allowed");
            }
            File jsonInputFile = new File(fileName);
            InputStream input = new FileInputStream(jsonInputFile);
            JsonReader reader = Json.createReader(input);
            JsonObject jsonObj = reader.readObject();
            reader.close();

            for (String key : jsonObj.keySet()) {
                tree.put(key.toString(), jsonObj.get(key).toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found in addList");
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }

    public String deleteDictionaryEntry(String key) {
        if (tree.containsKey(key)) {
            if (key != null) {
                tree.remove(key);
                return key;
            } else {
                return null;
            }
        } else {
            throw new AssertionError("Key does not exist in tree");
        }
    }

    public String getValueOfKey(String key) {
        String meaning;
        if (tree.containsKey(key)) {
            if (key != null) {
                meaning = tree.get(key);
            } else {
                throw new NullPointerException("Key is null");
            }
            return meaning;
        } else {
            throw new AssertionError("Key does not exist in tree");
        }
    }

    public Map<String, String> sortDictionaryByKey() {
        return tree;
    }

    public ArrayList<String> sortDictionaryWithKeyValueSpecified(String smallerKey, String largerKey) {
        if (smallerKey.compareTo(largerKey) > 0) {
            throw new AssertionError("Larger key is smaller tha smaller key");
        }
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
