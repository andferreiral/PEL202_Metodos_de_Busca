package br.edu.fei.andrey;

/***
 * 
 * @author Andrey Ferreira de Almeida
 *
 *Responsabilidade: M�todo Main
 */
public class Principal {

	public static void main(String[] args) {
		
		/***
		 * Instanc�a a classe que cont�m a �rvore a ser trabalhada
		 */
		Arvore arvore = new Arvore();
		
		/***
		 * Monta a �rvore e retorna o N� raiz
		 */
		No raiz = arvore.montaArvore();
		
		/***
		 * Mostra a �rvore montada
		 */
		//raiz.imprime(raiz);
		
		/***
		 * Instanc�a a classe com os m�todos de busca
		 */
		Busca busca = new Busca();
		
		//Executa a Busca em Profundidade
		//busca.buscaEmProfundidade(raiz, 3, 2);
		
		//Executa a Busca em Largura
		//busca.buscaEmLargura(raiz, null, 3, 2);
	}

}
