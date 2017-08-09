package week1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public abstract class BaseUnionFindTest {


    @Test
    public void checkConditionForTotallyDisjointSet(){
        UnionFind unionFind = createInstance(4);
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++) {
                if (i == j) continue;
                assertFalse(unionFind.find(i, j));
            }
    }

    @Test
    public void checkSimpleCaseWithTwoElements() throws Exception {
        UnionFind unionFind = createInstance(2);
        unionFind.union(0,1);
        assertTrue(unionFind.find(0,1));
        assertTrue(unionFind.find(1,0));

        unionFind = createInstance(2);
        unionFind.union(1,0);
        assertTrue(unionFind.find(0,1));
        assertTrue(unionFind.find(1,0));

    }

    @Test
    public void checkUnionWithThreeElements() throws  Exception{
        UnionFind unionFind = createInstance(3);
        unionFind.union(0,2);
        assertTrue(unionFind.find(0,2));
        assertTrue(unionFind.find(2,0));
        assertFalse(unionFind.find(0,1));

    }

    @Test
    public void checkUnionConcatenation() throws  Exception{
        UnionFind unionFind = createInstance(4);
        unionFind.union(0,1);
        unionFind.union(1,2);
        unionFind.union(2,3);

        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
        assertTrue(unionFind.find(i,j));


    }

    @Test
    public void checkUnionToSameRoot() throws  Exception{
        UnionFind unionFind = createInstance(4);
        unionFind.union(0,1);
        unionFind.union(0,2);
        unionFind.union(0,3);

        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                assertTrue(unionFind.find(i,j));
    }

    @Test
    public void checkUnionToSameRoot2() throws  Exception{
        UnionFind unionFind = createInstance(4);
        unionFind.union(0,1);
        unionFind.union(2,1);
        unionFind.union(3,1);

        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                assertTrue(unionFind.find(i,j));
    }

    @Test
    public void checkMergeTwoSets() throws  Exception{
        UnionFind unionFind = createInstance(6);
        unionFind.union(0,1);
        unionFind.union(0,2);

        unionFind.union(3,4);
        unionFind.union(3,5);


        assertFalse(unionFind.find(0,3));

        unionFind.union(2,5);

        for(int i=0;i<6;i++)
            for(int j=0;j<6;j++)
                assertTrue(unionFind.find(i,j));
    }

    @Test
    public void checkRepeatedUnion() throws  Exception{
        UnionFind unionFind = createInstance(3);
        unionFind.union(0,1);
        unionFind.union(0,1);
        unionFind.union(1,0);

        assertFalse(unionFind.find(1,2));
        assertFalse(unionFind.find(2,0));
        assertTrue(unionFind.find(0,1));
    }


    public abstract UnionFind createInstance(int n);
}
