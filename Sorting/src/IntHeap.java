public class
IntHeap {
  int[] buffer = new int[16];
  int size = 0;
  static final int UNUSED = 1;

  public void push(int x) {
    ensureCapacity(size + 1);
    ++size;
    buffer[size] = x;
    pushUp(1, size);
  }

  public int top() {
    if (size == 0) throw new IllegalStateException();
    return buffer[1];
  }

  public int pop() {
    int
    top = top();
    pullUp(1, size);
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

  private void pushUp(int root, int newby) {
    while (newby > root) {
      int
      parent = newby / 2;
      if (buffer[parent] < buffer[newby]) break;
      swap(newby, parent);
      newby = parent;
    }
  }

  private void pullUp(int hole, int last) {
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
      buffer[hole] = buffer[last];
      pushUp(1, hole);
    }
  }

  private void swap(int i, int j) {
    int
    tmp = buffer[i]; buffer[i] = buffer[j]; buffer[j] = tmp;
  }
}
