import java.util.Arrays;

public class SelectionSort implements Sortable {
    public int[] sort(int[] numbers) {
        int[] a = Arrays.copyOf(numbers, numbers.length);
        int l = numbers.length;

        for (int i = 0; i <= l-2; ++i) { // beginning of the range
            int m = i; // index of the smallest
            for (int j = i+1; j < l; ++j) { // elements in the range but the first
                if (a[j] < a[m])
                    m = j;
            }
            int t = a[m]; a[m] = a[i]; a[i] = t;
        }

        return a;
    }
}
