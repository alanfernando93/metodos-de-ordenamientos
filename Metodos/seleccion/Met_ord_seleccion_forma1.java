import java.util.Random;
import java.io.*;

class Met_ord_seleccion_forma1
{
    static int temp, N, fila, col, i, j, x, y, pivote, indice, max = 50, cont;
    static Random rmd = new Random ();
    static int pos[] [] = new int [max] [max], M[] [] = new int[max][max];

    static int posicion (int indice)
    {
	for (int f = 0 ; f < N ; f++)
	{
	    for (int c = 0 ; c < N ; c++)
	    {
		if (pos [f] [c] == indice)
		{
		    fila = f;
		    col = c;
		}
	    }
	}
	return M[fila][col];
    }


    static void seleccion(int A[][],int tope) {
	  int i, j, menor, pos, tmp;
	  for (i = 0; i <= tope ; i++) { // tomamos como menor el primero
		menor = posicion(i); // de los elementos que quedan por ordenar
		indice = i; // y guardamos su posición
		for (j = i + 1; j <= tope; j++){ // buscamos en el resto
		      if (posicion(j) < menor) { // del array algún elemento
			  menor = posicion(j); // menor que el actual
			  indice = j;
		      }
		}
		if (indice != i){ // si hay alguno menor se intercambia
		    tmp = posicion(i);
		    x=fila;y=col;
		    M[x][y] = posicion(indice);
		    M[fila][col] = tmp;
		}
	  }
    }


    static void Mat_acabada ()
    {
	/*System.out.println ("\n==================================================");
	System.out.println ("\n\t   MOSTRANDO LA MATRIZ ORDENADA");
	System.out.print ("\n\t*********************************");*/
	Imprimir (M);
	//System.out.print ("\n\t*********************************\n");
    }


    static void Imprimir (int Matriz[] [])
    {
	System.out.println ("\n");
	for (int i = 0 ; i < N ; i++)
	{
	    for (int j = 0 ; j < N ; j++)
	    {
		System.out.print ("\t|" + Matriz [i] [j]);
	    }
	    System.out.println ("\t|");
	}
    }


    static void Llenar ()
    {
	cont = 0;
	for (int i = 0 ; i < N ; i++)
	{
	    for (int j = 0 ; j < N ; j++)
	    {
		//M [i] [j] = rmd.nextInt (51);
		pos [i] [j] = cont;
		cont++;
	    }
	}
    }


    static void LeerDatos ()
    {
	for (int i = 0 ; i < N ; i++)
	{
	    for (int j = 0 ; j < N ; j++)
	    {
		System.out.println ("elemento " + j + " : ");
		M [i] [j] = leer.entero ();
	    }
	}
    }


    public static void main (String arg[]) throws IOException
    {
	/************************************/
	long startTime = System.currentTimeMillis ();
	/*********************************/
	//System.out.print ("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA: ");
	//N = leer.entero ();
	//llenado de matriz
	N=5;
	Llenar ();
	int Nii[][] = {{15,56,24,58,48},
		     {23,25,12,15,28},
		     {30,56,42,15,96},
		     {94,10,58,11,25},
		     {10,25,69,34,85}};
	M = Nii;
	//System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	//System.out.print ("\n\t*********************************");
	Imprimir (M);
	//System.out.print ("\n\t*********************************\n");
	//System.out.println ("");
	/*********************************************/        
	seleccion (M, cont - 1);
	Mat_acabada ();
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms");
	/*********************************************/
    }
}
