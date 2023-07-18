package org.example;

import java.util.Arrays;

public class UnionFind {

    int[] rank;
    int[] parent;

    public UnionFind(int n) {
        //initially self will be parent of itself  and rnk will be set to 0
        rank = new int[n + 1];
        Arrays.fill(rank, 0);

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    public static void main(String[] args) {

        UnionFind unionFind = new UnionFind(7);

        unionFind.unionByRank(1,2);
        unionFind.unionByRank(2,3);
        unionFind.unionByRank(4,5);
        unionFind.unionByRank(6,7);
        unionFind.unionByRank(5,6);

        if(unionFind.findULTParent(3) == unionFind.findULTParent(7)){
            System.out.println("Same");
        }else{
            System.out.println("Not Same");
        }

        unionFind.unionByRank(3,7);

        if(unionFind.findULTParent(3) == unionFind.findULTParent(7)){
            System.out.println("Same");
        }else{
            System.out.println(" Not Same");
        }

    }

    //recursively find ultimate parent
    public int findULTParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findULTParent(parent[node]);
    }

    public void unionByRank(int u, int v) {

        int uUltP = findULTParent(u);
        int vUltP = findULTParent(v);

        if (uUltP == vUltP) {
            return;
        }

        //jo bada hoga wo parent ban jayega
        if (rank[uUltP] < rank[vUltP]) {
            parent[uUltP] = vUltP;

        } else if (rank[uUltP] > rank[vUltP]) {
            parent[vUltP] = uUltP;
        }//any one can be parent and rank of that will increase
        else {
            parent[vUltP] = uUltP;
            rank[uUltP]++;
        }
    }
}


/* 
Output 
 Not Same 
 Same
*/  
