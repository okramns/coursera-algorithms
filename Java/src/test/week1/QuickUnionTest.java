package week1;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public class QuickUnionTest extends BaseUnionFindTest {
    @Override
    public UnionFind createInstance(int n) {
        return new QuickUnion(n);
    }
}
