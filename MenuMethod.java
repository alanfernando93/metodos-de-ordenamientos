class MenuMethod
{
    static Met_ord_burbuja burbuja = null;
    static Met_ord_insercion insercion = null;
    static Met_ord_seleccion seleccion = null;
    static Met_ord_Quicksort Quicksort = null; 
    static Met_ord_ShellSort ShellSort = null;
    static Met_ord_BinSort BinSort = null;
  
    static void select (int op)
    {
	switch (op)
	{
	    case 1:
		burbuja = new Met_ord_burbuja ();
		burbuja.init ();
		menu ();
		break;
	    case 2:
		insercion = new Met_ord_insercion ();
		insercion.init ();
		menu ();
		break;
	    case 3:
		seleccion = new Met_ord_seleccion ();
		seleccion.init ();
		menu ();
		break;
	    case 4:
		Quicksort = new Met_ord_Quicksort ();
		Quicksort.init ();
		menu ();
		break;
	    case 5:
		ShellSort = new Met_ord_ShellSort ();
		ShellSort.init ();
		menu ();
		break;
	    case 6:
		BinSort = new Met_ord_BinSort ();
		BinSort.init ();
		menu ();
		break;
	    case 7:
		System.out.println();
		System.out.println ("\t\t*************************");
		System.out.println ("\t\t*      Saliendo...      *");
		System.out.println ("\t\t*************************");
		System.exit (0);
		break;
	}
    }


    static void menu ()
    {
	int x;
	System.out.println ("*********//Menu de opciones//**********");
	System.out.println ("\t1.-Metodo Burbuja");
	System.out.println ("\t2.-Metodo de Insercion");
	System.out.println ("\t3.-Metodo de Seleccion");
	System.out.println ("\t4.-Metodo de Quick Sort");
	System.out.println ("\t5.-Metodo de Shell Sort");
	System.out.println ("\t6.-Metodo de Bin Sort");
	System.out.println ("\t7.-Salir");        
	do{
	    System.out.print ("Seleccione uno de los metodos de ordenacion (1 - 7): ");
	    x = leer.entero();
	}while(x > 7 || x < 1);
	select (x);
    }
}
