/*********************************************************************/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**                                                                 **/
/**   Segundo Exercício-Programa                                    **/
/**                                                                 **/
/**   <Jose Rafael Rodrigues Nascimento>                            **/
/**                                                                 **/
/**   <23/04/2020>                                                  **/
/*********************************************************************/

public class EP02_Raiz {
	/*
		Calcula a raiz quadrada de um valor, com uma determinada
		precisão. Retorna esse valor, ou -1 quando:
		
		* a < 0
		* epsilon <= 0
		* epsilon >= 1
		
		Parâmetro:
			a - valor cuja raiz quadrada será calculada
			epsilon - precisão do cálculo
	*/
	
	
	static double raizQuadrada(double a, double epsilon) {

		
		// Os valores recebidos pelos parâmetros são validados no início
		if (a < 0 || epsilon <= 0 || epsilon >= 1)
			return(-1);
		
		//Retorno padrão para raiz de 0
		if (a == 0)
			return (0);
				
				
				//Método de Newton
				
				else {
					
					double x0, x1;		//variavel temporaria para calculo
					
					//Calculos iniciais 							
					x0 = a/2;
					x1 = (x0+(a/x0))/2;					

					
							//Laço de repetição enquanto o valor absoluto da diferença respeitar o método
							while (absoluto(x1, x0) >= epsilon) {
								
								x0 = x1;
								x1 = (x0+(a/x0))/2;	
								
							} 
																
							//Retorno do último valor após sair do loop, conforme definição do método
							return(x1);
				}

				



	}
	
	static double absoluto(double a, double b){
		//Método para calcular o valor absoluto da diferença entre dois números
		
		if ((a-b) < 0)				//Se a diferença for negativa
			return (-(a-b));		//Retornará a diferença com sinal invertido
				else
					return (a-b);	//Caso contrário, retorna a própria diferença
		
	}



	public static void main(String[] args) {

		// Exemplo de teste:
		double valor[] = {-1, -1, -1, 0, 0, 0, 0, 1, 2, 3, 4, 9, 63, 81, 100};
		double precisao[] = {0, 0.01, -1, 0.01, -1 , 0, 0.001, 0.001, 0.0001, 0.001,0.001, 0.001, 0.001, 0.9999, 1};
		
		for (int i=0; i<15; i++){
				System.out.println("Raiz de: "+valor[i]+" com precisao de "+ precisao[i]+" = "+raizQuadrada(valor[i], precisao[i])+"\n\n");
		
		}
		

	}
}
