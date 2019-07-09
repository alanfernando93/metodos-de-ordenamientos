import java.io.*;
import java.util.Random;

class functions
{
    static int M[] [] = new int [50] [50];
    static Random matriz = new Random ();
    static int N, random = 63;
    static void Mat_acabada ()
    {
	System.out.println ("\n==================================================");
	System.out.println ("\n\t   MOSTRANDO LA MATRIZ ORDENADA");
	System.out.print ("\n\t*********************************");
	Imprimir ();
	System.out.print ("\n\t*********************************\n");
    }


    static void Imprimir ()
    {
	System.out.println ("\n");
	for (int i = 0 ; i < N ; i++)
	{
	    for (int j = 0 ; j < N ; j++)
	    {
		System.out.print ("\t|" + M [i] [j]);
	    }
	    System.out.println ("\t|");
	}
    }


    static void Llenar ()
    {

	do
	{
	    System.out.print ("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA (2 - 50): ");
	    N = leer.entero ();
	}
	while (N > 50 || N < 1);
	M = new int [N] [N];
	for (int i = 0 ; i < N ; i++)
	{
	    for (int j = 0 ; j < N ; j++)
	    {
		M [i] [j] = matriz.nextInt (63);
	    }
	}
    }
}
