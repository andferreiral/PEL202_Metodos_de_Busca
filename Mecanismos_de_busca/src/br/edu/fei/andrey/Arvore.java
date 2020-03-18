package br.edu.fei.andrey;

/***
 * 
 * @author Andrey Ferreira de Almeida
 *
 *Responsabilidae: Montar a árvore
 */
public class Arvore {
	
	/***
	 * O campo raiz representa o Nó da árvore
	 */
	private No raiz;
	
	/***
	 * Método construtor sem parâmetros
	 * 
	 * Toda vez em que for instanciada, a árvore nascerá com o Nó raiz de valor 0 para os baldes de 3L e 4L
	 */
	public Arvore() {
		this.setRaiz(new No(0,0));		
	}
	
	/***
	 * Método que enche o balde de 3L
	 * 
	 * Retorna o novo Nó para ser incluído como folha da árvore
	 * 
	 * @exception falha caso não seja mais possível encher o balde de 3L
	 * 
	 * @param pai
	 * @return filho
	 */
	public No encheBalde3L(No pai) {
		No filho = new No();
		
		if(pai.getBalde3L() < 3) {
			filho.setBalde3L(3);
			filho.setBalde4L(pai.getBalde4L());
			
		}else {
			System.out.println("O balde de 3L já estava cheio!");
			System.exit(1);
		}
		
		pai.addFilho(pai, filho);
						
		return filho;
	}
	
	/***
	 * Método que enche o balde de 4L
	 * 
	 * Retorna o novo Nó para ser incluído como folha da árvore
	 * 
	 * @exception falha caso não seja mais possível encher o balde de 4L
	 * 
	 * @param pai
	 * @return filho
	 */
	public No encheBalde4L(No pai) {
		No filho = new No();
		
		if(pai.getBalde4L() < 4) {
			filho.setBalde4L(4);
			filho.setBalde3L(pai.getBalde3L());
			
		}else {
			System.out.println("O balde de 4L já estava cheio!");
			System.exit(1);
		}
				
		pai.addFilho(pai, filho);
		return filho;
	}

	/***
	 * Método que esvazia o balde de 3L
	 * 
	 * Retorna o novo Nó para ser incluído como folha da árvore
	 * 
	 * @param pai
	 * @return filho
	 */
	public No esvaziaBalde3L(No pai) {
		No filho = new No();
		
		filho.setBalde3L(0);
		filho.setBalde4L(pai.getBalde4L());
		
		pai.addFilho(pai, filho);
						
		return filho;
	}
	
	/***
	 * Método que esvazia o balde de 4L
	 * 
	 * Retorna o novo Nó para ser incluído como folha da árvore
	 * 
	 * @param pai
	 * @return filho
	 */
	public No esvaziaBalde4L(No pai) {
		No filho = new No();
		
		filho.setBalde4L(0);
		filho.setBalde3L(pai.getBalde3L());
		
		pai.addFilho(pai, filho);
						
		return filho;
	}
	
	/***
	 * Método que transfere do balde de 4L para o de 3L
	 * 
	 * Retorna o novo Nó para ser incluído como folha da árvore
	 * 
	 * @param pai
	 * @return filho
	 */
	public No transfere4LPara3L(No pai) {
		No filho = new No();
		int diff = 3 - pai.getBalde3L();
		
		if(pai.getBalde4L() < diff) {
			filho.setBalde3L(pai.getBalde4L() + pai.getBalde3L());
			filho.setBalde4L(pai.getBalde4L() - pai.getBalde4L());
		}else {
			int ficaNoBalde = pai.getBalde4L() - diff;
			filho.setBalde3L((pai.getBalde4L() - ficaNoBalde) + pai.getBalde3L());
			filho.setBalde4L(ficaNoBalde);
		}
				
		pai.addFilho(pai, filho);
		
		return filho;
	}
	
	/***
	 * Método que transfere do balde de 3L para o de 4L
	 * 
	 * Retorna o novo Nó para ser incluído como folha da árvore
	 * 
	 * @param pai
	 * @return filho
	 */
	public No transfere3LPara4L(No pai) {
		No filho = new No();
		int diff = 4 - pai.getBalde4L();
		
		if(pai.getBalde3L() < diff) {
			filho.setBalde4L(pai.getBalde3L() + pai.getBalde4L());
			filho.setBalde3L(pai.getBalde3L() - pai.getBalde3L());
		}else {
			int ficaNoBalde = pai.getBalde3L() - diff;
			filho.setBalde4L(pai.getBalde3L() + pai.getBalde4L());
			filho.setBalde3L(ficaNoBalde);
		}
		
		pai.addFilho(pai, filho);
				 
		return filho;
	}

	/***
	 * Retorna o valor do atributo raiz
	 * 
	 * @return raiz
	 */
	public No getRaiz() {
		return raiz;
	}

