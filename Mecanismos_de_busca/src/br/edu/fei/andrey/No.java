package br.edu.fei.andrey;

import java.util.ArrayList;

/***
 * 
 * @author Andrey Ferreira de Almeida
 *
 * Responsabilidade: Representar o Nó da árvore a ser criada
 */
public class No {
	
	/***
	 * O campo balde3L representa o Balde de 3L
	 * O campo balde4L representa o Balde de 4L
	 * A lista de Nós representada por "filhos" significa que pode haver mais de uma folha por Nó
	 */
	private int balde3L, balde4L;
	private ArrayList<No> filhos;
	
	/***
	 * Método construtor sem parâmetros
	 */
	public No() {
		
	}

	/***
	 * Método construtor que recebe o balde de 3L e o de 4L como parâmetro e instancía uma lista de Nós filhos
	 * 
	 * @param balde3L
	 * @param balde4L
	 */
	public No(int balde3L, int balde4L) {
		this.balde3L = balde3L;
		this.balde4L = balde4L;
		this.filhos = new ArrayList<No>(); 
	}

	/***
	 * Retorna o valor do balde de 3L
	 * 
	 * @return balde3L
	 */
	public int getBalde3L() {
		return balde3L;
	}

	/***
	 * Método público que acessa o atributo privado dessa classe
	 * 
	 * O parâmetro é o novo valor a ser configurado no campo do balde de 3L
	 * 
	 * @param balde3l
	 */
	public void setBalde3L(int balde3l) {
		balde3L = balde3l;
	}
	
	/***
	 * Retorna o valor do balde de 4L
	 * 
	 * @return balde4L
	 */
	public int getBalde4L() {
		return balde4L;
	}

	/***
	 * Método público que acessa o atributo privado dessa classe
	 * 
	 * O parâmetro é o novo valor a ser configurado no campo do balde de 4L
	 * 
	 * @param balde4l
	 */
	public void setBalde4L(int balde4l) {
		balde4L = balde4l;
	}

	/***
	 * 	Retorna a lista de Nós "filhos" pertencentes a esse Nó "pai"
	 * 
	 * @return Lista de Nós filhos
	 */
	public ArrayList<No> getFilhos() {
		return filhos;
	}

	/***
	 * Método público que acessa o atributo privado dessa classe
	 * 
	 * O parâmetro é a lista de Nós "filhos" a ser configurada nesse Nó "pai"
	 * 
	 * @param filhos
	 */
	public void setFilhos(ArrayList<No> filhos) {
		this.filhos = filhos;
	}
	
	/***
	 * Método público auxiliar que associará os Nós "filhos" ao Nó "pai"
	 * 
	 * @param pai
	 * @param filho
	 */
	public void addFilho(No pai, No filho) {
		
		ArrayList<No> filhos = new ArrayList<No>();
		if(pai.getFilhos() != null) {
			for(No filhoDoPai: pai.getFilhos()) {
				filhos.add(filhoDoPai);
			}
		}
		
		filhos.add(filho);
		
		pai.setFilhos(filhos);		
	}

	/***
	 * Método sobrescrito que retorna o texto formatado do objeto criado
	 * 
	 * Auxilia na visualização da estrutura criada
	 * 
	 * @return texto
	 */
	@Override
	public String toString() {
		String texto = "";
		if( filhos != null) {
			texto =  "\t\tNo (3L=" + balde3L + ", 4L=" + balde4L + ") \n";
			for(No filho: filhos) {
				texto += "Folha (3L=" + filho.getBalde3L() + ", 4L=" + filho.getBalde4L() + ") \t";
			}
		}else {
			texto =  "\t\tNo Terminal (3L=" + balde3L + ", 4L=" + balde4L + ") \n";
		}
		
		return texto;
	}
	
	/***
	 * Método recursivo que imprime no console o Nó "pai" e os Nós "filhos"
	 * 
	 * @param no
	 */
	public void imprime(No no) {
		System.out.println(no.toString());
		if(no.getFilhos() != null) {
			for(No filho: no.getFilhos()) {
				imprime(filho);
			}
		}
		
	}
		
}
