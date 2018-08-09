package dictionary;

import java.util.ArrayList;
import java.util.Map;

interface Dictionary {
    public void addDictionaryEntry(String fileName);

    public String deleteDictionaryEntry(String key);

    public String getValueOfKey(String key);

    public Map<String, String> sortKeyValue();

    public ArrayList<String> sortWithKeyValueSpecified(String smallerKey, String largerKey);
}