	/***
	 * Método público que acessa o atributo privado dessa classe
	 * 
	 * O parâmetro é o novo valor a ser configurado no campo raiz
	 * 
	 * @param raiz
	 */
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	/***
	 * Método que cria a árvore a ser trabalhada nas buscas
	 * 
	 * @return raiz da árvore {@link #getRaiz()}
	 */
	public No montaArvore() {
		// monto a árvore e retorno a raiz dela para percorrer
		Arvore arvore = new Arvore();
		//raiz
		/***
		 * (0,0)
		 */
		No raiz = arvore.getRaiz();
		
		//esquerda da árvore
		/***
		 * (0,0)
		 * (3,0)
		 */
		No f1 = arvore.encheBalde3L(raiz);
		
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 */
		No f12 = arvore.transfere3LPara4L(f1);
		
		//cria 2 filhos
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 * (0,4)	(3,3)
		 */
		No f13 = arvore.encheBalde4L(f12);
		No f14 = arvore.encheBalde3L(f12);
		
		//No terminal
		/***
		 * (0,0)
		 * (3,0)
		 * (3,3)
		 * (3,4)
		 */
		No f15 = arvore.encheBalde4L(f14);
		
		//cria 2 filhos, sendo que 1 dos filhos é terminal
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)	(3,4)
		 */
		No f16 = arvore.transfere4LPara3L(f13);
		No f17 = arvore.encheBalde3L(f13);
		
		//cria 2 filhos, sendo que 1 dos filhos é terminal
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)	(3,4)
		 */
		No f18 = arvore.encheBalde4L(f16);
		No f19 = arvore.esvaziaBalde3L(f16);
		
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)
		 * (1,0)
		 */
		No f111 = arvore.transfere4LPara3L(f19);
		
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)
		 * (1,0)
		 * (1,4)
		 */
		No f112 = arvore.encheBalde4L(f111);
		
		/***
		 * (0,0)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)
		 * (1,0)
		 * (1,4)
		 * (3,2) <- é uma possível solução
		 */
		No f114 = arvore.transfere4LPara3L(f112);
				
		//direita da árvore
		/***
		 * (0,0)
		 * (0,4)
		 */
		No f2 = arvore.encheBalde4L(raiz);
		
		//cria dois 2 filhos, sendo que 1 dos filhos é terminal
		/***
		 * (0,0)
		 * (0,4)
		 * (3,4)	(3,1)
		 */
		No f21 = arvore.encheBalde3L(f2);
		No f22 = arvore.transfere4LPara3L(f2);
		
		//cria 3 filhos, sendo que 1 dos filhos é terminal
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)	(0,1)	(3,4)
		 */
		No f23 = arvore.esvaziaBalde4L(f22);
		No f24 = arvore.esvaziaBalde3L(f22);
		No f25 = arvore.encheBalde4L(f22);
		
		// fluxo do (3,0)
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 */
		No f26 = arvore.transfere3LPara4L(f23);
		
		//cria 2 filhos
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (3,3)	(0,4)
		 */
		No f27 = arvore.encheBalde4L(f26);
		No f28 = arvore.encheBalde3L(f26);
		
		//No terminal
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (3,3)
		 * (3,4)
		 */
		No f29 = arvore.encheBalde4L(f28);
		
		//cria 2 filhos, sendo que 1 dos filhos é terminal
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)	(3,4)
		 */
		No f221 = arvore.transfere4LPara3L(f27);
		No f222 = arvore.encheBalde3L(f27);
		
		//cria 2 filhos, sendo que 1 dos filhos é terminal
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (3,4)	(0,1)
		 */
		No f223 = arvore.encheBalde4L(f221);
		No f224 = arvore.esvaziaBalde3L(f221);
		
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)
		 * (1,0)
		 */
		No f225 = arvore.transfere4LPara3L(f224);
		
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)
		 * (1,0)
		 * (1,4)
		 */
		No f226 = arvore.encheBalde4L(f225);
		
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,3)
		 * (0,4)
		 * (3,1)
		 * (0,1)
		 * (1,0)
		 * (1,4)
		 * (3,2) <- é uma possível solução
		 */
		No f227 = arvore.transfere4LPara3L(f226);
		
		//fluxo do (0,1)
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,1)
		 * (1,0)
		 */
		No f228 = arvore.transfere4LPara3L(f24);
		
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,1)
		 * (1,0)
		 * (1,4)
		 */
		No f229 = arvore.encheBalde4L(f228);
		
		/***
		 * (0,0)
		 * (0,4)
		 * (3,1)
		 * (3,0)
		 * (0,1)
		 * (1,0)
		 * (1,4)
		 * (3,2) <- é uma possível solução
		 */
		No f2221 = arvore.transfere4LPara3L(f229);
		
		return arvore.getRaiz();
	}
		
}
