public class BinarySearch {
    public static int find(int[] array, int element) {
        int iterativeResult = findIterative(array,  element);
        int reccursiveResult = findReccursive(array, element, 0, array.length-1);
        int resultValue = (iterativeResult == reccursiveResult) ? iterativeResult :  -1;

        return resultValue;
    }

    public static int findIterative(int[] array, int element){
        int left = 0, right = array.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left +(right-left)/2;
            if (element == array[mid]){
                return mid;
            }
            else if (element > array[mid]){
                left = mid + 1;
            }
            else if (element < array[mid]){
                right = mid - 1;
            }

        }
        return -1;
    }

    public static int findReccursive(int[] array, int element, int left, int right) {
        if (left > right) return -1;
        int mid = left+(right-left)/2;
        if (element == array[mid]){
            return mid;
        }
        else if (element < array[mid]) {
            return findReccursive(array, element, left, mid - 1);
        }
        else if (element > array[mid]) {
            return findReccursive(array, element, mid + 1, right);
        }
        return -1;
    }
}
