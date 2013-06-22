/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8queens;

/**
 *
 * @author uzielgl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tablero t = new Tablero();
        
        System.out.println(t.bidimensional() ) ;
        System.out.println( "Ataques : " + t.getCalidad() );
    }
}
