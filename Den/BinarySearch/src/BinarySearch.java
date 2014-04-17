public class BinarySearch {
    public static int find(int[] array, int element) {
      int left = 0;
      int right = array.length - 1;

      while (left <= right){
        int mid = left + (right - left)/2;

        if (array[mid] < element)       left = mid + 1;
        else if (array[mid] > element)  right = mid - 1;
        else                            return mid;
      }

      return -1;
    }
}
