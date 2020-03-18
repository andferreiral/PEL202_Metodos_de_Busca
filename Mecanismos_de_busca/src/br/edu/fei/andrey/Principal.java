package br.edu.fei.andrey;

/***
 * 
 * @author Andrey Ferreira de Almeida
 *
 *Responsabilidade: Método Main
 */
public class Principal {

	public static void main(String[] args) {
		
		/***
		 * Instancía a classe que contém a árvore a ser trabalhada
		 */
		Arvore arvore = new Arvore();
		
		/***
		 * Monta a árvore e retorna o Nó raiz
		 */
		No raiz = arvore.montaArvore();
		
		/***
		 * Mostra a árvore montada
		 */
		//raiz.imprime(raiz);
		
		/***
		 * Instancía a classe com os métodos de busca
		 */
		Busca busca = new Busca();
		
		//Executa a Busca em Profundidade
		//busca.buscaEmProfundidade(raiz, 3, 2);
		
		//Executa a Busca em Largura
		//busca.buscaEmLargura(raiz, null, 3, 2);
	}

}
