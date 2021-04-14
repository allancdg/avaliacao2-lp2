package br.ufrn.imd.lp2.javafx;

public class Produto {
	private String nome;
	private double preco_unitario;
	
	public Produto() {} //Construtor padrao
	public Produto( String nome, double preco_unitario) { //Construtor parametrizado
		this.nome = nome;
		this.preco_unitario = preco_unitario;
	}
	
	//Setters
	//----
	
	//Getters
	public String getNome() {
		return nome;
	}
	public double getPreco_unitario() {
		return preco_unitario;
	}
	//INICIO Metodos auxiliares
	//Metodo para mostrar informaçoes
	public String toString() {
		String retorno = this.nome + " - R$" + this.preco_unitario + "\n";
		return retorno;
	}
}
