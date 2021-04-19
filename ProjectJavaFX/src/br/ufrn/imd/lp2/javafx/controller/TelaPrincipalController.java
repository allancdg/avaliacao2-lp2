package br.ufrn.imd.lp2.javafx.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.lp2.javafx.Comprador;
import br.ufrn.imd.lp2.javafx.Produto;
import br.ufrn.imd.lp2.javafx.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class TelaPrincipalController {
	// ~~~~ INICIO DECLARACAO DE VARIAVEIS ~~~~
	private boolean cControle = false;
	private boolean vControle = false;
	private String compradorOut;
	private String vendedorOut;
	private List<Comprador> compradores = new ArrayList<>();
	private List<Vendedor> vendedores = new ArrayList<>();
	private ObservableList<Produto> obsListProdutos;
	private ObservableList<Produto> obsListCarrinho;
	protected LocalDate dataAtual = LocalDate.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd / MM / yyyy");
	String formattedData = dataAtual.format(dtf);
	// ~~~~ FIM DECLARACAO DE VARIAVEIS ~~~~
		
	/* @FXML - Anotação usada para marcar campos de membros do controlador
	 * não público e métodos manipuladores para uso pela marcação FXML.
	 */
    @FXML
    private TextField cpfInput;
    @FXML
    private Label LabelTextComprador;
    @FXML
    private TextField cnpjInput;
    @FXML
    private Label LabelTextVendedor;
    @FXML
    private Text TextItensParaVenda;
    @FXML
    private ListView<Produto> ListVenda;
    @FXML
    private Text TextCarrinho;
    @FXML
    private ListView<Produto> ListCarrinho;
    @FXML
    protected Text textDataAtual;
    @FXML
    private Text valorTotalOut;
    @FXML
    private MenuButton selecionarPagamento;
    
    
    // ~~~~ INICIO SIMULAÇÃO DE CARREGAMENTO DE BANCO DE DADOS ~~~~
    Comprador cAuxiliar = new Comprador();
 	Comprador cPadrao0 = new Comprador("COMPRADOR PADRAO 0", "111.222.333-44", 9999.00);
 	Comprador cPadrao1 = new Comprador("COMPRADOR PADRAO 1", "111.111.111-11", 10000.00);
 	Comprador cPadrao2 = new Comprador("COMPRADOR PADRAO 2", "222.222.222-22", 20000.00);
 	Comprador cPadrao3 = new Comprador("COMPRADOR PADRAO 3", "333.333.333-33", 30000.00);
 	
 	Vendedor vAuxiliar = new Vendedor();
 	Vendedor vPadrao0 = new Vendedor("VENDEDOR PADRAO 0", "12.345.678/0001-00", 9999.00);
 	Vendedor vPadrao1 = new Vendedor("VENDEDOR PADRAO 1", "11.111.111/0001-00", 10000.00);
 	Vendedor vPadrao2 = new Vendedor("VENDEDOR PADRAO 2", "22.222.222/0001-00", 20000.00);
 	Vendedor vPadrao3 = new Vendedor("VENDEDOR PADRAO 3", "33.333.333/0001-00", 30000.00);
 	// ~~~~ FIM SIMULAÇÃO DE CARREGAMENTO DE BANCO DE DADOS ~~~~
	
	@FXML
	public void atualizarBotao(MouseEvent event) {		
		// ~~~~ INICIO RECEBENDO CPF DO USUÁRIO E LOCALIZANDO COMPRADORES ~~~~
		for(Comprador comprador_aux : compradores){
			if(comprador_aux.getCPF().equals(cpfInput.getText())){
				compradorOut = comprador_aux.toString();
				cAuxiliar = comprador_aux;
				cControle = true;
			} else if(cControle == false) {
				compradorOut = "\nComprador nao encontrado!";
			}
		}		
		// ~~~~ FIM RECEBENDO CPF DO USUÁRIO E LOCALIZANDO COMPRADORES ~~~~
		
		// ~~~~ INICIO RECEBENDO CNPJ DO USUÁRIO E LOCALIZANDO VENDEDORES ~~~~
		for(Vendedor vendedor_aux : vendedores){
			if(vendedor_aux.getCNPJ().equals(cnpjInput.getText())){
				vendedorOut = vendedor_aux.toString();
				vAuxiliar = vendedor_aux;
				vControle = true;
			} else if(vControle == false){
				vendedorOut = "\nVendedor nao encontrado!";
			}
		}
		// ~~~~ FIM RECEBENDO CNPJ DO USUÁRIO E LOCALIZANDO VENDEDORES ~~~~
		
		// ~~~~ INICIO VISUALIZACAO DO COMPRADOR E VENDEDOR ~~~~
		LabelTextComprador.setText(compradorOut);
		LabelTextVendedor.setText(vendedorOut);
		// ~~~~ FIM VISUALIZACAO DO COMPRADOR E VENDEDOR ~~~~
		
		// ~~~~ INICIO VISUALIZAÇÃO DE ITENS PARA VENDA ~~~~
		if(cControle == true && vControle == true) {
			obsListProdutos = FXCollections.observableArrayList(vAuxiliar.getCatalogo_produtos());
			ListVenda.setItems(obsListProdutos);
		} else {
			ListVenda.setItems(null);
		}
		// ~~~~ FIM VISUALIZAÇÃO DE ITENS PARA VENDA ~~~~
	}
	
	Produto produtoSelecionadoListview = new Produto();
	List<Produto> listProdutoCarrinho = new ArrayList<>();
	double valorOut = 0.0;
	@FXML
	public void incluirBotao(MouseEvent event) {
		// ~~~~ INICIO DA SELECAO EM ListVenda (LISTVIEW) ~~~~
		produtoSelecionadoListview = ListVenda.getSelectionModel().getSelectedItem();
		listProdutoCarrinho.add(produtoSelecionadoListview);
		obsListCarrinho = FXCollections.observableArrayList(listProdutoCarrinho);
		ListCarrinho.setItems(obsListCarrinho);
		valorOut += produtoSelecionadoListview.getPreco_unitario();
		valorTotalOut.setText("Total: R$ " + valorOut);
		// ~~~~ FIM DA SELECAO EM ListVenda (LISTVIEW) ~~~~
    }
	
	public void initialize() {
		carregarDados();
		textDataAtual.setText(formattedData);
	}
	
	public void carregarDados() {
		// ~~~~ INICIO SIMULACAO DE CARREGAMENTO DE INFORMACOES ~~~~
			// ~~~~ INICIO ADICAO DE COMPRADORES E VENDEDORES A LIST ~~~~
			compradores.add(cPadrao0);
			compradores.add(cPadrao1);
			compradores.add(cPadrao2);
			compradores.add(cPadrao3);
			
			vendedores.add(vPadrao0);
			vendedores.add(vPadrao1);
			vendedores.add(vPadrao2);
			vendedores.add(vPadrao3);
			// ~~~~ FIM ADICAO DE COMPRADORES E VENDEDORES A LIST ~~~~
				
			// ~~~~ ADICAO DE PRODUTOS NOS COMPRADORES ~~~~		
			vPadrao0.cadastrarProdutos("Produto 1", 99);
			vPadrao0.cadastrarProdutos("Produto 2", 79.99);
			vPadrao0.cadastrarProdutos("Produto 3", 149.99);
			
			vPadrao1.cadastrarProdutos("Produto 1", 19);
			vPadrao1.cadastrarProdutos("Produto 2", 36.99);
			vPadrao1.cadastrarProdutos("Produto 3", 16.99);
			
			vPadrao2.cadastrarProdutos("Produto 1", 10);
			vPadrao2.cadastrarProdutos("Produto 2", 29.99);
			vPadrao2.cadastrarProdutos("Produto 3", 49.50);
			
			vPadrao3.cadastrarProdutos("Produto 1", 499.99);
			vPadrao3.cadastrarProdutos("Produto 2", 59.99);
			vPadrao3.cadastrarProdutos("Produto 3", 279);
			// ~~~~ FIM ADICAO DE PRODUTOS NOS COMPRADORES ~~~~
		// ~~~~ FIM SIMULACAO DE CARREGAMENTO DE INFORMACOES ~~~~
			
		}
}