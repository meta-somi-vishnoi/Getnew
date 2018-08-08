package employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class StringCharacterCount {
    public Map<String, Integer> stringMap = new HashMap<String, Integer>();

    public int getCharacterCount(String data) {
        if (stringMap.containsKey(data)) {
            for (Map.Entry entry : stringMap.entrySet()) {
                if (entry.getKey().toString().equals(data)) {
                    return (Integer) entry.getValue();
                }
            }
        }
        char[] characterArray = data.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < characterArray.length; i++) {
            set.add(characterArray[i]);
        }
        stringMap.put(data, set.size());
        return set.size();
    }
}
