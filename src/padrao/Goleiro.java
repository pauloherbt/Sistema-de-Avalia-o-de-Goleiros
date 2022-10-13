package padrao;

public class Goleiro {
	private String nome;
	private int id;
	private int AAG;
	private int speed, flex, agil, coord, power, equil;
	private int defesas=0;
	
	public Goleiro(int id,String nome, int speed, int flex, int agil, int coord, int power, int equil) {
		this.nome = nome;
		this.id = id;
		this.speed = speed;
		this.flex = flex;
		this.agil = agil;
		this.coord = coord;
		this.power = power;
		this.equil = equil;
		this.AAG=((speed*3)+(flex*2)+(agil*3)+(coord*2)+(power)+(equil*2))/8;
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
	public void addDefesa() {
		this.defesas++;
	}
	public int getDefesa() {
		return defesas;
	}
	
}
