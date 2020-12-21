
/**
 * La clase representa a una lista de 
 * números enteros
 * 
 * @author - Carla Barberia
 * 
 */
import java.util.Arrays;

public class ListaNumeros 
{
    private int [] lista;
    private int pos;
    /**
     * Constructor de la clase ListaNumeros 
     * Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        this.lista = new int[n];
        this.pos = 0;
    }

    /**
     * Añade un valor siempre al principio de la lista
     * 
     * @param numero el valor que se añade. No se hace nada si la lista está
     *               completa
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if(!estaCompleta()){
            lista[pos] = numero;
            pos++;
            return true;
        }
        return false;
    }

    /**
     * devuelve true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {
        return pos == lista.length;
    }

    /**
     * devuelve true si la lista está vacía, false en otro caso. 
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;
    }

    /**
     * devuelve el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;
    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        pos = 0;
    }

    /**
     * Representación textual de la lista de la forma indicada 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
        String str = ""; 
        if(estaVacia() == true){
            return "";
        }else{
            for(int i = 0; i < pos;i++){
                str = str + String.format("%8d", lista[i]);
            }
            str += "\n";
            for(int i = 0; i < pos;i++){
                str = str + String.format("%8d", i);
            }
        }
        return str;
    }    

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * Búsqueda lineal de numero en la lista
     * @param numero el nº a buscar
     * @return un array con las posiciones en las que se ha encontrado
     *  
     */
    public int[] buscarPosicionesDe(int numero) {
        int [] encontrar = new int[lista.length]; 
        int contador = 0;
        for(int i = 0; i < pos;i++){
            if(lista[i] == numero){
                encontrar[contador] = i;
                contador++;
            }
        }
        return encontrar;
    }

    /**
     * Hace una búsq ueda binaria del numero indicado devolviendo -1 si no se
     * encuentra o la posición en la que aparece
     * 
     * El array original lista no se modifica 
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     * 
     * Usa exclusivamente métodos de la clase Arrays
     * 
     */
    public int buscarBinario(int numero) {
        int[] arrayOrden = Arrays.copyOf(lista, pos);
        Arrays.sort(arrayOrden);
        int contador = 0;
        for(int i = 0; i < lista.length;i++){
            if(ListaNumeros[i] == numero){
                contador++;
            }
        }
        if(contador == 0){
            return Arrays.binarySearch(arrayOrden, numero);
        }else{
            return contador;
        }
    }

    /**
     * borra el primer elemento de la lista
     */
    public void borrarPrimero() {
        for (int i = 0; i < pos; i++){
            lista[i] = lista[i + 1];
            pos--;
        }
    }

    /**
     *  Invierte cada uno de los grupos de n elementos que hay en lista
     *  
     *  Si el nº de elementos en lista no es divisible entre n los elementos restantes 
     *  quedan igual
     *  
     *  (leer enunciado)
     *  
     */
    public void invertir(int n) {
        int grupo = lista.length / n;
        int residuo = lista.length % n;
        int j = n;
        int aux = 0;
        int contador = 1;
        while(contador <= grupo + 1){
            j = n * contador;
            for(int i = j - n; i <= j;i++){
                aux = lista[i];
                lista[i] = lista[j];
                lista[j] = aux;
                j--;
            }
            contador++;
        }
    }

    /**
     * devuelve un ragged array de 2 dimensiones con tantas filas como valores
     * tenga el atributo lista y rellena el array de la forma indicada
     * (leer enunciado)
     * 
     */
    public int[][] toArray2D() {
        int[][] ragged = new int[lista.length][];
        for (int i = 0; i < ragged.length; i++) {
            ragged[i] = new int[i + 1];
            ragged[i][0] = 1;
            ragged[i][ragged[i].length - 1] = 0;
            }
        return ragged;
        }        

    /**
     * Punto de entrada a la aplicación 
     * Contiene código para probar los métodos de ListaNumeros
     */
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(20);

        System.out.println("--- addElemento() y toString() -------");
        int[] valores = {21, -5, 6, -7, 21, -17, 21, 15, 22, 21, 77};
        for (int i = 0; i < valores.length; i++) {
            lista.addElemento(valores[i]);
        }
        System.out.println(lista.toString());

        System.out.println("--- buscarPosiciones() -------");
        int numero = 21;
        System.out.println(lista.toString());
        System.out.println("\t" + numero + " aparece en posiciones");
        // seguir completando

    }
}
