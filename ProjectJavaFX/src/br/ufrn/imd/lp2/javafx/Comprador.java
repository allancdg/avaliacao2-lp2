package br.ufrn.imd.lp2.javafx;

public class Comprador extends Pessoa {
	private String CPF;
	//private Set<Double> valores_pagar = new HashSet<>();			
	//private Set<Double> compras_realizadas = new HashSet<>();		
	
	public Comprador() {} //Construtor padrao
	public Comprador(String nome, String CPF, double saldo_conta) { //Construtor parametrizado
		super(nome, saldo_conta);
		this.CPF = CPF;
	}
	public Comprador(String nome, String CPF){
		super(nome);
		this.CPF = CPF;
	}
	/*
	//Setters
	public void setValores_pagar(double valor){
		this.valores_pagar.add(valor);
	}
	
	public void setCompras_realizadas(double valor){
		this.compras_realizadas.add(valor);
	}
	*/
	
	//Getters
	public String getCPF() {
		return CPF;
	}
	//INICIO Metodos auxiliares
	
	//Metodo para mostrar informacoes
	public String toString() { 
		String retorno = "Nome: " + super.nome;
		retorno += "\nCPF: " + this.CPF;
		retorno += "\nSaldo em conta: " + super.saldo_conta;
		return retorno;
	}
	
	//TO-DO
	public void setCompra(double valor_total) {
		// TODO Auto-generated method stub
		
	}
}
