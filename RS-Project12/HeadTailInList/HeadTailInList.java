package nestedlist;

import java.util.*;

class HeadTailNestedList {
    public Object result;

    public Object getValue(String positionString, List list) {
        if (positionString.charAt(0) == 'T' && positionString.length() == 1) {
            if (list.size() == 1) {
                throw new AssertionError("List is empty");
            }
            list.remove(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof List) {
                    throw new AssertionError("List instance found at tail");
                } else if (list.get(i) instanceof Integer) {
                    continue;
                } else {
                    throw new AssertionError("Invalid instance");
                }
            }
            result = list;
        } else if (positionString.charAt(0) == 'H' && positionString.length() == 1) {
            if (list.get(0) instanceof List) {
                throw new AssertionError("List instance found at head");
            } else {
                result = list.get(0);
            }
        } else if (positionString.charAt(0) == 'T') {
            if (list.size() == 1) {
                throw new AssertionError("List is empty");
            }
            list.remove(0);
            getValue(positionString.substring(1, positionString.length()), (List) list);
        } else if (positionString.charAt(0) == 'H') {
            getValue(positionString.substring(1, positionString.length()), (List) list.get(0));
        }
        return result;
    }

    public void createNestedList(ArrayList<Object> nestedList, Object object) {
        if (object instanceof List || object instanceof Integer) {
            nestedList.add(object);
        } else {
            throw new AssertionError("Invalid input type");
        }

    }
}