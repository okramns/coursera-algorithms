package week1;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public class WeightedQuickUnion extends QuickUnion {
    private int[] size;
    public WeightedQuickUnion(int n) {
        super(n);
        size = new int[n];
        for(int i=0;i<n;i++){
            size[i] = 1;
        }
    }

    @Override
    public void union(int x, int y) {
        int p = root(x);
        int q = root(y);
        if(p == q) return;
        if(size[p] > size[q]){
            parents[q] = p;
            size[p] += size[q];
        }else{
            parents[p] = q;
            size[q] += size[p];
        }
    }

}
