import java.io.*;
import java.util.Random;

class Met_ord_insercion extends functions
{
    static int aux, x, y, i, j, p, q, a, cont = 0;

    static void met_insercion ()
    {
	for (i = 0 ; i < N ; i++)
	{
	    for (j = 1 ; j <= N ; j++)
	    {
		if (j < N)
		{
		    p = j;
		    aux = M [i] [j];
		    for (x = i ; x >= 0 ; x--)
		    {
			q = x;
			if (p != 0)
			{
			    for (y = j - 1 ; y >= 0 ; y--)
			    {
				if (aux < M [x] [y])
				{
				    M [x] [p] = M [x] [y];
				    p = p - 1;
				}
				else
				{
				    x = 0;
				    y = 0;
				}
			    }
			}
			else
			{
			    for (y = N - 1 ; y >= 0 ; y--)
			    {
				if (p == 0)
				{
				    if (aux < M [x] [y])
				    {
					M [x + 1] [p] = M [x] [y];
					p = N - 1;
				    }
				    else
				    {
					q = x + 1;
					x = 0;
					y = 0;
				    }
				}
				else
				{
				    if (aux < M [x] [y])
				    {
					M [x] [p] = M [x] [y];
					p = p - 1;
				    }
				    else
				    {
					x = 0;
					y = 0;
				    }
				}
			    }
			}
		    }
		    M [q] [p] = aux;
		}
		else
		{
		    if (i + 1 < N)
		    {
			p = 0;
			aux = M [i + 1] [p];
			for (x = i ; x >= 0 ; x--)
			{
			    q = x;
			    for (y = N - 1 ; y >= 0 ; y--)
			    {
				if (p == 0)
				{
				    if (aux < M [x] [y])
				    {
					M [x + 1] [p] = M [x] [y];
					p = N - 1;
				    }
				    else
				    {
					q = x + 1;
				    }
				}
				else
				{
				    if (aux < M [x] [y])
				    {
					M [x] [p] = M [x] [y];
					p = p - 1;
				    }
				    else
				    {
					x = 0;
					y = 0;
				    }
				}
			    }
			}
			M [q] [p] = aux;
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
	System.out.println ("\n/////METODO DE ORDENACION POR INSERCION/////");
	//llenado de matriz
	Llenar ();
	System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print ("\n\t*********************************");
	Imprimir ();
	System.out.print ("\n\t*********************************\n");
	System.out.println ("");
	met_insercion ();
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms\n");
	/*********************************************/
    }
}
