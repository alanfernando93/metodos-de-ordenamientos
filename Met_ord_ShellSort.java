import java.util.Random;
import java.io.*;

class Met_ord_ShellSort extends functions
{
    static int temp, fila, col, x, y, max = 50, cont;
    static int pos[] [] = new int [max] [max];

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


    static void shellSort (int data[] [], int len)
    {
	int inner, outer, aux;
	//find initial value of h
	int h = 1;
	while (h <= len / 3)
	{
	    h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
	}
	while (h > 0) // decreasing h, until h=1
	{
	    // h-sort the file
	    for (outer = h ; outer <= len ; outer++)
	    {
		temp = posicion (outer);
		inner = outer;
		// one subpass (eg 0, 4, 8)
		while (inner > h - 1 && posicion (inner - h) >= temp)
		{
		    posicion (inner);
		    data [fila] [col] = posicion (inner - h);
		    inner = inner - h;
		}
		posicion (inner);
		data [fila] [col] = temp;
	    }
	    h = (h - 1) / 3; // decrease h
	}
	Mat_acabada ();
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


    static void init ()
    {
	/************************************/
	long startTime = System.currentTimeMillis ();
	/*********************************/
	System.out.println ("\n/////METODO DE ORDENACION SHELL(SHELL SORT)/////");
	Llenar ();
	Cargar();
	System.out.println ("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print ("\n\t*********************************");
	Imprimir ();
	System.out.print ("\n\t*********************************\n");
	System.out.println ("");
	shellSort (M, cont - 1);
	long stopTime = System.currentTimeMillis ();
	long elapsedTime = stopTime - startTime;
	System.out.println ("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime * 0.001 + " ms\n");

    }
}
