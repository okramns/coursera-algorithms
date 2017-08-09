package week1;

/**
 * Created by OSingh4 on 8/9/2017.
 */
public class SimpleUnionFind implements UnionFind {

    private final int[] ids;

    public SimpleUnionFind(int n){

        ids = new int[n];
        for(int i=0;i<n;i++){
            ids[i] = i;
        }
    }

    @Override
    public void union(int x, int y){
        int t = ids[y];
        ids[y] = ids[x];
        for(int i=0;i<ids.length;i++){
            if(ids[i] == t){
                ids[i] = ids[x];
            }
        }
    }

    @Override
    public boolean find(int x, int y){
        return ids[x] == ids[y];
    }
}
