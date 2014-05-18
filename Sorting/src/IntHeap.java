public class
IntHeap {
  int[] buffer = new int[16];
  int size = 0;
  static final int UNUSED = 1;
  static final int ROOT = 1;

  public void push(int x) {
    ensureCapacity(size + 1);
    ++size;
    pushUp(size, x);
  }

  public int top() {
    if (size == 0) throw new IllegalStateException();
    return buffer[ROOT];
  }

  public int pop() {
    int
    top = top();
    pullUp(size);
    --size;
    return top;
  }

  public int size() { return size; }

  private void ensureCapacity(int minimalCapacity) {
    if (minimalCapacity > capacity()) {
      int[]
      newBuffer = new int[UNUSED + Math.max(capacity() * 2, minimalCapacity)];
      System.arraycopy(buffer, UNUSED, newBuffer, UNUSED, size);
      buffer = newBuffer;
    }
  }

  private int capacity() { return buffer.length - UNUSED; }

  private void pushUp(int hole, int x) {
    while (hole > ROOT) {
      int
      parent = hole / 2;
      if (buffer[parent] < x) break;
      buffer[hole] = buffer[parent];
      hole = parent;
    }
    buffer[hole] = x;
  }

  private void pullUp(int last) {
    int
    hole = ROOT;
    while (true) {
      int
      child = hole * 2;
      if (child+1 > last) break;

      int
      newHole = buffer[child] < buffer[child+1] ? child : child+1;
      buffer[hole] = buffer[newHole];
      hole = newHole;
    }

    if (hole < last) {
      pushUp(hole, buffer[last]);
    }
  }
}
