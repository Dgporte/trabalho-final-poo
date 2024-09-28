package br.com.terratech_store.menus;

import java.util.Scanner;
import java.util.logging.Logger;

import br.com.terratech_store.enums.TipoPagamentoEnum;
import br.com.terratech_store.io.Relatorio;
import br.com.terratech_store.utils.Util;
import br.com.terratech_store.vendas.Pedido;

public class TelaPedido {

	Logger logger = Util.setupLogger();

	public void telaPedido(int fkUsuario, int idPedido) {
		Scanner sc = new Scanner(System.in);

		logger.info("Qual será a forma de pagamento?\n[1] - Cartão de Crédito\n[2] - Cartão de Débito\n[3] - PIX");
		String formaPagamento = sc.nextLine();

		switch (formaPagamento) {
		case "1":
			Pedido.getMapaPedido().get(idPedido).setTipoPagamentoEnum(TipoPagamentoEnum.CARTAO_DE_CREDITO);
			break;
		case "2":
			Pedido.getMapaPedido().get(idPedido).setTipoPagamentoEnum(TipoPagamentoEnum.CARTAO_DE_DEBITO);
			break;
		case "3":
			Pedido.getMapaPedido().get(idPedido).setTipoPagamentoEnum(TipoPagamentoEnum.PIX);
			break;
		default:
			Util.carregando("Opção Inválida", ".");
			telaPedido(fkUsuario, idPedido);
			break;
		}
		logger.info("Pedido Confirmado!");
		Relatorio.comprovantePedido(idPedido);
		logger.info("Um comprovante foi gerado!");
		Util.aguardar(3000);
		Util.limpar();

		sc.close();
	}
}
