package br.edu.fei.andrey;

import java.util.ArrayList;

/***
 * 
 * @author Andrey Ferreira de Almeida
 *
 *Responsabilidade: Métodos de busca
 */
public class Busca {

	/***
	 * Método construtor sem parâmetros
	 */
	public Busca() {

	}

	/***
	 * Método recursivo que realiza a <b>Busca em Largura</b> na árvore
	 *
	 * Todos os Nós percorridos são impressos no console para o usuário
	 * 
	 * @param no
	 * @param fila
	 * @param balde3L
	 * @param balde4L
	 */
	public void buscaEmLargura(No no, ArrayList<No> fila, int balde3L, int balde4L) {
		System.out.println(no.toString());
		if (no.getBalde3L() == balde3L && no.getBalde4L() == balde4L) {
			System.out.println("O resultado foi encontrado no nó: \n" + no.toString());
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
	 * Método recursivo que realiza a <b>Busca em Profundidade</b> na árvore
	 * 
	 * Todos os Nós percorridos são impressos no console para o usuário
	 * 
	 * @param no
	 * @param balde3L
	 * @param balde4L
	 */
	public void buscaEmProfundidade(No no, int balde3L, int balde4L) {
		System.out.println(no.toString());
		if (no.getBalde3L() == balde3L && no.getBalde4L() == balde4L) {
			System.out.println("O resultado foi encontrado no nó: \n" + no.toString());
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
