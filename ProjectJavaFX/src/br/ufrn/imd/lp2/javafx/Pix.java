package br.ufrn.imd.lp2.javafx;

public class Pix extends FormaPagamento{
	
	//METODO DE PAGAMENTO
		@Override
		public void pagamento(Vendedor vendedor, Comprador comprador, double valor_total) {
			System.out.println("VOCE SELECIONOU O PAGAMENTO POR: " + "PIX");
			System.out.println("INFO: " + "O PAGAMENTO � INSTANTANEO!");

			System.out.println("VENDEDOR: " + vendedor.getNome());
			System.out.println("SALDO ANTERIOR: " + vendedor.getSaldo());
			vendedor.setPagamentoVista(valor_total, 0);
			System.out.println("NOVO SALDO: " + vendedor.getSaldo());

			System.out.println("\n----------------------------\n");

			System.out.println("COMPRADOR: " + comprador.getNome());
			System.out.println("SALDO ANTERIOR: " + comprador.getSaldo());
			comprador.setCompra(valor_total);
			System.out.println("NOVO SALDO: " + comprador.getSaldo());
		}
}
