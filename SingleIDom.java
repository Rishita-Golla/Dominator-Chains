/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author user11
 */
public class SingleIDom {
    
    int n,root;
    int edge[][];
    ArrayList<Integer> singleDominators; 
    
    public  SingleIDom(int n,int root)
    {
         this.n = n;
         edge = new int[20][20];
        
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = 0;
            }
        }
         
        this.root = root;
         singleDominators =new ArrayList();
        
        
     }
    void addEdge(int src, int dest) {
        edge[src][dest] = 1;
    
    }
    
    void SingleIDom(int s) {
        
        int len=n;
        
        int rGraph[][] = new int[20][20]; // rGraph[i][j] indicates residual capacity of edge i-j
        for (int u = 0; u < len; u++) {
            for (int v = 0; v < len; v++) {
                rGraph[u][v] = edge[u][v];
            }
        }
        
        int parent[] = new int[len]; 
        // This array is filled by BFS and to store path
        
        // Augment the flow while tere is path from source to sink
        ArrayList<Integer> path = new ArrayList();
        
        int flag=bfs(rGraph, s,root, parent,len);
        /* Find minimum residual capacity of the edhes along the
         path filled by BFS. Or we can say find the maximum flow
         through the path found. */
        if(flag!=0){
        for (int v = root; v != s; v = parent[v]) {
            int u = parent[v];
            if (u != s ) {
                path.add(u);
            
            }
            
        }
        
        Collections.reverse(path);
        Iterator itr = path.iterator();

        while (itr.hasNext()) {

            int v = (int) itr.next();
            int tr[][] = new int[20][20];
             for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if ((i == v) || (j == v)) {
                        tr[i][j] = 0;
                    } else {
                        tr[i][j] = rGraph[i][j];
                    }
                }

            }
            int Dom = bfs(tr,s,root,parent,len);
            if (Dom == 0) {
                singleDominators.add(v);
            }

        }
           
        singleDominators.add(root);
       
        }
        
        Iterator<Integer> abc;
        abc = singleDominators.listIterator();
        while(abc.hasNext())
        {
            int o=abc.next();
            System.out.println("Single dom: "+o);
        }
        System.out.println("end");
        
        
    }
    
    int bfs(int rgraph[][], int s, int t, int parent[],int len) {
        boolean visited[] = new boolean[len];
        for (int i = 0; i < len; i++) {
            visited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        int flag=0;

        while (queue.size() != 0) {
            int u = queue.poll();
            for (int v = 0; v < len; v++) {
                if (visited[v] == false && rgraph[u][v] > 0) {
                    if(v==t)
                        flag=1;
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                }
            }
        }
        return flag;
    }
    
}
