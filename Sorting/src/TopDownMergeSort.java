import java.util.Arrays;

public class
TopDownMergeSort implements Sorting {
  public int[]
  sort(int[] src) {
    int[]
    buf = new int[src.length],
    res = mergeRecursively(src, 0, src.length, buf);

    copyIfDifferent(res, 0, res.length, src);

    return src;
  }

  // returns the array which contains the sorted slice
  private int[]
  mergeRecursively(int[] src, int beg, int end, int[] buf) {
    if (end - beg <= 1) return src;

    int
    mid = beg + (end - beg + 1)/2; // first part will be >= than second

    int[]
    src1 = mergeRecursively(src, beg, mid, buf),
    src2 = mergeRecursively(src, mid, end, buf);
    copyIfDifferent(src2, mid, end - mid, src1);

    int[]
    dst = src1 == src ? buf : src;
    merge(src1, beg, mid, end, dst);

    return dst;
  }

  private void
  merge(int[] src, int beg, int mid, int end, int[] dst) {
    int
    i1 = beg,
    e1 = mid,
    i2 = mid,
    e2 = end,
    out = beg;

    while (i1 != e1 || i2 != e2) {
      boolean
      next1 = (i2 == e2) ||
             !(i1 == e1) && (src[i1] < src[i2]);
      dst[out++] = next1 ? src[i1++] : src[i2++];
    }
  }

  private void
  copyIfDifferent(int[] src, int beg, int len, int[] dst) {
    if (src != dst)
      System.arraycopy(src, beg, dst, beg, len);
  }
}
