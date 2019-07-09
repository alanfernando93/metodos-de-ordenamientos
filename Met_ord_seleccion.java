import java.util.Random;
import java.io.*;

class Met_ord_seleccion extends functions
{
    static void met_seleccion ()
    {
	int cont = 0;
	int cont2 = 0;
	int aux, a;
	int c = N * N;
	int x, y, i, j, k;
	while (cont != c)
	{
	    for (i = 0 ; i < N ; i++)
	    {
		for (j = 0 ; j < N ; j++)
		{
		    if (i == N - 1 && j == N - 1)
		    {
			cont = N * N;
		    }
		    else
		    {
			cont2 = 0;
			while (cont2 != c)
			{
			    for (x = i ; x < N ; x++)
			    {
				for (y = j + 1 ; y <= N ; y++)
				{
				    if (y < N)
				    {
					if (M [i] [j] > M [x] [y])
					{
					    aux = M [i] [j];
					    M [i] [j] = M [x] [y];
					    M [x] [y] = aux;
					}
				    }
				    else
				    {

					if (x + 1 < N && j >= 0)
					{
					    for (k = 0 ; k <= j ; k++)
					    {
						if (M [i] [j] > M [x + 1] [k])
						{
						    aux = M [i] [j];
						    M [i] [j] = M [x + 1] [k];
						    M [x + 1] [k] = aux;
						}
					    }
					}
					else
					{
					    if (x + 1 == y)
					    {
						cont2 = N * N;
					    }
					}
				    }
				}
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
	System.out.println ("\n/////METODO DE ORDENACION POR SELECCION/////");
	//llenado de matriz
	Llenar ();
	System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print ("\n\t*********************************");
	Imprimir ();
	System.out.print ("\n\t*********************************\n");
	System.out.println ("");
	met_seleccion ();
	/*********************************************/
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms\n");
	/*********************************************/
    }
}
