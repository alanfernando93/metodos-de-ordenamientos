import java.io.*;
import java.util.Random;

class Met_ord_insercion
{
    static int N;
    static int[][] M = new int [50][50];
    static int aux,x,y,i,j,p,q,a,cont = 0;
    static Random matriz = new Random();
    
    static void met_insercion(){
	
	System.out.println("O R D E N A N D O  M A T R I Z  P O R  I N S E R C I O N");
	System.out.println("========================================================"); 
	System.out.println("\n  MOSTRANDO LA SUCESCION DE ORDENAMIENTO DE LA MATRIZ ");
	System.out.print("\n\t*********************************");
	
	for(i=0;i<N;i++){    
	    for(j=1;j<=N;j++){
		if(j<N){
		    p = j;
		    aux=M[i][j];
		    
		    for(x=i;x>=0;x--){
			q = x;
			if(p!=0){
			    for(y=j-1;y>=0;y--){
				if(aux < M[x][y]){
				    M[x][p] = M[x][y];
				    p = p - 1;
				}else{
				    x = 0;
				    y = 0;
				}
			    }
			}else{
			    for(y=N-1;y>=0;y--){
				if(p==0){
				    if(aux < M[x][y]){
					M[x+1][p] = M[x][y];
					p = N - 1;
				    }else{
					q = x + 1;
					x = 0;
					y = 0;
				    }
				}else{
				    if(aux < M[x][y]){
					M[x][p] = M[x][y];
					p = p - 1;
				    }else{
					x = 0;
					y = 0;
				    }
				}
			    }
			}
		    }
		    M[q][p]=aux;
		    //Imprimir();
		    //System.out.print("\n\t*********************************");
		}else{
		    if(i+1<N){
			p = 0;
			aux=M[i+1][p];
			for(x=i;x>=0;x--){
			    q = x;
			    for(y=N-1;y>=0;y--){
				if(p==0){
				    if(aux < M[x][y]){
					M[x+1][p] = M[x][y];
					p = N-1;
				    }else{
					q = x + 1;
				    }
				}else{
				    if(aux < M[x][y]){
					M[x][p] = M[x][y];
					p = p-1;
				    }else{
					x = 0;
					y = 0;
				    }
				}
			    }
			}
			M[q][p]=aux;
			//Imprimir();
			//System.out.print("\n\t*********************************");
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
		a = matriz.nextInt(51);
		M[i][j]=a;
	    }
	}
    }
    
    static void LeerDatos(){
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
	System.out.print("INGRESE LA DIMENSION DE LA MATRIZ CUADRADA: ");
	N = leer.entero();
	M = new int [N][N];
	//llenado de matriz
	Llenar();
	//System.out.println("\n\t MOSTRANDO LA MATRIZ DESORDENADA ");
	//System.out.print("\n\t*********************************");
	Imprimir();
	//System.out.print("\n\t*********************************\n");
	//System.out.println("");
	met_insercion(); 
	long stopTime = System.currentTimeMillis();
	long elapsedTime = stopTime - startTime;
	System.out.println("\nEL TIEMPO DE EJECUCION ES : " + elapsedTime*0.001+" ms");
	/*********************************************/
    }
}
