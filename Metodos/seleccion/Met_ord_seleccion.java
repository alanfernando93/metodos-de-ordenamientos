import java.util.Random;
import java.io.*;

class Met_ord_seleccion
{   
    static int b;
    static int M[][] = new int[50][50];
    static Random matriz = new Random();
    static int N;
    
    static void met_seleccion(){
	int cont = 0;
	int cont2=0;
	int aux,a;
	int c = N*N;
	int x,y,i,j,k;
	/*System.out.println("O R D E N A N D O  M A T R I Z  P O R  S E L E C C I O N");
	System.out.println("========
	================================================"); 
	System.out.println("\n  MOSTRANDO LA SUCESCION DE ORDENAMIENTO DE LA MATRIZ ");
	System.out.print("\n\t*********************************");
	Imprimir();
	System.out.print("\n\t*********************************");*/
	while(cont != c){
	    for(i=0;i<N;i++){                
		for(j=0;j<N;j++){
		    if(i==N-1 && j==N-1){
			cont = N*N;
		    }else{
			cont2 = 0;
			while(cont2!=c){
			    for(x = i;x<N;x++){  
				for(y=j+1;y<=N;y++){
				    if(y<N){
					if(M[i][j] > M[x][y]){
					    aux = M[i][j];
					    M[i][j] = M[x][y];
					    M[x][y] = aux;
					}
				    }else{
				    
					if(x+1<N && j>=0){
						for(k = 0;k<=j;k++){
						    if(M[i][j] > M[x+1][k]){
							aux = M[i][j];
							M[i][j] = M[x+1][k];
							M[x+1][k] = aux;
						    }
						}
					}else{    
					    if(x+1 == y){
						cont2 = N*N;
					    }
					}
				    }
				}
			    }
			}
			//Imprimir();
			//System.out.print("\n\t*********************************");
		    }
		}
	    }           
	}    
	Imprimir();
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
	System.out.print("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA: ");
	N = leer.entero();
	M = new int [N][N];
	for(int i=0;i<N;i++){
	    for(int j=0;j<N;j++){
		b = matriz.nextInt(101);
		M[i][j]=b;
	    }
	}
    }
    
    static void LeerDatos(){
	System.out.print("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA: ");
	N = leer.entero();
	M = new int [N][N];
	for(int i=0;i<N;i++){
	    for(int j=0;j<N;j++){
		System.out.print("elemento "+j+" : ");
		M[i][j]=leer.entero();
	    }
	}
    }
    
    public static void main(String args[])throws IOException{
    /************************************/
	long startTime = System.currentTimeMillis();
	/*********************************/
	//Llenar();
	int Nii[][] = {{15,56,24,58,48},
		     {23,25,12,15,28},
		     {30,56,42,15,96},
		     {94,10,58,11,25},
		     {10,25,69,34,85}};
	M = Nii;
	N=5;
	/*System.out.println("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	System.out.print("\n\t*********************************");
	Imprimir();
	System.out.print("\n\t*********************************\n");
	System.out.println("");*/
	met_seleccion(); 
	/*********************************************/
	long stopTime = System.currentTimeMillis();
	long elapsedTime = stopTime - startTime;
	System.out.println("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime*0.001+" ms");
	/*********************************************/
    }
}
