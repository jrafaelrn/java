/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**                                                                 **/
/**   Terceiro Exercício-Programa                                   **/
/**                                                                 **/
/**   <Jose Rafael Rodrigues Nascimento>                            **/
/**                                                                 **/
/**   <21/05/2020>                                                  **/
/*********************************************************************/

/*
	Jogo da Velha - programa para verificar o status de um jogo.
	
	Lista de Status calculado:
	0 - Jogo não iniciado: o tabuleiro está 'vazio', isto é sem peças X e O;
    1 - Jogo encerrado1: o primeiro jogador (que usa as peças X) é o ganhador;
    2 - Jogo encerrado2: o segundo jogador (que usa as peças O) é o ganhador;
    3 - Jogo encerrado3: empate - todas as casas do tabuleiro estão preenchidas com X e O, mas nenhum dos jogadores ganhou;
    4 - Jogo já iniciado e em andamento: nenhuma das alternativas anteriores.	
*/

public class EP03_JogoDaVelha {
	static final char pecaX = 'X';
	static final char pecaY = 'O';
	static final char espacoVazio = ' ';

	/*
		Determina o status de uma partida de Jogo da Velha
		
		Entrada:
			tabuleiro - matriz 3x3 de caracteres representando uma partida valida de Jogo da Velha
			
		Saída:
			um inteiro contendo o status da partida (valores válidos de zero a quatro)
	*/
	
	static int verificaStatus(char[][] tabuleiro) {
		int status = -1;
		int qtdVazios = 0;
		int i, j=0;	//Contadores
		
		
		
		//Laço para contar os espaços vazios 
		for (i=0; i<3; i++){		
		
			for(j=0; j<3; j++){
		
				if (tabuleiro[i][j] == espacoVazio)
					qtdVazios += 1;													
			
			}		
		}
		
		if (qtdVazios == 9)	//Se tudo estiver vazio, retorna '0'
			return (0);
		
		
		//Reinicia os contadores
		i=0;
		j=0;
		


		//Laço de repetição para percorrer as linhas
		for (i=0; i<3; i++){			
			
			//Verifica se a linha contém apenas 'X' ou 'O'
			if (tabuleiro[i][j] == pecaX && tabuleiro[i][j+1] == pecaX && tabuleiro[i][j+2] == pecaX)
					return (1);
		
				else if (tabuleiro[i][j] == pecaY && tabuleiro[i][j+1] == pecaY && tabuleiro[i][j+2] == pecaY)
							return (2);
		}			

		
		//Reinicia os contadores
		i=0;
		j=0;
		
	
		
		//Laço de repetição para percorrer as colunas
		for (j=0; j<3; j++){			
					
					//Verifica se a coluna contém apenas 'X' ou 'O'
					if (tabuleiro[i][j] == pecaX && tabuleiro[i+1][j] == pecaX && tabuleiro[i+2][j] == pecaX)
							return (1);
				
						else if (tabuleiro[i][j] == pecaY && tabuleiro[i+1][j] == pecaY && tabuleiro[i+2][j] == pecaY)
									return (2);	
		}



		//Verifica as diagonais			
		if ((tabuleiro[0][0] == pecaX && tabuleiro[1][1] == pecaX && tabuleiro[2][2] == pecaX) || 
			(tabuleiro[0][2] == pecaX && tabuleiro[1][1] == pecaX && tabuleiro[2][0] == pecaX ))
			return(1);
		
			else if ((tabuleiro[0][0] == pecaY && tabuleiro[1][1] == pecaY && tabuleiro[2][2] == pecaY) || 
					(tabuleiro[0][2] == pecaY && tabuleiro[1][1] == pecaY && tabuleiro[2][0] == pecaY))
					return(2);
		
					else 
						//Após passar por todas as validações possíveis, e os espaços estiverem preenchidos, retorna empate
						if(qtdVazios == 0)
							return(3);
						
							else return(4); // Se não, o jogo está em andamento
		
	}



