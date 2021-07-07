package nestedlist;

import java.util.*;

class TraverseNestedList implements NestedListInterface {
    public static Integer sum = 0;
    public static boolean result = false;
    public static Integer maximumValue = -1;
    public static int count = 0;

    @SuppressWarnings("unchecked")
    public Integer sumOfList(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                sum += (Integer) list.get(i);
            }
            if (list.get(i) instanceof List) {
                sumOfList((List) list.get(i));
            }
        }
        return sum;
    }
    
    public boolean isValuePresent(List<Object> list, Integer elementToSearch) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                if (((Integer) list.get(i)).equals(elementToSearch)) {
                    result = true;
                }
            } else if (list.get(i) instanceof List) {
                isValuePresent((List<Object>) list.get(i), elementToSearch);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public Integer getMaximumValue(List list) {
        for (int i = 0; i < list.size(); i++) {
            if (count == 0 && list.get(i) instanceof Integer) {
                count++;
                maximumValue = (Integer) list.get(i);
            }
            if (list.get(i) instanceof Integer && (Integer) list.get(i) > maximumValue) {
                maximumValue = (Integer) list.get(i);
            }
            if (list.get(i) instanceof List) {
                getMaximumValue((List) list.get(i));
            }
        }
        return maximumValue;
    }

    public void createNestedList(ArrayList<Object> nestedList, Object object) {
        if (object instanceof List || object instanceof Integer) {
            nestedList.add(object);
        } else {
            throw new AssertionError("Invalid input type");
        }

    }
}
