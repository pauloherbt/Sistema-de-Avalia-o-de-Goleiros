package padrao;

public class Chute {
	private int id;
	private int power;
	private int quadrante;
	private int x, y;
	
	public Chute(int id, int power, int quadrante, int x, int y) {
		this.id = id;
		this.power = power;
		this.quadrante = quadrante;
		this.x = x;
		this.y = y;
	}
	public int getId() {
		return id;
	}
	public int getQuadrante() {
		return quadrante;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
