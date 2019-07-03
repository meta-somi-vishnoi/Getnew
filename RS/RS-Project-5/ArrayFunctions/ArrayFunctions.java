import java.util.ArrayList;

/**
 * performs operations on array
 */
public class ArrayFunctions {

    /**
     * calculates maximum mirror found in array
     * 
     * @param array
     *            [] stores array of integer, lengthOfArray store length of
     *            array
     * @return maximum mirror count
     */
    public int maximumMirror(int array[], int lengthOfArray) {
        try {
            if (array.length == 0) {
                throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Array is empty. Enter valid array elements");
            System.exit(0);
        }
        int mirrorValue = 0;
        int count = 0;
        int maximum = 0;
        int flag = 0;
        for (int i = 0; i < lengthOfArray; i++) {
            count = 0;
            flag = 0;
            for (int j = lengthOfArray - 1; j >= 0; j--) {
                if (array[i] == array[j] && flag == 1) {
                    count++;
                    flag = 1;
                    i++;
                } else if (array[i] == array[j] && flag == 0 && count == 0
                        && i != j) {
                    count++;
                    flag = 1;
                    i++;
                } else if (array[i] != array[j] && count >= 1 && flag == 1) {
                    i = i - count;
                    j = j + count;
                    count = 0;
                    flag = 0;
                }
                if (count > maximum) {
                    maximum = count;
                }
            }

        }
        return maximum;
    }

    /**
     * performs swapping of two numbers of array
     * 
     * @param index1
     *            as index of first number of array, index2 as index of second
     *            number of array
     */
    public void swapValueOfArray(int array[], int index1, int index2) {
        int storeValue;
        storeValue = array[index1];
        array[index1] = array[index2];
        array[index2] = storeValue;
    }

    /**
     * performs fixing X and Y instance such Y is next to X
     * 
     * @param array
     *            [] as array of integer, lengthofArray as length of array,
     *            valueOfX as X instance, valueOfY as Y instance
     * @return array[] after fixing X and Y
     */
    public int[] fixingInstance(int array[], int lengthOfArray, int valueOfX,
            int valueOfY) {
        ArrayList<Integer> fixedArrayY = new ArrayList<Integer>();
        int countX = 0;
        int countY = 0;
        int adjacentX = 0;
        try {
            for (int i = 0; i < lengthOfArray; i++) {
                if (array[i] == valueOfX) {
                    countX++;
                }
                if (array[i] == valueOfY) {
                    countY++;
                    fixedArrayY.add(i);
                }
                if (i == 0) {
                    continue;
                } else {
                    if (array[i] == array[i - 1] && array[i] == valueOfX) {
                        adjacentX = 1;
                        break;
                    }
                }
            }
            if (array.length == 0 || (countX != countY)
                    || array[lengthOfArray - 1] == valueOfX || adjacentX == 1) {
                throw new AssertionError();
            }
        } catch (AssertionError e) {
            System.out.println("Enter valid array elements");
            System.exit(0);
        }
        for (int j = 0; j < lengthOfArray; j++) {
            if (array[j] == valueOfX) {
                swapValueOfArray(array, j + 1, fixedArrayY.get(--countY));
            }
        }
        return array;
    }

    /**
     * calculates clumps found in array
     * 
     * @param array
     *            [] as array of integer, lengthOfArray as array length
     * @return clumpCount as number of clumps in array
     */
    public int countClumps(int array[], int lengthOfArray) {
        int clumpCount = 0;
        try {
            if (array.length == 0) {
                throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Array is empty. Enter valid array elements");
            System.exit(0);
        }
        int[] clumpArray = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            if (i == 0) {
                clumpArray[i] = 0;
            } else {
                if (array[i] == array[i - 1]) {
                    clumpArray[i] = clumpArray[i - 1] + 1;
                    if (clumpArray[i] == 1) {
                        clumpCount++;
                    }
                } else {
                    clumpArray[i] = 0;
                }
            }
        }
        return clumpCount;
    }

    /**
     * calculates split point in array where sum of left side terms is equal to
     * sum of right side terms
     * 
     * @param array
     *            [] as array of integer, lengthOfArray as array length
     * @return index of splitting array
     */
    public int splittingArray(int array[], int lengthOfArray) {
        int sumOfArray = 0;
        try {
            for (int i = 0; i < lengthOfArray; i++) {
                sumOfArray += array[i];
            }
            if (array.length == 0) {
                throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Array is empty. Enter valid array elements");
            System.exit(0);
        }
        if (sumOfArray % 2 == 1) {
            return -1;
        } else {
            int splitSum = 0;
            int startIndex = 0;
            while (splitSum != (sumOfArray / 2)) {
                splitSum += array[startIndex];
                startIndex++;
            }
            if (startIndex == lengthOfArray) {
                return -1;
            }
            return startIndex;
        }
    }

}
