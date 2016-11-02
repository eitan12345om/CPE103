/**
 *JUnit tests for the BST class
 *
 *
 *
 *@author Evan Jameson
 *@version Lab 7
 */
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class BSTTests
{
	@Test
	public void test1_all()
	{
		BST<Integer> bst = new BST<>();
		bst.insert(3);
		assertTrue(bst.contains(3));
		assertFalse(bst.contains(9));
		assertEquals(3, (int) bst.maximum());
		assertEquals(3, (int) bst.minimum());
		assertEquals(1, bst.size());
	}

	@Test
	public void test2_all()
	{
		BST<Integer> bst = new BST<>();
      	        bst.insert(5);
      	        bst.insert(3);
      	        bst.insert(4);
      	        bst.insert(0);
      	        bst.insert(2);
      	        bst.insert(1);
      	        bst.insert(10);
      	        bst.insert(8);
      	        bst.insert(7);
      	        bst.insert(9);
      	        bst.insert(6);
      	        assertEquals(11, bst.size());
      	        bst.insert(10);
      	        bst.insert(9);
      	        bst.insert(6);
      	        assertEquals(11, bst.size());
      	        assertEquals(10, (int)bst.maximum());
      	        assertEquals(0, (int)bst.minimum());
	}

	@Test
	public void test3_all()
	{
		BST<Integer> bst = new BST<>();
		for(int i = 1000; i > 0; i--)
		{
			bst.insert(i);
		}
		for(int i = 1000; i > 0; i--)
		{
			assertTrue(bst.contains(i));
		}
		assertEquals(1000, (int) bst.maximum());
		assertEquals(1, (int) bst.minimum());
		assertEquals(1000, bst.size());
	}

	@Test
	public void test4_all()
	{
		BST<Integer> bst = new BST<>();
		for(int i = 0; i < 1000; i++)
		{
			bst.insert(i);
		}
		for(int i = 0; i < 1000; i++)
		{
			assertTrue(bst.contains(i));
		}
		assertEquals(999, (int) bst.maximum());
		assertEquals(0, (int) bst.minimum());
		assertEquals(1000, bst.size());		
	}

	@Test
	public void test5_all()
	{
		BST<Integer> bst = new BST<>();
  		bst.insert(5);
      	        bst.insert(3);
      	        bst.insert(4);
      	        bst.insert(8);
      	        bst.insert(7);
      	        bst.insert(9);
      	        bst.insert(6);
      	        bst.insert(0);
      	        bst.insert(2);
      	        bst.insert(1);
      	        bst.insert(10);
      	        bst.insert(10);
      	        bst.insert(8);
      	        bst.insert(7);
      	        bst.insert(9);
      	        bst.insert(6);
      	        assertEquals(11, bst.size());
      	        assertEquals(10, (int) bst.maximum());
      	        assertEquals(0, (int) bst.minimum());
      	        ArrayList<Integer> arr = new ArrayList<>();
      	        bst.toSortedList(arr);
      	        assertTrue(arrEquals(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr));
	}

	private static <T> boolean arrEquals(T[] arr1, ArrayList<T> arr2) {
        if (arr1.length != arr2.size()) 
        {
           return false;
        }
        for (int i = 0; i < arr1.length; i++) 
        {
           if (!arr1[i].equals(arr2.get(i))) 
           {
              return false;
           }
        }
        return true;
   }
}
