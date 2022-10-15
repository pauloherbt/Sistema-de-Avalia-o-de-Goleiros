package padrao;

import java.util.ArrayList;
import java.util.Random;

public class Gol {
	private ArrayList<Celula> celulas = new ArrayList<>();
	private ArrayList<Chute> chutes = new ArrayList<>();
	private ArrayList<Selecao> selecoes = new ArrayList<>();

	public void chuteAoGol() { // motor do jogo
		Celula caux = new Celula();
		for (Selecao selecao : selecoes) {
			for (Goleiro goleiro : selecao.getGoleiros()) {
				for (Chute ch : chutes) {
					caux = sortearPosicao(ch); // posicao inicial da aag para cada chute
					verificarGol(caux, ch, goleiro);

				}
			}
		}
	}

	public void verificarGol(Celula caux, Chute ch, Goleiro goleiro) { // verifica se o goleiro defendeu
		int x = caux.getX();
		int y = caux.getY();
		int count = 0, somador, n = goleiro.getAAG();
		boolean defesa = false;
		somador = n % 4 == 0 ? (n / 4) - 1 : (n / 4);
		Chute aux = new Chute(ch);
		do {
			if (count < 4) {
				if (x == ch.getX() && y == ch.getY()) {
					if (count == 3) { // verifica a ultima linha da aag
						if (goleiro.getPower() >= ch.getPower()) {
							defesa = true;
						} else { // caso a forca n seja suficiente
							goleiro.addGoldeForca();
							defesa = false;
						}

					} else if (y == caux.getY() + somador) { // verifica a ultima coluna da aag
						if (goleiro.getPower() >= ch.getPower()) {
							defesa = true;
						} else { // forca insuficiente
							goleiro.addGoldeForca();
							defesa = false;
						}
					} else
						defesa = true;

				}
				n--;
				count++;
				x = x > 0 ? x -= 1 : caux.getX();
			} else {
				x = caux.getX();
				y = y < 15 ? y += 1 : y;
				count = 0;
			}

		} while ((n > 0 && defesa == false));
		if (defesa == true) {
			aux.setRelacaoGol("Defesa");
			goleiro.addChute(aux);
		} else {
			aux.setRelacaoGol("Gol");
			goleiro.addChute(aux);
		}
	}

	public Celula sortearPosicao(Chute ch) {
		Random rd = new Random();
		Celula caux = new Celula();
		do {
			caux.setX(rd.nextInt(8));
			caux.setY(rd.nextInt(16));
			caux.verificarQuadrante();
		} while (caux.getQuadrante() != ch.getQuadrante());
		return caux;
	}

	// 1 questao
	public String mediaDefesas() {
		double media = 0;
		String total = "";
		for (Selecao se : selecoes) {
			int soma = 0;
			for (Goleiro go : se.getGoleiros()) {
				soma += go.contarDefesas();
			}
			media = (double) soma / se.getGoleiros().size();
			total += "\nSelecao: " + se.getNome() + "\nMedia de Defesas: " + String.format("%.2f", media);
		}
		return total;
	}

	// 2 questao
	public String informarPontuacao() {
		String result = "-------------------------\n" + "PONTUACAO DOS GOLEIROS";
		for (Selecao sel : selecoes) {
			result += "\nSelecao: " + sel.getNome() + "\n";
			int maior = 0;
			String nome = "";
			for (Goleiro gol : sel.getGoleiros()) {
				result += gol.getNome() + " Defesas: " + gol.contarDefesas() + "\n";
				if (gol.contarDefesas() > maior) {
					maior = gol.contarDefesas();
					nome = gol.getNome();

				}
			}
			result += "Goleiro titular indicado: " + nome + "\n";
		}
		return result;
	}

	// 3 questao
	public String mediaGolsTomados() {
		String result = "---------------------\nMEDIA DE GOLS TOMADOS POR SELECAO\n";

		for (Selecao sel : selecoes) {
			int soma = 0;
			double media = 0;
			for (Goleiro gol : sel.getGoleiros()) {
				soma += gol.contarGols();

			}
			media = (double) soma / sel.getGoleiros().size();
			result += sel.getNome() + ": " + String.format("%.2f", media) + "\n";
		}
		return result;
	}

