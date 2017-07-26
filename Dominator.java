/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominator;

/**
 *
 * @author user11
 */
public class Dominator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SingleIDom g=new SingleIDom(6,5);
       g.addEdge(0,1);
       g.addEdge(0,2);
       g.addEdge(1,3);
       g.addEdge(2,3);
       g.addEdge(3,4);
       g.addEdge(4,5);
       
       g.SingleIDom(0);
       
        /*SingleIDom g=new SingleIDom(5,4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
         g.SingleIDom(0);*/
    }
    
}
