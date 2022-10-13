package padrao;

import java.util.ArrayList;

public class Selecao {
	private String nome;
	private ArrayList<Goleiro> goleiros=new ArrayList<>();
	
	public Selecao(String nome) {
		this.nome=nome;
	}
	public void addGoleiro(Goleiro goleiro) {
		this.goleiros.add(goleiro);
	}
	public ArrayList<Goleiro> getGoleiros() {
		return goleiros;
	}
	public String getNome() {
		return nome;
	}
}
