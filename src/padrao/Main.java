package padrao;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Goleiro> carregarGoleiros() {
		ArrayList<Goleiro> goleiros = new ArrayList<>();
		goleiros.add(new Goleiro(1, "Pratik Skaggs", 5, 7, 8, 9, 6, 6));
		goleiros.add(new Goleiro(2, "Uehudah Hack", 9, 6, 8, 8, 7, 10));
		goleiros.add(new Goleiro(3, "Edison Drye", 5, 8, 5, 8, 10, 7));
		goleiros.add(new Goleiro(4, "Ajani Harding", 6, 6, 5, 8, 7, 6));
		goleiros.add(new Goleiro(5, "Orazio Hart", 5, 8, 7, 9, 9, 10));
		goleiros.add(new Goleiro(6, "Tristan Karns", 9, 7, 10, 7, 7, 6));
		goleiros.add(new Goleiro(7, "Niven Glaser", 10, 9, 7, 6, 5, 8));
		goleiros.add(new Goleiro(8, "Derwyn Devers", 10, 7, 9, 5, 9, 5));
		goleiros.add(new Goleiro(9, "Tod Phan", 10, 7, 7, 5, 5, 6));
		goleiros.add(new Goleiro(10, "Eddie Hulse", 7, 6, 5, 9, 7, 5));
		goleiros.add(new Goleiro(11, "Welford Yepez", 5, 8, 8, 7, 7, 8));
		goleiros.add(new Goleiro(12, "Rishley Snyder", 6, 5, 6, 5, 7, 6));
		goleiros.add(new Goleiro(13, "Milo Mccurdy", 10, 9, 8, 6, 10, 9));
		goleiros.add(new Goleiro(14, "Carden Justus", 8, 5, 8, 5, 10, 7));
		goleiros.add(new Goleiro(15, "Carlyon Gorby", 8, 5, 8, 8, 8, 6));
		goleiros.add(new Goleiro(16, "Mungo Spangler", 8, 10, 9, 8, 9, 5));
		goleiros.add(new Goleiro(17, "Whitmore Squires", 9, 10, 7, 9, 9, 10));
		goleiros.add(new Goleiro(18, "Pedrog Mccurdy", 8, 5, 10, 5, 7, 7));
		goleiros.add(new Goleiro(19, "Ridgley Leo", 8, 8, 8, 9, 9, 9));
		goleiros.add(new Goleiro(20, "Bolton Tarin", 9, 8, 7, 6, 9, 10));
		goleiros.add(new Goleiro(21, "Edison Loy", 7, 7, 5, 10, 10, 7));
		goleiros.add(new Goleiro(22, "Delling Herndon", 7, 5, 5, 8, 9, 9));
		goleiros.add(new Goleiro(23, "Senichi Iorio", 7, 7, 5, 8, 10, 5));
		goleiros.add(new Goleiro(24, "Albin Kerner", 6, 7, 8, 8, 9, 9));
		goleiros.add(new Goleiro(25, "Jivin Justus", 9, 10, 8, 7, 7, 5));
		goleiros.add(new Goleiro(26, "Clement Fleisher", 10, 9, 10, 5, 7, 8));

		return goleiros;
	}

	public static void carregarSelecao(Gol golaux) {
		ArrayList<Goleiro> aux = carregarGoleiros();
		Selecao s1 = new Selecao("Brasil");
		Selecao s2 = new Selecao("Gana");
		Selecao s3 = new Selecao("Servia");
		Selecao s4 = new Selecao("Argentina");
		Selecao s5 = new Selecao("Alemanha");
		for (int i = 0; i < aux.size(); i++) {
			if (i < 5) {
				s1.addGoleiro(aux.get(i));
			} else if (i < 10) {
				s2.addGoleiro(aux.get(i));
			} else if (i < 15) {
				s3.addGoleiro(aux.get(i));
			} else if (i < 20) {
				s4.addGoleiro(aux.get(i));
			} else {
				s5.addGoleiro(aux.get(i));
			}
		}
		golaux.addSelecao(s1);
		golaux.addSelecao(s2);
		golaux.addSelecao(s3);
		golaux.addSelecao(s4);
		golaux.addSelecao(s5);

	}

	public static void carregarChutes(Gol golaux) {
		golaux.addChute(new Chute(1, 2, 1, 4, 7));
		golaux.addChute(new Chute(2, 6, 1, 3, 6));
		golaux.addChute(new Chute(3, 9, 2, 4, 15));
		golaux.addChute(new Chute(4, 5, 4, 6, 11));
		golaux.addChute(new Chute(5, 3, 4, 8, 13));
		golaux.addChute(new Chute(6, 3, 3, 6, 4));
		golaux.addChute(new Chute(7, 4, 4, 5, 8));
		golaux.addChute(new Chute(8, 7, 4, 7, 14));
		golaux.addChute(new Chute(9, 8, 4, 7, 14));
		golaux.addChute(new Chute(10, 4, 4, 6, 12));
		golaux.addChute(new Chute(11, 2, 4, 5, 15));
		golaux.addChute(new Chute(12, 7, 3, 6, 4));
		golaux.addChute(new Chute(13, 3, 3, 8, 2));
		golaux.addChute(new Chute(14, 9, 4, 7, 10));
		golaux.addChute(new Chute(15, 10, 4, 7, 12));
		golaux.addChute(new Chute(16, 5, 1, 4, 2));
		golaux.addChute(new Chute(17, 3, 4, 5, 13));
		golaux.addChute(new Chute(18, 10, 2, 4, 16));
		golaux.addChute(new Chute(19, 10, 4, 5, 16));
		golaux.addChute(new Chute(20, 10, 2, 3, 14));
		golaux.addChute(new Chute(21, 9, 2, 1, 8));
		golaux.addChute(new Chute(22, 4, 4, 8, 16));
		golaux.addChute(new Chute(23, 8, 4, 6, 14));
		golaux.addChute(new Chute(24, 7, 4, 7, 11));
		golaux.addChute(new Chute(25, 6, 1, 0, 3));
		golaux.addChute(new Chute(26, 5, 3, 6, 7));
		golaux.addChute(new Chute(27, 3, 3, 8, 4));
		golaux.addChute(new Chute(28, 4, 3, 6, 7));
		golaux.addChute(new Chute(29, 10, 2, 2, 13));
		golaux.addChute(new Chute(30, 7, 3, 5, 3));

	}

	public static void imprimirQuadrante(Gol golaux) {
		ArrayList<Celula> aux = golaux.getCelulas();
		for (int i = 0; i < aux.size(); i++) {
			System.out.print(aux.get(i).getQuadrante() + " ");
			if (aux.get(i).getY() == 15) {
				System.out.println();
			}
		}
	}

	public static void imprimirStatus(Gol golaux) {
		ArrayList<Celula> aux = golaux.getCelulas();
		for (int i = 0; i < aux.size(); i++) {
			System.out.print(aux.get(i).getRelacaoGol() + " ");
			if (aux.get(i).getY() == 15) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		Gol golaux = new Gol();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 16; j++) {
				Celula celula = new Celula();
				celula.setX(i);
				celula.setY(j);
				celula.mapearPosicao();
				celula.verificarQuadrante();
				golaux.addCelula(celula);
			}
		}
		// imprimirStatus(golaux);
		// System.out.println();
		// imprimirQuadrante(golaux);
		carregarSelecao(golaux);
		carregarChutes(golaux);
//		for (Selecao s : golaux.getSelecoes()) {
//			System.out.println(s.getNome());
//			for (Goleiro g : s.getGoleiros()) {
//				System.out.println(g.getNome());
//			}
//		}
		// golaux.chuteAoGol();
		 golaux.chuteAoGol();
		 System.out.println(golaux.mediaDefesas());
		 System.out.println(golaux.informarPontuacao());
		 System.out.println(golaux.mediaGolsTomados());
		 System.out.println(golaux.mapearChutes());
//		System.out.println("aag goleiro: "+ carregarGoleiros().get(0).getAAG());
//		for (Chute ch : golaux.getChutes()) {
//			Celula caux = golaux.sortearPosicao(ch);
//			System.out.println("\nposicao do chute:"+ch.getX()+" "+ch.getY());
//			System.out.println("\nposicao inicial "+ caux.getX()+" "+caux.getY());
//			golaux.verificarGol(caux, ch, carregarGoleiros().get(0));
		}
	}