	// questao 4 e 5
	public String mapearChutes() {
		String result = "";
		int te = 0, tr = 0, td = 0, fora = 0, angulo = 0;
		for (Chute ch : chutes) {
			ch.mapearPosicao();
			if (ch.getRelacaoGol().equals("TE"))
				te++;
			if (ch.getRelacaoGol().equals("TD"))
				td++;
			if (ch.getRelacaoGol().equals("TR"))
				tr++;
			if (ch.getRelacaoGol().equals("F"))
				fora++;
			if (ch.getRelacaoGol().equals("A"))
				angulo++;
		}
		return result = "---------------------------\n" + "RELACAO DE CHUTES\n" + "Trave Esquerda: " + te
				+ "\nTrave Direita: " + td + "\nTravessao: " + tr + "\nFora: " + fora + "\nAngulo:" + angulo;
	}

	// questao 6
	public String melhoresGoleiros() {
		int maior = 0, indexGoleiro = 0, indexSelecao = 0;
		ArrayList<Selecao> aux = selecoes;
		String result = "---------------------\nSelecao dos Melhores Goleiros";
		for (int i = 0; i < 3; i++) {
			maior = 0;
			for (Selecao sel : aux) {
				for (Goleiro gol : sel.getGoleiros()) {
					if (gol.contarDefesas() > maior) {
						maior = gol.contarDefesas();
						indexGoleiro = sel.getGoleiros().indexOf(gol);
						indexSelecao = aux.indexOf(sel);
					}
				}
			}
			result += "\n" + aux.get(indexSelecao).getNome() + " "
					+ aux.get(indexSelecao).getGoleiros().get(indexGoleiro).contarDefesas();
			aux.get(indexSelecao).getGoleiros().remove(indexGoleiro);
		}
		return result;
	}

	// questao 7
	public String golsPorForca() {
		int soma = 0;
		for (Selecao sel : selecoes) {
			for (Goleiro gol : sel.getGoleiros()) {
				soma += gol.getGolDeForca();
			}
		}
		return "--------------------------\nOCORRENCIAS DE GOLS POR FALTA DE FORCA DO GOLEIRO: " + soma;
	}

	// questao 8
	public String imprimirGoleiro() {
		String result = "----------------------------\nLISTA DE GOLEIROS:\nNome|Selecao|Gols defendidos|Golstomados|AAG";
		for (Selecao sel : selecoes) {
			for (Goleiro gol : sel.getGoleiros()) {
				result += "\n" + gol.getNome() + "|" + sel.getNome() + "|" + gol.contarDefesas() + "|" + gol.contarGols()
						+ "|" + gol.getAAG();
			}
		}
		return result;
	}

	// Questao 9
	public String BuscarGoleiro(int id) {
		String result = "";
		for (Selecao sel : selecoes) {
			for (Goleiro goleiro : sel.getGoleiros()) {
				if (id == goleiro.getId()) {
					result = "-------------------------------------\nGoleiro: " + goleiro.getNome() + " ID:"
							+ goleiro.getId() + "\nQuadrante que tomou mais gol:" + quadranteComMaisGols(goleiro);
				}
			}
		}
		return result;

	}// questao 10
//	public String imprimirMatriz() {
//		String result="";
//		for (Selecao sel : selecoes) {
//			for (Goleiro gol : sel.getGoleiros()) {
//				for (int i = 0; i < celulas.size(); i++) {
//					
//				}
//			}
//		}
//		
//	}

	public ArrayList<Celula> golRepetido(ArrayList<Chute> chutes) {
		ArrayList<Celula> golsRepetidos = new ArrayList<>();
		Celula aux;
		for (Chute ch : chutes) {
			for (Chute ch2 : chutes) {
				if (ch.getId() == ch2.getId()) {
					aux = new Celula();
					aux.setX(ch.getX());
					aux.setY(ch.getY());
					aux.AddQtdGol();
					golsRepetidos.add(aux);
				}
			}
		}
		return golsRepetidos;
	}

	public int quadranteComMaisGols(Goleiro goleiro) {
		int maior = 0, index = 0;
		int[] vet = new int[4];
		for (Chute ch : goleiro.getTotalDeChutes()) {
			if (ch.getRelacaoGol().equals("Gol")) {
				vet[ch.getQuadrante() - 1]++;
			}
		}
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] > maior) {
				maior = vet[i];
				index = i;
			}
		}
		return index + 1;
	}

	public void addSelecao(Selecao selecao) {
		this.selecoes.add(selecao);
	}

	public void addChute(Chute chute) {
		this.chutes.add(chute);
	}

	public void addCelula(Celula celula) {
		this.celulas.add(celula);
	}

	public ArrayList<Celula> getCelulas() {
		return celulas;
	}

	public ArrayList<Chute> getChutes() {
		return chutes;
	}

	public ArrayList<Selecao> getSelecoes() {
		return selecoes;
	}

}
