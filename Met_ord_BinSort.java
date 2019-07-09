import java.io.*;

class Met_ord_BinSort extends functions
{
    static int fila, col, x, y, maxT = 50, cont;
    static int aux[] [] = new int [8] [8];
    static int pos[] [] = new int [maxT] [maxT];
    static int tabla[] [] = new int [8] [8];

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
	return M [fila] [col];
    }


    static void tablaAux (int indice)
    {
	for (int i = 0 ; i < 8 ; i++)
	{
	    for (int j = 0 ; j < 8 ; j++)
	    {
		if (aux [i] [j] == indice)
		{
		    fila = i;
		    col = j;
		}
	    }
	}
    }


    static void generarTabla (int max)
    {
	int c = 0;
	for (int i = 0 ; i < max ; i++)
	{
	    for (int j = 0 ; j < max ; j++)
	    {
		aux [i] [j] = c;
		tabla [i] [j] = 0;
		c++;
	    }
	}
    }


    static void Cargar ()
    {
	cont = 0;
	for (int i = 0 ; i < N ; i++)
	{
	    for (int j = 0 ; j < N ; j++)
	    {
		pos [i] [j] = cont;
		cont++;
	    }
	}
    }


    static void bucketSort (int max)
    {
	int z, k, op, matriz[] [] = new int [N] [N];
	generarTabla (max);

	for (k = 0 ; k < cont ; k++)
	{
	    op = posicion (k);
	    tablaAux (op);
	    tabla [fila] [col] += 1;
	}
	try
	{
	    x = 0;
	    y = 0;
	    for (int i = 0 ; i < max ; i++)
	    {
		for (int j = 0 ; j < max ; j++)
		{
		    if (tabla [i] [j] != 0)
		    {
			for (z = 1 ; z <= tabla [i] [j] ; z++)
			{
			    matriz [x] [y] = aux [i] [j];
			    y++;
			    if (y > N - 1)
			    {
				x++;
				y = 0;
			    }
			}
		    }
		}
	    }
	}
	catch (Exception e)
	{
	    System.out.print ("Error: ");
	}
	M = matriz;
	Mat_acabada ();
    }


    static void init ()
    {
	/************************************/
	long startTime = System.currentTimeMillis ();
	/*********************************/
	System.out.println ("\n/////METODO DE ORDENACION POR CASILLAS(Bucket Sort o Bin Sort)/////");
	Llenar ();
	Cargar ();
	System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print ("\n\t*********************************");
	Imprimir ();
	System.out.print ("\n\t*********************************\n");
	System.out.println ("");
	bucketSort (8);
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms\n");
	/*********************************************/
    }
}


