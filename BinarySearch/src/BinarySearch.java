public class BinarySearch {
    public static int find(int[] array, int element) {
        return find(array, element, 0, array.length-1);
    }

    public static int find(int[] array, int element, int left, int right) {
        int mid = (right-left)/2;
        if (left>=right) return -1;
        if (element < array[mid]) {
            return find(array, element, left, mid);
        }
        else if (element > array[mid]) {
            return find(array, element, mid, right);
        }
        else {
            return mid;
        }
    }
}
