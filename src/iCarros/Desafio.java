package iCarros;

import java.io.IOException;
import java.util.Scanner;

public class Desafio {
	
	private static int x;
    private static int y;
    private static char direcao;
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero da questao.");
		int i = sc.nextInt();
		while (i > 0) {
			switch (i) {
			case 1:
				System.out.println("Questão 1 - Fizzing 'n buzzing");
				fizzBuzz();
				break;
			case 2:
				System.out.println("Questão 2 - Angry Marvin Birds");
				String[] resultado = { "*--", "***", "----", "*-*" };
				int totalEstrelas = contarEstrelas(resultado);

				System.out.println("Total de Estrelas: " + totalEstrelas);
				break;
			case 3:
				System.out.println("Questão 3 - Creepy hours");
				String[] momentos = { "11:00", "13:13", "10:00" };

				int alarmes = contarMomentosAssustadores(momentos);

				System.out.println(alarmes);
				break;
			case 4:
				System.out.println("Questão 4 - We are the champions, my friend");
				int[] vitorias = { 1, 0, 3 };
				int[] empates = { 2, 2, 0 };
				int championPoints = getPontosLiga(vitorias, empates);
				System.out.println(championPoints);
				break;
			case 5:
				System.out.println("Questão 5 - Venting the costs");
				System.out.println("O arquivo está no diretorio ./sql/Query.sql");
				break;
			case 6:
				System.out.println("Questão 6 – Consume WS-Rest");
				SextaQuestao.respostaSextaQuestao();
				break;
			case 7:
				System.out.println("Questão 7 – MarsRover");
				// Obtém as dimensões do platô
		        x = 1;
		        y = 2;
		        direcao = 'N';
		        // Obtém as posições e as instruções de cada rover
		        // Move o robô
		        instrucoes("LMLMLMLMM");
		        // Imprime a posição final do robô
		        System.out.println("Rover 1 Position: " + getPosicao());
		        
		        x = 3;
		        y = 3;
		        direcao = 'E';
		        // Obtém as posições e as instruções de cada rover
		        // Move o robô
		        instrucoes("MMRMMRMRRM");
		        // Imprime a posição final do robô
		        System.out.println("Rover 2 Position: " + getPosicao());
				break;
			default:
				break;
			}

			System.out.println("Digite o numero da questao de 1 a 7 ou digite 0 para sair.");
			i = sc.nextInt();

			if (i == 0)
				System.out.println("Até mais.");
		}

		sc.close();
	}

	// Este método imprime os números de 1 a 100,
	// substituindo os múltiplos de 3 por "Fizz",
	// os múltiplos de 5 por "Buzz"
	// e os múltiplos de 3 e 5 por "FizzBuzz".
	public static void fizzBuzz() {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	// Este método calcula o número de pontos de uma liga.
	public static int getPontosLiga(int[] vitorias, int[] empates) {
		int pontosLiga = 0;
		for (int i = 0; i < vitorias.length; i++) {
			int pontos = vitorias[i] * 3 + empates[i];
			if (pontos > pontosLiga) {
				pontosLiga = pontos;
			}
		}
		return pontosLiga;
	}

	// Este método conta o número de momentos assustadores em um array de strings.
	public static int contarMomentosAssustadores(String[] momentos) {
		int alarmes = 0;

		// Itera pelo array de strings.
		for (String momento : momentos) {
			// pega os dois primeiros digitos
			int hora = Integer.parseInt(momento.substring(0, 2));
			// pega os dois ultimos digitos
			int minuto = Integer.parseInt(momento.substring(3, 5));

			if (hora == minuto) {
				alarmes++;
			} else if (hora / 10 == minuto % 10) {
				// se a hora dividida por 10 igual a 1 e o resto da divisão de minutos por 10
				// for 1
				alarmes++;
			} else if (hora % 10 == minuto / 10) {
				// se resto da divisão de minutos por 10 for 1 e a hora dividida por 10 igual a
				// 1
				alarmes++;
			}
		}
		return alarmes;
	}

	// Este método conta o número de estrelas em um array de strings.
	public static int contarEstrelas(String[] resultados) {
		int estrelas = 0;

		// Itera pelo array de strings.
		for (String resultadoDeEtapa : resultados) {
			// Itera pelos caracteres na string.
			for (char c : resultadoDeEtapa.toCharArray()) {
				// Se o caractere for uma estrela, aumente o contador `estrelas` em 1.
				if (c == '*') {
					estrelas++;
				}
			}
		}
		return estrelas;
	}

    public static void instrucoes(String instrucoes) {
        for (char instrucao : instrucoes.toCharArray()) {
            switch (instrucao) {
                case 'L':
                    esquerda();
                    break;
                case 'R':
                    direita();
                    break;
                case 'M':
                    mover();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + instrucao);
            }
        }
    }

    private static void esquerda() {
        switch (direcao) {
            case 'N':
                direcao = 'W';
                break;
            case 'W':
                direcao = 'S';
                break;
            case 'S':
                direcao = 'E';
                break;
            case 'E':
                direcao = 'N';
                break;
        }
    }

    private static void direita() {
        switch (direcao) {
            case 'N':
                direcao = 'E';
                break;
            case 'E':
                direcao = 'S';
                break;
            case 'S':
                direcao = 'W';
                break;
            case 'W':
                direcao = 'N';
                break;
        }
    }

    private static void mover() {
        switch (direcao) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }

    public static String getPosicao() {
        return x + " " + y + " " + direcao;
    }

}
