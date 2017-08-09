package week1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public class WeightedQuickUnionTest extends BaseUnionFindTest {
    @Override
    public UnionFind createInstance(int n) {
        return new WeightedQuickUnion(n);
    }

    @Test
    public void checkIfSizesAreInitializedCorrectly() throws Exception{
        WeightedQuickUnion obj = new WeightedQuickUnion(4);

        Field field = obj.getClass().getDeclaredField("size");
        field.setAccessible(true);
        int[] sizes = (int[])field.get(obj);
        assertTrue(Arrays.equals(new int[]{1,1,1,1},sizes));
    }

    @Test
    public void checkIfSizesAreUpdatedCorrectly() throws Exception{
        WeightedQuickUnion obj = new WeightedQuickUnion(4);

        obj.union(0,1);
        Field field = obj.getClass().getDeclaredField("size");
        field.setAccessible(true);
        int[] sizes = (int[])field.get(obj);
        assertTrue(Arrays.equals(new int[]{1,2,1,1},sizes));
        obj.union(0,3);
        assertTrue(Arrays.equals(new int[]{1,3,1,1},sizes));
    }
}
