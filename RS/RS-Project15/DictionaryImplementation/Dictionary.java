package dictionarymanagement;

import java.util.ArrayList;
import java.util.Map;

interface Dictionary {
    public void addDictionaryEntry(String fileName);

    public String deleteDictionaryEntry(String key);

    public String getValueOfKey(String key);

    public Map<String, String> sortDictionaryByKey();

    public ArrayList<String> sortDictionaryWithKeyValueSpecified(String smallerKey, String largerKey);
}
