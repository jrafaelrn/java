/*********************************************************************/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**                                                                 **/
/**   Primeiro Exercício-Programa                                   **/
/**                                                                 **/
/**   <Jose Rafael Rodrigues Nascimento>                            **/
/**                                                                 **/
/**   <28/03/2020>                                                  **/
/*********************************************************************/

/*
	Caixa eletrônico das Ilhas Weblands, com estoque ilimitado de cédulas
	de B$50,00, B$10,00, B$5,00 e B$1,00.
*/

public class CaixaEletronico {
	// Número de cédulas de B$50,00
	static int n50;
	
	// Número de cédulas de B$10,00
	static int n10;

	// Número de cédulas de B$5,00
	static int n5;
	
	// Número de cédulas de B$1,00
	static int n1;

	
		/*
		Determina a quantidade de cada nota necessária para totalizar
		um determinado valor de retirada, de modo a minimizar a quantidade
		de cédulas entregues.
		
		Abastece as variáveis globais n50,n10, n5 e n1 com seu respectivo
		número de cédulas.
		
		Parâmetro:
			valor - O valor a ser retirado
		*/


	static void fazRetirada(int valor) {
	
		//Recece o valor em B$ a ser retirado atraves do parâmetro "valor"
		
		
		
		//Caso valor negativo, atualiza as variaveis e sai do método
		
		if (valor < 0){
			n50 = -1;
			n10 = -1;
			n5 = -1;
			n1 = -1;
			return;
		}
		
		
		
		//Caso seja positivo, o método continuará e efetuará o cálculo das notas em valor decrescente
		
		if (valor >= 50){
			n50 = valor/50;					//Faz a divisão inteira
			valor = valor-(n50*50);			//Desconta o valor já calculado para o próximo IF avaliar
		} else n50 = 0;						//Zera conforme solicitado
										
											//Mesma lógica para todos os IFs abaixo
		
			
				if (valor >= 10){
					n10 = valor/10;
					valor = valor-(n10*10);
				} else n10 = 0;
					
					
							if (valor >= 5){
								n5 = valor/5;
								valor = valor-(n5*5);
							} else n5 = 0;
							
								
									if (valor >= 1){
										n1 = valor;
										valor = valor-n1;
									} else n1 = 0;


	}
	

	
	
	public static void main(String[] args) {
	
		fazRetirada(66);

		System.out.println("Notas de 50: "+n50);
		System.out.println("Notas de 10: "+n10);
		System.out.println("Notas de 5:  "+n5);
		System.out.println("Notas de 1:  "+n1);
		System.out.println("\n\n");
												

	}
}
