package padrao;

public class Celula {
	private int x;
	private int y;
	private String relacaoGol;
	private int quadrante;
	
	private int qtdGol;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String getRelacaoGol() {
		return relacaoGol;
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
				status="T";
			}
			if(x==i&&y==14) {
				status="T";
			}
		}
		for(int i=1;i<=14;i++) {
			if(x==1&&y==i) {
				status="T";
			}
		}
		if(status.equals("G")) {
			if(x==2&&y==2) {
				status="A";
			}
			if(x==2&&y==13) {
				status="A";
			}
		}
		this.relacaoGol=status;
	}
	public void verificarQuadrante() {
		int quadrante=4;
		if(x<=3&&y<=7) {
			quadrante=1;
		}
		else if(x<=3&&y>7) {
			quadrante=2;
		}
		else if(x>3&&y<=7) {
			quadrante=3;
		}
		 this.quadrante=quadrante;
	}
	public int getQuadrante() {
		return quadrante;
	}
	public int getQtdGol() {
		return qtdGol;
	}
	public void AddQtdGol() {
		this.qtdGol++;
	}
	
	
}
