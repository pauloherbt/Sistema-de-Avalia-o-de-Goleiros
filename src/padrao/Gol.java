package padrao;

import java.util.ArrayList;
import java.util.Random;

public class Gol {
	private ArrayList<Celula> celulas = new ArrayList<>();
	private ArrayList<Chute> chutes = new ArrayList<>();
	private ArrayList<Selecao> selecoes = new ArrayList<>();

	public void chuteAoGol() {
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
		boolean defendeu = false;

		somador = n % 4 == 0 ? (n / 4) - 1 : (n / 4);
		do {
			if (count < 4) {
				if (x == ch.getX() && y == ch.getY()) {
					if (count == 3) { // verifica a ultima linha da aag
						goleiro.addDefesa();
					} else if (y == caux.getY() + somador) { // verifica a ultima coluna da aag
						goleiro.addDefesa();
					} else { // gol normal
						goleiro.addDefesa();
					}
					defendeu = true; // sair do laco
				}
				n--;
				count++;
				x = x > 0 ? x -= 1 : caux.getX();
			} else {
				x = caux.getX();
				y = y < 15 ? y += 1 : y;
				count = 0;
			}
		} while ((n > 0 && defendeu == false));
		if (defendeu == false) {
			goleiro.addGol();
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
				soma += go.getDefesa();
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
				result += gol.getNome() + " Defesas: " + gol.getDefesa() + "\n";
				if (gol.getDefesa() > maior) {
					maior = gol.getDefesa();
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
				soma += gol.getGolTomado();
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
