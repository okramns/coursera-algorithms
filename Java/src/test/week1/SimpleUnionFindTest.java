package week1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public class SimpleUnionFindTest extends BaseUnionFindTest {


    @Override
    public UnionFind createInstance(int n) {
        return new SimpleUnionFind(n);
    }
}