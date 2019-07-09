import java.io.*;
import java.util.Random;

class Met_ord_burbuja
{   
    static int b;
    static int M[][] = new int[50][50];
    static Random matriz = new Random();
    static int N;
    
    static void met_burbuja()
    {
	int cont = 0;
	int aux;
	System.out.println("O R D E N A N D O  M A T R I Z  P O R  B U R B U J A");
	System.out.println("===================================================="); 
	System.out.println("\n  MOSTRANDO LA SUCESCION DE ORDENAMIENTO DE LA MATRIZ ");
	System.out.print("\n\t*********************************");
	while(cont != (N*N)){
	    Imprimir();
	    System.out.print("\n\t*********************************");
	    for(int i=0;i<N;i++){
		for(int j=0;j<N;j++){
		    if((j+1)<N){
			if(M[i][j] > M[i][j+1]){
			    aux = M[i][j+1];
			    M[i][j+1] = M[i][j];
			    M[i][j] = aux;
			}else{
			    cont = cont + 1; 
			}
		    }else{
			if((i+1)<N){
			    if(M[i][j] > M[i+1][0]){
				aux = M[i+1][0];
				M[i+1][0] = M[i][j];
				M[i][j] = aux;
			    }else{
				cont = cont + 1; 
			    }
			}else{    
			    cont = cont + 1; 
			    if((N*N)!=cont){ 
				cont = 0;
			    }
			}
		    }
		}
	    }
	}
	Mat_acabada();
    }
    
    static void Mat_acabada(){
	System.out.println("\n==================================================");
	System.out.println("\n\t   MOSTRANDO LA MATRIZ ORDENADA");
	System.out.print("\n\t*********************************");
	Imprimir();
	System.out.print("\n\t*********************************\n");
    }
    
    static void Imprimir(){
	System.out.println("\n");
	for(int i=0;i<N;i++){
	    for(int j=0;j<N;j++){
		System.out.print("\t|"+M[i][j]);
	    }
	    System.out.println("\t|");
	}
    }
    
    static void Llenar(){
	for(int i=0;i<N;i++){
	    for(int j=0;j<N;j++){
		b = matriz.nextInt(101);
		M[i][j]=b;
	    }
	}
    }
    
    static void LeerDatos(){
	for(int i=0;i<N;i++){
	    for(int j=0;j<N;j++){
		System.out.println("elemento "+j+" : ");
		M[i][j]=leer.entero();
	    }
	}
    }
    
    public static void main(String arg[])throws IOException{
	/************************************/
	long startTime = System.currentTimeMillis();
	/*********************************/
	System.out.print("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA: ");
	N = leer.entero();
	M = new int [N][N];
	//llenado de matriz
	Llenar();
	System.out.println("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print("\n\t*********************************");
	Imprimir();
	System.out.print("\n\t*********************************\n");
	System.out.println("");
	/*********************************************/
	met_burbuja();
	long stopTime = System.currentTimeMillis();
	long elapsedTime = stopTime - startTime;
	System.out.println("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime*0.001+" ms");
	/*********************************************/
    }
}
