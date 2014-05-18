public class
QuickSort implements Sorting {
  public int[]
  sort(int[] arr) {
    qsort(arr, 0, arr.length);
    return arr;
  }

  private void
  qsort(int[] arr, int beg, int end) {
    while (end - beg > 1) {

      int
      piv = partition(arr, beg, end);
      if (piv - beg < end - (piv+1)) { // to avoid stack overflow, optimise tail recursion
        qsort(arr, beg, piv);
        beg = piv+1;
      } else {
        qsort(arr, piv+1, end);
        end = piv;
      }
    }
  }

  private int
  partition(int[] arr, int beg, int end) {
    assert(end - beg >= 1);
    int
    pivot = arr[beg],
    i = beg,
    j = end-1;

    while (true) {
      for (; j > i && arr[j] > pivot; --j);
      for (; i < j && arr[i] <= pivot; ++i);
      if (i >= j) break;
      swap(arr, i, j);
    }

    // j will definitely point to x <= pivot and all elements to the right are larger
    swap(arr, beg, j);
    return j;
  }

  private void
  swap(int[] arr, int i, int j) {
    int
    tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
  }
}
