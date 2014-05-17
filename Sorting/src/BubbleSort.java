import java.util.Arrays;

public class BubbleSort implements Sorting {
    public int[] sort(int[] numbers) {
        int[] a = Arrays.copyOf(numbers, numbers.length);
        int l = a.length;

        for (int i = l-2; i >= 0; i--) { // maximum j
            for (int j = 0; j <= i; j++) { // the first element of the pair
                if (a[j] > a[j+1]) {
                    int t = a[j]; a[j] = a[j+1]; a[j+1] = t;
                }
            }
        }

        return a;
    }
}
