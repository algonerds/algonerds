public class IntCons {
  public int value;
  public IntCons next;

  public IntCons(int value, IntCons next) {
    this.value = value;
    this.next = next;
  }

  public static IntCons fromArray(int[] array) {
    IntCons next = null;
    for (int i = array.length - 1; i >= 0; --i) {
      next = new IntCons(array[i], next);
    }
    return next;
  }

  public static int[] toArray(IntCons list) {
    int[] result = new int[count(list)];

    IntCons c = list;
    int i = 0;
    for (; c != null; c = c.next, ++i)
      result[i] = c.value;

    return result;
  }

  public static int count(IntCons list) {
    int result = 0;

    for (IntCons cons = list; cons != null; cons = cons.next)
      result++;

    return result;
  }
}
