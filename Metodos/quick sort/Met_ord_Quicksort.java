import java.util.Random;
import java.io.*;

class Met_ord_Quicksort
{
    static int temp, N, fila, col, i, j, x, y, pivote, indice, max = 50, cont;
    static Random rmd = new Random ();
    static int pos[] [] = new int [max] [max], M[] [] = new int[max][max];

    static void pivot (int init, int fin)
    {
	indice = init + (fin - init) / 2;
	pivote = posicion (indice);
    }

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


    static void QuickSort (int M[] [], int init, int fin)
    {
	if(M == null || M.length == 0)
	    return;
	if(init >= fin)
	    return;
	pivot (init, fin);
	i = init;
	j = fin;
	while (i <= j)
	{
	    while (posicion (i) < pivote)
	    {
		i++;
	    }
	    while (posicion (j) > pivote)
	    {
		j--;
	    }
	    if (i <= j)
	    {
		temp = posicion (i);
		x = fila;
		y = col;
		M [x] [y] = posicion (j);
		M[fila][col]=temp;
		i++;
		j--;
	    }
	}
	if (init < j)
	{
	    QuickSort (M, init, j);
	}
	if (fin > i)
	{
	    QuickSort (M, i, fin);
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
		M [i] [j] = rmd.nextInt (51);
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
	System.out.print ("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA: ");
	N = leer.entero ();
	//llenado de matriz
	Llenar ();
	//System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	//System.out.print ("\n\t*********************************");
	Imprimir (M);
	//System.out.print ("\n\t*********************************\n");
	//System.out.println ("");
	/*********************************************/        
	QuickSort (M, 0, cont - 1);
	Mat_acabada ();
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms");
	/*********************************************/
    }
}
