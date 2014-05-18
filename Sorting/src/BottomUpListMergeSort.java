import java.util.Arrays;

public class
BottomUpListMergeSort implements Sorting {

  public int[]
  sort(int[] a) {
    return IntCons.toArray(sort(IntCons.fromArray(a)));
  }

  private IntCons
  sort(IntCons list) {
    int
    count = IntCons.count(list);
    IntCons
    buf = new IntCons(Integer.MIN_VALUE, null); // buffer to accept merge output.

    for (int sliceSize = 1; sliceSize < count; sliceSize *= 2)
      list = mergeSlicePairs(list, sliceSize, buf);

    return list;
  }

  // assuming that all slices of sliceSize are already sorted in the list
  // we produce a new list with slices of size sliceSize*2 being sorted.
  private IntCons
  mergeSlicePairs(IntCons list, int sliceSize, IntCons buf) {
    buf.next = null;
    IntCons
    beg = list, // parts of new sorted slice
    out = buf;

    while (beg != null) {
      IntCons
      mid = skipOrNull(beg, sliceSize),
      end = skipOrNull(mid, sliceSize);
      out = merge(beg, mid, end, out);
      beg = end;
    }

    out.next = null; // last element should not point to anything

    return buf.next;
  }

  // Merges two consequent slices.
  // out - cons to append to; it's like an output stream (we "write into the stream").
  // (beg, mid) - the first exclusive range to merge (first "input stream").
  // (mid, end) - the second exclusive range to merge (second "input stream").
  // Initially output need not to point to beg.
  // Finally, last element does not point to end.
  // Returns pointer to the last element.
  private IntCons
  merge(IntCons beg, IntCons mid, IntCons end, IntCons out) {
    IntCons i1 = beg, i2 = mid, e1 = mid, e2 = end;

    while (i1 != e1 || i2 != e2) {
      boolean
      next1 = i2 == e2 ||
              i1 != e1 && i1.value < i2.value;
      if (next1) {
        out.next = i1; i1 = i1.next;
      } else {
        out.next = i2; i2 = i2.next;
      }
      out = out.next;
    }

    return out;
  }

  private IntCons
  skipOrNull(IntCons cons, int count) {
    IntCons result = cons;
    for (int i = 0; result != null && i < count; result = result.next, ++i);

    return result;
  }
}
