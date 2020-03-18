package br.edu.fei.andrey;

import java.util.ArrayList;

/***
 * 
 * @author Andrey Ferreira de Almeida
 *
 *Responsabilidade: M�todos de busca
 */
public class Busca {

	/***
	 * M�todo construtor sem par�metros
	 */
	public Busca() {

	}

	/***
	 * M�todo recursivo que realiza a <b>Busca em Largura</b> na �rvore
	 *
	 * Todos os N�s percorridos s�o impressos no console para o usu�rio
	 * 
	 * @param no
	 * @param fila
	 * @param balde3L
	 * @param balde4L
	 */
	public void buscaEmLargura(No no, ArrayList<No> fila, int balde3L, int balde4L) {
		System.out.println(no.toString());
		if (no.getBalde3L() == balde3L && no.getBalde4L() == balde4L) {
			System.out.println("O resultado foi encontrado no n�: \n" + no.toString());
			System.exit(0);
		} else {
			if(fila == null) {
				fila = new ArrayList<No>();
			}
			if(no.getFilhos() != null) {
				for(No filho: no.getFilhos()) {
					fila.add(filho);
				}
			}
			if(fila.size() > 0 && fila != null) {
				No noAtual = fila.get(0);
				fila.remove(0);
				buscaEmLargura(noAtual, fila, balde3L, balde4L);
			}
		}
		
	}

	/***
	 * M�todo recursivo que realiza a <b>Busca em Profundidade</b> na �rvore
	 * 
	 * Todos os N�s percorridos s�o impressos no console para o usu�rio
	 * 
	 * @param no
	 * @param balde3L
	 * @param balde4L
	 */
	public void buscaEmProfundidade(No no, int balde3L, int balde4L) {
		System.out.println(no.toString());
		if (no.getBalde3L() == balde3L && no.getBalde4L() == balde4L) {
			System.out.println("O resultado foi encontrado no n�: \n" + no.toString());
			System.exit(0);
		} else {
			if (no.getFilhos() != null) {
				for (No filho : no.getFilhos()) {
					buscaEmProfundidade(filho, balde3L, balde4L);
				}
			}
		}
	}

}
