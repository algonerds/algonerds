public class
BottomUpMergeSort implements Sorting {

  public int[]
  sort(int[] array) {
    int
    l = array.length;
    int[]
    src = array,
    dst = new int[l];

    // invariant: src - contains sorted for w array, dst - is throwaway buffer
    for (int sliceSize = 1; sliceSize < l; sliceSize *= 2) {
      mergeSlicePairs(src, sliceSize, dst);
      int[] tmp = src; src = dst; dst = tmp;
    }

    if (array != src)
      System.arraycopy(src, 0, array, 0, l);

    return array;
  }

  private void
  mergeSlicePairs(int[] src, int sliceSize, int[] dst) {
    int
    l = src.length;
    for (int i = 0; i < l; i += 2*sliceSize) {
      merge(src, i, Math.min(i+sliceSize, l), Math.min(i+2*sliceSize, l), dst);
    }
  }

  private void
  merge(int[] src, int beg, int mid, int end, int[] dst) {
    int
    i1 = beg, e1 = mid,
    i2 = mid, e2 = end,
    out = beg;

    while (i1 < e1 || i2 < e2) {
      dst[out++] =
        (i2 >= e2)           ? src[i1++] :
        (i1 >= e1)           ? src[i2++] :
        (src[i1] <= src[i2]) ? src[i1++] :
                               src[i2++];
    }
    assert(out == end);
  }
}
