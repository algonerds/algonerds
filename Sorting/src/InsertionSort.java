import java.util.Arrays;

public class InsertionSort implements Sorting {
    // sorted:x:rest -> smaller<x<larger:rest
    //
    public int[] sort(int[] numbers) {
        int[] a = Arrays.copyOf(numbers, numbers.length);
        int l = numbers.length;

        for (int i = 1; i <= l-1; ++i) { // index of x
            int x = a[i];


            int j = 0; // insertion position, stable
            for (; a[j] <= x && j < i; ++j);

            // rotate the range right
            for (int k = i; k-1 >= j; --k)
                a[k] = a[k-1];
            a[j] = x;
        }

        return a;
    }
}
