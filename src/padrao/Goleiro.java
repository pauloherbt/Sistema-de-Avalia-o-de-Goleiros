package padrao;

import java.util.ArrayList;

public class Goleiro {
	private String nome;
	private int id;
	private int AAG;
	private int speed, flex, agil, coord, power, equil;

	private int golDeForca = 0;
	private ArrayList<Chute> totalDeChutes = new ArrayList<>();

	public Goleiro(int id, String nome, int speed, int flex, int agil, int coord, int power, int equil) {
		this.nome = nome;
		this.id = id;
		this.speed = speed;
		this.flex = flex;
		this.agil = agil;
		this.coord = coord;
		this.power = power;
		this.equil = equil;
		this.AAG = ((speed * 3) + (flex * 2) + (agil * 3) + (coord * 2) + (power) + (equil * 2)) / 8;
	}

	public int contarDefesas() {
		int defesas = 0;
		for (Chute ch : totalDeChutes) {
			if (ch.getRelacaoGol().equals("Defesa")) {
				defesas++;
			}
		}
		return defesas;
	}

	public int contarGols() {
		int gols = 0;
		for (Chute ch : totalDeChutes) {
			if (ch.getRelacaoGol().equals("Gol")) {
				gols++;
			}
		}
		return gols;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAAG() {
		return AAG;
	}

	public int getPower() {
		return power;
	}

	public void addGoldeForca() {
		// TODO Auto-generated method stub
		golDeForca++;
	}

	public int getGolDeForca() {
		return golDeForca;
	}

	public void addChute(Chute ch) {
		totalDeChutes.add(ch);
	}

	public ArrayList<Chute> getTotalDeChutes() {
		return totalDeChutes;
	}
}
