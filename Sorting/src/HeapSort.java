public class
HeapSort implements Sorting {

  public int[]
  sort(int[] arr) {
    IntHeap
    heap = new IntHeap();
    for (int x : arr)
      heap.push(x);
    for (int i = 0; i < arr.length; ++i)
      arr[i] = heap.pop();

    return arr;
  }
}
