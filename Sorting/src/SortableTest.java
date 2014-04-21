import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Egor Hamaliy on 4/21/14.
 */
@RunWith(value = Parameterized.class)
public class SortableTest {
    private Class algorithmType = null;
    private Sortable sorter = null;

    public SortableTest(Class algorithmType) {
        this.algorithmType = algorithmType;
    }

    @Before
    public void initialize() throws IllegalAccessException, InstantiationException {
        sorter = (Sortable)algorithmType.newInstance();
    }

    @Parameterized.Parameters
    public static Collection data() {
        Class[][] data = new Class[][] { {InsertionSort.class} };
        return Arrays.asList(data);
    }

    @Test
    public void sortEmptyArray() {
        int[] array  = {};
        assertEquals(null, sorter.sort(array));

    }

    @Test
    public void sortOneElementArray() {
        int[] array  = { 1 };
        assertArrayEquals(new int[] { 1 }, sorter.sort(array));

    }

    @Test
    public void sortEqualElementsArray() {
        int[] array  = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        assertArrayEquals(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, sorter.sort(array));

    }

    @Test
    public void sortSortedElementsArray() {
        int[] array  = { 1, 2, 3, 4, 7, 8, 9, 10, 15, 100, 200 };
        assertArrayEquals(new int[] { 1, 2, 3, 4, 7, 8, 9, 10, 15, 100, 200 }, sorter.sort(array));
    }

    @Test
    public void sortDuplicateElementsArray() {
        int[] array  = { 2, 200, 4, 2, 8, 2, 4, 15, 4, 100, 3, 0, 28, 2, 0 };
        assertArrayEquals(new int[] { 0, 0, 2, 2, 2, 2, 3, 4, 4, 4, 8, 15, 28, 100, 200 }, sorter.sort(array));
    }

    @Test
    public void sortOddElementsArray() {
        int[] array  = { 100, 5, 1, 2, 9, 101, 21, 9, 2, 56, 34, 0 };
        assertArrayEquals(new int[] { 0, 1, 2, 2, 5, 9, 9, 21, 34, 56, 100, 101 }, sorter.sort(array));
    }

    @Test
    public void sortEvenElementsArray() {
        int[] array  = { 100, 5, 1, 2, 9, 101, 21, 9, 2, 56, 34 };
        assertArrayEquals(new int[] { 1, 2, 2, 5, 9, 9, 21, 34, 56, 100, 101 }, sorter.sort(array));
    }

    @Test
    public void sortReversedElementsArray() {
        int[] array  = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, sorter.sort(array));
    }


}
