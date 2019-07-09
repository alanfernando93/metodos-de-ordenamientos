import java.io.*;
import java.util.Random;

class Met_ord_burbuja extends functions
{
    static void met_burbuja ()
    {
	int cont = 0;
	int aux;
	while (cont != (N * N))
	{
	    for (int i = 0 ; i < N ; i++)
	    {
		for (int j = 0 ; j < N ; j++)
		{
		    if ((j + 1) < N)
		    {
			if (M [i] [j] > M [i] [j + 1])
			{
			    aux = M [i] [j + 1];
			    M [i] [j + 1] = M [i] [j];
			    M [i] [j] = aux;
			}
			else
			{
			    cont = cont + 1;
			}
		    }
		    else
		    {
			if ((i + 1) < N)
			{
			    if (M [i] [j] > M [i + 1] [0])
			    {
				aux = M [i + 1] [0];
				M [i + 1] [0] = M [i] [j];
				M [i] [j] = aux;
			    }
			    else
			    {
				cont = cont + 1;
			    }
			}
			else
			{
			    cont = cont + 1;
			    if ((N * N) != cont)
			    {
				cont = 0;
			    }
			}
		    }
		}
	    }
	}
	Mat_acabada ();
    }


    static void init ()
    {
	/************************************/
	long startTime = System.currentTimeMillis ();
	/*********************************/
	System.out.println ("\n/////METODO DE ORDENACION POR BURBUJA/////");
	//llenado de matriz
	Llenar ();
	System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print ("\n\t*********************************");
	Imprimir ();
	System.out.print ("\n\t*********************************\n");
	System.out.println ("");
	/*********************************************/
	met_burbuja ();
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms\n");
	/*********************************************/
    }
}
