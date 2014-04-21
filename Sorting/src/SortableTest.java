import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sun.misc.Sort;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by egor_hm on 4/21/14.
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

    @Test
    public void sortEmptyArray() {
        int[] array  = {};

    }

    @Parameterized.Parameters
    public static Collection data() {
        Class[][] data = new Class[][] { {InsertionSort.class} };
        return Arrays.asList(data);
    }
}
