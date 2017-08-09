package week1;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public class QuickUnion implements UnionFind{
    protected int[] parents;
    public QuickUnion(int n){
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
    }
    @Override
    public void union(int x, int y) {
        parents[root(y)] = root(x);
    }

    @Override
    public boolean find(int x, int y) {
        return root(x) == root(y);
    }

    protected int root(int x){

        while(parents[x] != parents[parents[x]]){
            x = parents[x];
        }
        return parents[x];
    }
}
