public class
QuickSort implements Sorting {
  public int[]
  sort(int[] arr) {
    qsort(arr, 0, arr.length);
    return arr;
  }

  private void
  qsort(int[] arr, int beg, int end) {
    if (end - beg <= 1) return;

    int
    piv = partition(arr, beg, end);
    qsort(arr, beg, piv);
    qsort(arr, piv+1, end);
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
