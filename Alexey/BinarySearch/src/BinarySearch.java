public class BinarySearch {
  public static int find(int[] array, int element) {
    int len = array.length, l = 0, r = len - 1;

    while (l < r) {
      int m = l + (r-l) / 2;
      if (element < array[m])
        r = m - 1;
      else if (element == array[m])
        return m;
      else
        l = m + 1;
    }

    if (l < len && array[l] == element)
      return l;
    else
      return -1;
  }

  public static int find2(int[] array, int element) {
    int len = array.length, l = 0, r = len - 1;
    while (l < r - 1) {
      int m = l + (r-l) / 2;
      if (array[m] <= element)
        l = m;
      else
        r = m - 1;
    }

    if (l < len && array[l] == element)
      return l;
    if (0 <= r && r < len && array[r] == element)
      return r;
    else
      return -1;
  }
}
