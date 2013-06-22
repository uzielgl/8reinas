/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg8queens
/**
 *
 * @author uzielgl
 */
class Tablero implements Comparable<Tablero>{
    public ArrayList<Integer> queens = new ArrayList<Integer>();
    
    public Tablero(){
        queens = [1,2,3,4,5,6,7,8]; 
        Collections.shuffle( queens );
        //queens = [5,2,1,4,6,8,7,3]; //4 ataques
        //queens = [2,3,7,6,4,1,5,8]; // 2 ataques
        //queens = [6,5,4,3,8,1,2,7]; // 5 ataques
        //queens = [1,7,5,3,6,4,8,2]; // 2 ataques
    }
    
    public String toString(){
        return queens.toString() + " calidad: " + getCalidad();
    }
    
    /** Regresa el total de ataques en el tablero, sólo el primer ataque de 
     * izquierda a derecha, barriendo todas las posiciones
     * */
    public int getCalidad(){
        def ataques = 0;
        for( i in 0..7){
            for( def j=i+1; j < 8; j++){
                def m = get_pendiente(i, j);
                //println m
                if(  m == 1 || m == -1 ){
                    ataques++;
                    break;
                }
            }
        }
        return ataques;
    }
    
    /* Obtienen el angulo entre dos posiciones del tablero [x,x,x,x,x,x,x,x] (dos de esas X)
     * para convertirlo a puntos cardinales, la posición es la X y el valor en la posición -1 es la Y
     **/
    public get_pendiente( pos1, pos2 ){
        def m = ( queens[ pos2 ] - queens[ pos1 ] ) / ( ( pos2 + 1 ) - ( pos1 +1 ) );
        /*
        println "" + ( pos1+1 ) + ", " + queens[pos1];
        println "" + ( pos2+1 ) + ", " + queens[pos2];
        println Math.toDegrees(Math.atan( m ));
        println m
        println ""
        */
        return m;
    }
    
    public String bidimensional(){
        def String[][] tablero = new String[8][8];
        for( i in 0..7){
            for ( j in 0..7)
                tablero[i][j] = "0";
        }
        
        for( i in 0..7){
            tablero[ queens[i] - 1 ][i] = "X";
        }
        
        //Armamos la cadena
        String t = "";
        for( String[] tab: tablero)
            t += tab.toString() + "\n";
        
        return t.toString();
    }
    
    /** Lo ordena de menor a mayor considerando su número de ataques*/
    public int compareTo( Tablero otroTablero ){
        return getCalidad() - otroTablero.getCalidad();
    }
}

