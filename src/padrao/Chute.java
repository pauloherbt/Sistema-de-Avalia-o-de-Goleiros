package padrao;

public class Chute {
	private int id;
	private int power;
	private int quadrante;
	private int x, y;
	private String relacaoGol;
	
	public Chute(int id, int power, int quadrante, int x, int y) {
		this.id = id;
		this.power = power;
		this.quadrante = quadrante;
		this.x = x;
		this.y = y;
		relacaoGol=null;
	}
	
	public Chute(Chute ch) {
		this.id = ch.getId();
		this.power = ch.getPower();
		this.quadrante = ch.getQuadrante();
		this.x = ch.getX();
		this.y = ch.getY();
		relacaoGol=null;
	}
	public void mapearPosicao() {
		String status="G";
		for (int i = 0; i <=8 ; i++) {
			if(x==i&&y==0) {
				status="F";
			}
			if(x==i&&y==15) {
				status="F";
			}
		}
		for(int i=0;i<=15;i++) {
			if(x==0&&y==i) {
				status="F";
			}
		}
		for(int i=1;i<=8;i++) {
			if(x==i&&y==1) {
				status="TE"; // 
			}
			if(x==i&&y==14) {
				status="TD";
			}
		}
		for(int i=1;i<=14;i++) { //travessao
			if(x==1&&y==i) {
				status="TR";
			}
		}
		if(status.equals("G")) { 
			if(x==2&&y==2) {
				status="A";	//Angulo esquerdo
			}
			if(x==2&&y==13) {
				status="A";	//direito
			}
		}
		this.relacaoGol=status;
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
	public int getPower() {
		return power;
	}
	public String getRelacaoGol() {
		return relacaoGol;
	}
	public void setRelacaoGol(String relacaoGol) {
		this.relacaoGol=relacaoGol;
	}
}
