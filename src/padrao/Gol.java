package padrao;

import java.util.ArrayList;
import java.util.Random;

public class Gol {
	private ArrayList<Celula> celulas = new ArrayList<>();
	private ArrayList<Chute> chutes = new ArrayList<>();
	private ArrayList<Selecao> selecoes = new ArrayList<>();

	public void chuteAoGol() { // motor do jogo
		for (Selecao selecao : selecoes) {
			for (Goleiro goleiro : selecao.getGoleiros()) {
				for (Chute ch : chutes) {
					Celula caux = sortearPosicao(ch); // posicao inicial da aag para cada chute
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
				y = y < 17 ? y += 1 : y;
				count = 0;
			}

		} while ((n > 0 && defesa == false));
		if (defesa == true) {
			ch.mapearPosicao();
			if(ch.getRelacaoGol().equals("G")||ch.getRelacaoGol().equals("A")) {
				aux.setRelacaoGol("Defesa");
				goleiro.addChute(aux);
			}
			else
				aux.setRelacaoGol(ch.getRelacaoGol());
				goleiro.addChute(aux);
		} else {
			ch.mapearPosicao();
			if(ch.getRelacaoGol().equals("G")||ch.getRelacaoGol().equals("A")) {
				aux.setRelacaoGol("Gol");
				goleiro.addChute(aux);
		}
			else {
				aux.setRelacaoGol(ch.getRelacaoGol());
				goleiro.addChute(aux);
			}
		}
	}

	public Celula sortearPosicao(Chute ch) {
		Random rd = new Random();
		Celula caux = new Celula();
		do {
			caux.setX(rd.nextInt(10));
			caux.setY(rd.nextInt(18));
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
		String result = "---------------------------\n" + "RELACAO DE CHUTES\n" + "Trave Esquerda: " + te
				+ "\nTrave Direita: " + td + "\nTravessao: " + tr + "\nFora: " + fora + "\nAngulo:" + angulo;
		;
		return result;
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
				result += "\n" + gol.getNome() + "|" + sel.getNome() + "|" + gol.contarDefesas() + "|"
						+ gol.contarGols() + "|" + gol.getAAG();
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

	// questao 10
	public String imprimirMatrizes() {
		String saida = "-------------------------\nMATRIZ DOS GOLEIROS\n";
		for (Selecao sel : selecoes) {
			for (Goleiro gol : sel.getGoleiros()) {
				saida += "Goleiro: " + gol.getNome() + "\n";
				saida += matrizDoGoleiro(gol) + "\n";
			}
		}
		return saida;
	}

	public String matrizDoGoleiro(Goleiro goleiro) {
		String result = " ";
		int ocorrencias = 0;
		String saida = "";
		ArrayList<Chute> aux = goleiro.getTotalDeChutes();
		for (int i = 0; i < celulas.size(); i++) {
			ocorrencias = 0;
			result=celulas.get(i).getRelacaoGol()+" ";
			Chute verify = procurarPosicao(celulas.get(i).getX(), celulas.get(i).getY(), aux);
			if (verify != null) {
				ocorrencias = ocorrencia(celulas.get(i).getX(), celulas.get(i).getY(), aux);
				if (verify.getRelacaoGol().equals("Gol")) {
					result = ocorrencias > 1 ? ocorrencias + "*" : "* ";
				} else if (verify.getRelacaoGol().equals("Defesa"))
					result = ocorrencias > 1 ? ocorrencias + "X" : "X ";
			} else {
				result = (celulas.get(i).getRelacaoGol() + " ");
			}
			if (celulas.get(i).getY() == 17) {
				result += "\n";
			}
			saida += result;
		}
		return saida;
	}

	public int ocorrencia(int x, int y, ArrayList<Chute> totalch) { // quantas vezes o chute acontece
		int ocorrencia = 0;
		for (Chute chute : totalch) {
			if (chute.getX() == x && chute.getY() == y) {
				ocorrencia++;
			}
		}
		return ocorrencia;
	}

	public Chute procurarPosicao(int x, int y, ArrayList<Chute> totalch) { // verifica se houve chute naquela posicao
		for (Chute chute : totalch) {
			if (x == chute.getX() && y == chute.getY()) {
				return chute;
			}
		}
		return null;
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
