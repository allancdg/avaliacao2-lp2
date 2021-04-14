package br.ufrn.imd.lp2.javafx;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
	private String CNPJ;
	private Set<Double> valores_receber = new HashSet<>();
	private Set<Double> vendas_realizadas = new HashSet<>(); 			
	private List<Produto> catalogo_produtos = new ArrayList<Produto>(); 			
	
	// ~~~~ INICIO CONSTRUTORES ~~~~
	public Vendedor() {} //Construtor padrao
	public Vendedor(String nome, String CNPJ, double saldo_conta) { //Construtor parametrizado
		super(nome, saldo_conta);
		this.CNPJ = CNPJ;
	}
	public Vendedor(String nome, String CNPJ){
		super(nome);
		this.CNPJ = CNPJ;
	}
	// ~~~~ FIM CONSTRUTORES ~~~~
		
	// ~~~~ INICIO SETTERS ~~~~
	public void setVendas_realizada(double valor){
		this.vendas_realizadas.add(valor);
	}
	
	public void setValores_receber(double valor) {
		this.valores_receber.add(valor);
	}
	// ~~~~ FIM SETTERS ~~~~
	
	// ~~~~ INICIO GETTERS ~~~~
	public String getCNPJ() {
		return CNPJ;
	}
	
	public Set<Double> getValores_receber() {
		return valores_receber;
	}
	
	public Set<Double> getVendas_realizadas() {
		return vendas_realizadas;
	}
	
	
	public List<Produto> getCatalogo_produtos(){
		return catalogo_produtos;
	}
	
	
	// ~~~~ FIM GETTERS ~~~~
	
	// ~~~~ INICIO DOS METODOS AUXILIARES ~~~~
	//Metodo para mostrar informaçoes
	public String toString() { 
		String retorno = "Nome: " + super.nome;
		retorno += "\nCNPJ: " + this.CNPJ;
		retorno += "\nSaldo em conta: " + super.saldo_conta;
		return retorno;
	}
	
	public void cadastrarProdutos(String nome, double preco) {
		Produto novo_produto = new Produto(nome, preco);
		catalogo_produtos.add(novo_produto);
	}
	/*
	// ~~~~ METODO EQUALS COMPARANDO CNPJS ~~~~
	public boolean equals(Object other) {
		if (other == null || !other.getClass().equals(Vendedor.class)) {
			return false;
		} 
	 	Vendedor otherVendedores = (Vendedor) other;
		return otherVendedores.CNPJ.equals(this.CNPJ);
	}
	
	// ~~~~ METODO AUXILIAR DO HASHCODE ~~~~
	public int hashCode() { 
		return this.CNPJ.hashCode();
	}
	// ~~~~ FIM DOS METODOS AUXILIARES ~~~~
	*/
}