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
				for (Chute ch : chutes) { // posicao inicial da aag para cada chute
					caux = sortearPosicao(ch);
					verificarGol(caux, ch, goleiro);
					// System.out.println(caux.getX()+" "+caux.getY()+" "+
					// "quadrante:"+caux.getQuadrante());

				}
			}
		}
	}

	public void verificarGol(Celula caux, Chute ch, Goleiro goleiro) {
		String resultado="";
		int x=ch.getX();
		int y=ch.getY();
		int aag=goleiro.getAAG();
		int count=0;
		while(aag>0) {
			if(count<4) {
				if(x==caux.getX()&&y==caux.getY()) {
					goleiro.addDefesa();
				}
				count++;
				x--;
				
			}
			else {
				x=ch.getX();
				y++;
				count=0;
			}
			aag--;
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
	public String mediaDefesas() {
		double media=0;
		String total ="";
		for (Selecao se: selecoes) {
			int soma=0;
			for (Goleiro go : se.getGoleiros()) {
				soma+=go.getDefesa();
			}
			media=(double)soma/se.getGoleiros().size();
			total+="\nSelecao: "+se.getNome()+"\nMedia de Defesas: "+String.format("%.2f", media);
		}
		return total;
	}
	public String informarPontuacao() {
		String result="-------------------------\n"+"PONTUACAO DOS GOLEIROS";
		for (Selecao sel : selecoes) {
			result+="\nSelecao: "+sel.getNome()+"\n";
			int maior=0;
			String nome="";
			for (Goleiro gol : sel.getGoleiros()) {
				result+=gol.getNome()+" Defesas: "+gol.getDefesa()+"\n";
				if(gol.getDefesa()>maior) {
					maior=gol.getDefesa();
					nome=gol.getNome();
					
				}
			}
			result+="Goleiro titular indicado: "+nome+"\n";
		}
		return result;
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
