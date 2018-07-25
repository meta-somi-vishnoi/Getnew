final public class IntSet {
    private int[] array;

    IntSet() {

    }

    IntSet(int[] newArray) {
        array = new int[newArray.length];
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    /**
     * checks whether given number is member of set
     * 
     * @param number
     * @return true if number is found else return false
     */
    public boolean isMember(int number) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {

                return true;
            }
        }
        return false;
    }

    /**
     * counts size of set
     *
     */
    public int size() {
        return array.length;
    }

    /**
     * checks whether set is subset of given set
     * 
     * @param S set of array
     * @return true if subset is found else return false
     */
    public boolean isSubSet(IntSet S) {
        int flag = 0;
        int subsetPresent = 0;
        for (int i = 0; i < this.size(); i++) {
            flag = 0;
            int j;
            for (j = 0; j < S.size(); j++) {
                if (S.array[j] == this.array[i]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1 && j != S.size()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * calculates complement of array. Universal set is set from 1-10
     * 
     * @return complement array
     */
    public int[] getComplement() {
        int[] complementArray = new int[10 - this.size()];
        int elementPresent = 0;
        int startComplement = 0;
        for (int i = 1; i <= 10; i++) {
            elementPresent = 0;
            for (int j = 0; j < this.size(); j++) {
                if (array[j] == i) {
                    elementPresent = 1;
                    break;
                }
            }
            if (elementPresent == 0) {
                complementArray[startComplement++] = i;
            }
        }
        return complementArray;
    }

    /**
     * sort the given array in ascending order
     *
     */
    public void sortArray() {
        for (int i = 0; i < this.size() - 1; i++) {
            for (int j = 0; j < this.size() - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swapValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swapValue;
                }
            }
        }
    }

    /**
     * calculates union of array. Universal set is set from 1-10
     * 
     * @return union of array
     */
    public int[] unionSet(IntSet S1, IntSet S2) {
        S1.sortArray();
        S2.sortArray();
        int indexOfUnion = 0;
        int s1Index = 0;
        int s2Index = 0;
        int repeatedCount = 0;
        while (s1Index < S1.size() && s2Index < S2.size()) {
            if (S1.array[s1Index] == S2.array[s2Index]) {
                repeatedCount++;
                s1Index++;
                s2Index++;
            } else if (S1.array[s1Index] > S2.array[s2Index]) {
                s2Index++;
            } else {
                s1Index++;
            }
        }
        indexOfUnion = 0;
        s1Index = 0;
        s2Index = 0;
        int[] unionSet = new int[S1.size() + S2.size() - repeatedCount];
        while (s1Index < S1.size() && s2Index < S2.size()) {
            if (S1.array[s1Index] < S2.array[s2Index]) {
                unionSet[indexOfUnion++] = S1.array[s1Index++];
            } else if (S1.array[s1Index] > S2.array[s2Index]) {
                unionSet[indexOfUnion++] = S2.array[s2Index++];
            } else {
                unionSet[indexOfUnion++] = S2.array[s2Index++];
                s1Index++;
            }
        }
        while (s1Index < S1.size()) {
            unionSet[indexOfUnion++] = S1.array[s1Index++];
        }
        while (s2Index < S2.size()) {
            unionSet[indexOfUnion++] = S2.array[s2Index++];
        }
        return unionSet;
    }
}
