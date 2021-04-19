package br.ufrn.imd.lp2.javafx;

public class Debito extends FormaPagamento{

	//METODO DE PAGAMENTO
		@Override
		public void pagamento(Vendedor vendedor, Comprador comprador, double valor_total) {
			System.out.println("VOCE SELECIONOU O PAGAMENTO POR: " + "DEBITO");
			System.out.println("INFO: " + "O PAGAMENTO � INSTANTANEO!"
										+ "\nSER� DESCONTADO UMA TAXA DE 5% PELO SERVI�O!");

			System.out.println("VENDEDOR: " + vendedor.getNome());
			System.out.println("SALDO ANTERIOR: " + vendedor.getSaldo());
			vendedor.setPagamentoVista(valor_total, 0.05);
			System.out.println("NOVO SALDO: " + vendedor.getSaldo());

			System.out.println("\n----------------------------\n");

			System.out.println("COMPRADOR: " + comprador.getNome());
			System.out.println("SALDO ANTERIOR: " + comprador.getSaldo());
			comprador.setCompra(valor_total);
			System.out.println("NOVO SALDO: " + comprador.getSaldo());
		}
		
}
