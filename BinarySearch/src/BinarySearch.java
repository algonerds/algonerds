public class BinarySearch {
    public static int find(int[] array, int element) {
        return find(array, element, 0, array.length-1);
    }

    public static int find(int[] array, int element, int left, int right) {
        if (left > right) return -1;
        int mid = left+(right-left)/2;
        if (element == array[mid]){
            return mid;
        }
        else if (element < array[mid]) {
            return find(array, element, left, mid-1);
        }
        else if (element > array[mid]) {
            return find(array, element, mid+1, right);
        }
        return -1;
    }
}
