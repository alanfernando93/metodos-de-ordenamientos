import java.util.*;

class Met_ord_BinSort
{
    static int temp, N, fila, col, i, j, x, y, maxT = 50, cont, random = 64;
    static Random rmd = new Random ();
    static int pos[] [] = new int [maxT] [maxT], aux[] [] = new int [8] [8];
    static int M[] [] = new int [maxT] [maxT], tabla[] [] = new int [8] [8];

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
	for (i = 0 ; i < 8 ; i++)
	{
	    for (j = 0 ; j < 8 ; j++)
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
	for (i = 0 ; i < max ; i++)
	{
	    for (j = 0 ; j < max ; j++)
	    {
		aux [i] [j] = c;
		c++;
	    }
	}
    }


    static void Mat_acabada ()
    {
	System.out.println ("\n==================================================");
	System.out.println ("\n\t   MOSTRANDO LA MATRIZ ORDENADA");
	System.out.print ("\n\t*********************************");
	Imprimir (M);
	System.out.print ("\n\t*********************************\n");
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
		M [i] [j] = rmd.nextInt (random);
		pos [i] [j] = cont;
		cont++;
	    }
	}
    }


    public static void bucketSort (int max)
    {
	int z;
	generarTabla (max);

	for (int k = 0 ; k < cont ; k++)
	{
	    tablaAux (posicion (k));
	    tabla [fila] [col] += 1;
	}
	x = 0;
	y = 0;
	for (i = 0 ; i < max ; i++)
	{
	    for (j = 0 ; j < max ; j++)
	    {
		if (tabla [i] [j] != 0)
		{
		    int tam = tabla [i] [j];
		    for (z = 1 ; z <= tam ; z++)
		    {
			M [x] [y] = aux [i] [j];
			y++;
			if (y > N - 1)
			{
			    x++;
			    y = 0;
			}
		    }
		    if (y > N - 1)
		    {
			x++;
			y = 0;
		    }
		}
	    }
	    if (y > N - 1)
	    {
		x++;
		y = 0;
	    }
	}
	Mat_acabada ();
    }


    public static void main (String[] args)
    {
	N = leer.entero ();
	Llenar ();
	Imprimir (M);
	bucketSort (8);
    }
}