	public static void main(String[] args) {
		// escreva seu código (para testes) aqui

		char[][] tab0 = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		char[][] tab1 = {{'X','X','X'},{'O','O',' '},{' ',' ',' '}};
		char[][] tab2 = {{'O','X','X'},{'X','O','O'},{' ',' ','O'}};
		char[][] tab3 = {{'O','X','X'},{'X','O','O'},{'O','X','X'}};
		char[][] tab4 = {{' ',' ',' '},{'X','O','X'},{' ',' ',' '}};
		char[][] tab5 = {{'O',' ','X'},{'O','X',' '},{'X',' ',' '}};
		char[][] tab6 = {{'X','X','O'},{'O','X','O'},{'X',' ','O'}};
		char[][] tab7 = {{'O','O','O'},{'X','X',' '},{'X',' ',' '}};
		char[][] tab8 = {{'O',' ','O'},{'X','X','X'},{' ',' ',' '}};
		char[][] tab9 = {{' ','O',' '},{'X','O','X'},{'X','O',' '}};
		char[][] tab10 = {{'O',' ','X'},{' ','O','X'},{'X',' ','O'}};
		char[][] tab11 = {{'X','X','O'},{'O','O','X'},{'X','O','X'}};
		char[][] tab12 = {{'X',' ',' '},{' ',' ','O'},{'X',' ',' '}};
		char[][] tab13 = {{'X',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		char[][] tab14 = {{'X','O',' '},{'O','X',' '},{'X',' ',' '}};
		
		desenha(tab0);
		System.out.println("Status calculado: " + verificaStatus(tab0));
		System.out.println("Status esperado para o tabuleiro0: 0\n");

		desenha(tab1);
		System.out.println("Status calculado: " + verificaStatus(tab1));
		System.out.println("Status esperado para o tabuleiro1: 1\n");
		
		desenha(tab2);
		System.out.println("Status calculado: " + verificaStatus(tab2));
		System.out.println("Status esperado para o tabuleiro2: 2\n");
		
		desenha(tab3);		
		System.out.println("Status calculado: " + verificaStatus(tab3));
		System.out.println("Status esperado para o tabuleiro1: 3\n");
		
		desenha(tab4);
		System.out.println("Status calculado: " + verificaStatus(tab4));
		System.out.println("Status esperado para o tabuleiro4: 4\n");
		
		desenha(tab5);
		System.out.println("Status calculado: " + verificaStatus(tab5));
		System.out.println("Status esperado para o tabuleiro5: 1\n");
		
		desenha(tab6);		
		System.out.println("Status calculado: " + verificaStatus(tab6));
		System.out.println("Status esperado para o tabuleiro6: 2\n");
		
		desenha(tab7);
		System.out.println("Status calculado: " + verificaStatus(tab7));
		System.out.println("Status esperado para o tabuleiro7: 2\n");
				
		desenha(tab8);
		System.out.println("Status calculado: " + verificaStatus(tab8));
		System.out.println("Status esperado para o tabuleiro8: 1\n");
				
		desenha(tab9);
		System.out.println("Status calculado: " + verificaStatus(tab9));
		System.out.println("Status esperado para o tabuleiro9: 2\n");
				
		desenha(tab10);
		System.out.println("Status calculado: " + verificaStatus(tab10));
		System.out.println("Status esperado para o tabuleiro10: 2\n");
		
		desenha(tab11);
		System.out.println("Status calculado: " + verificaStatus(tab11));
		System.out.println("Status esperado para o tabuleiro11: 3\n");
				
		desenha(tab12);
		System.out.println("Status calculado: " + verificaStatus(tab12));
		System.out.println("Status esperado para o tabuleiro12: 4\n");
		
		desenha(tab13);
		System.out.println("Status calculado: " + verificaStatus(tab13));
		System.out.println("Status esperado para o tabuleiro13: 4\n");
		
		desenha(tab14);
		System.out.println("Status calculado: " + verificaStatus(tab14));
		System.out.println("Status esperado para o tabuleiro14: 4\n");

	}
	
	static void desenha(char[][] tabuleiro){
		
		for (int x=0; x<3; x++){
			
			for (int y=0; y<3; y++){
			
				if(tabuleiro[x][y] == espacoVazio) 
					System.out.print("-  ");				
				else				
					System.out.print(tabuleiro[x][y] + "  ");
				
			}
			
			System.out.println();
		}
		
	}
}
