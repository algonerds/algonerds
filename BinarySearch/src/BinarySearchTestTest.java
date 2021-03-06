import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by sergey on 4/11/14.
 */
public class BinarySearchTestTest {
    @Test
    public void findElement()
    {
        int[] array  = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(0, BinarySearch.find(array, 1));
    }

    @Test
    public void findAnyElement()
    {
        int[] array  = {1,1,1,1,1,1,1,1,1,1};
        int searchResult = BinarySearch.find(array, 1);
        assertTrue( (0 <= searchResult) && (searchResult  <= 9 ) );
    }

    @Test
    public void findMissingElement()
    {
        int[] array  = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(-1,BinarySearch.find(array, 0));
    }

    @Test
    public void findElementInEmptyArray()
    {
        int[] array  = {};
        assertEquals(-1,BinarySearch.find(array, 1));
    }

    @Test
    public void findElementInOneElementArray()
    {
        int[] array  = {8};
        assertEquals(0,BinarySearch.find(array, 8));
    }

    @Test
    public void findElementInsideArray()
    {
        int[] array  = {1,2,3,4,5,6,7,8,9,10,11};
        assertEquals(8,BinarySearch.find(array, 9));
    }

    @Test
    public void findFirstOfTwo() {
      assertEquals(0, BinarySearch.find(a(1, 2), 1));
    }

    @Test
    public void findSecondOfTwo() {
      assertEquals(1, BinarySearch.find(a(1, 2), 2));
    }

    private static int[] a(int... array) {
      return array;
    }
}
