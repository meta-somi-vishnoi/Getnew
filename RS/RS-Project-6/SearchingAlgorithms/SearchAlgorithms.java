class LinearSearch {

    /**
     * calculates index of searching element using linear search
     * 
     * @param array
     *            [] of integer, length of array, element to be searched
     * @return index of searching element
     */
    public int linearSearching(int array[], int length, int numberSearched,
            int index) {
        if (index < length) {
            if (array[index] == numberSearched) {
                return (index + 1);
            } else {
                return linearSearching(array, length, numberSearched, index + 1);
            }
        }
        return -1;
    }
}

class BinarySearch {

    /**
     * calculates index of searching element using binary search
     * 
     * @param array
     *            [] of integer, length of array, element to be searched, start
     *            index of search, end index of search
     * @return index of searching element
     */
    public int binarySearching(int array[], int length, int numberSearched,
            int start, int end) {
        if (end >= start) {
            int mid = (start + end) / 2;
            if (array[mid] == numberSearched) {
                return mid + 1;
            }
            if (array[mid] > numberSearched) {
                return binarySearching(array, length, numberSearched, start,
                        mid - 1);
            } else {
                return binarySearching(array, length, numberSearched, mid + 1,
                        end);
            }
        }
        return -1;
    }
}