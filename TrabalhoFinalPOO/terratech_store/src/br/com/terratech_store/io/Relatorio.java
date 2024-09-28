package br.com.terratech_store.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import br.com.terratech_store.catalogo_produtos.Produto;
import br.com.terratech_store.usuarios.Cliente;
import br.com.terratech_store.vendas.Carrinho;
import br.com.terratech_store.vendas.Pedido;
import br.com.terratech_store.vendas.ProdutosPedido;

public class Relatorio {

	public static void relatorioEstoque() {
		String nomeArquivo = "Relatorio_Estoque";
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		try {
			BufferedWriter buffWrite = new BufferedWriter(
					new FileWriter(LeituraEscrita.PATH_BASICO + nomeArquivo + LeituraEscrita.EXTENSAO, true));
			buffWrite.append("***********Início***********\n\n");

			for (Map.Entry<Integer, Produto> produto : Produto.getMapaProduto().entrySet()) {
				buffWrite.append("ID Produto: " + produto.getValue().getIdProduto());
				buffWrite.append("\nNome: " + produto.getValue().getNomeProduto());
				buffWrite.append("\nDescrição: " + produto.getValue().getDescricaoProduto());
				buffWrite.append("\nESTOQUE: " + produto.getValue().getEstoqueProduto());
				buffWrite.append("\n\n**************************\n\n");

			}

			buffWrite.append("Relatório de Estoque " + dataAtual.format(formato) + "\n");
			buffWrite.append("\n***********Fim***********\n\n\n");

			buffWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void comprovantePedido(int idPedido) {
		String nomeArquivo = "Comprovante_Pedido";
		LocalDateTime dataAtual = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#,##0.00");

		if (Pedido.getMapaPedido().containsKey(idPedido)) {
			double soma = 0;
			int idCarrinho = Pedido.getMapaPedido().get(idPedido).getFkCarrinho();
			int idCliente = Carrinho.getMapaCarrinho().get(idCarrinho).getFkCliente();
			Cliente cliente = Cliente.getMapaCliente().get(idCliente);
			Pedido pedido = Pedido.getMapaPedido().get(idPedido);
			try {
				BufferedWriter buffWrite = new BufferedWriter(
						new FileWriter(LeituraEscrita.PATH_BASICO + nomeArquivo + LeituraEscrita.EXTENSAO));
				buffWrite.append("Início\n\n");
				buffWrite.append("ID Pedido: " + pedido.getIdPedido());
				buffWrite.append("\nItens do Pedido: [\n");
				for (Map.Entry<Integer, ProdutosPedido> produtoPedido : ProdutosPedido.getMapaProdutosPedido()
						.entrySet()) {
					if (produtoPedido.getValue().getFkPedido() == idPedido) {
						int idProduto = produtoPedido.getValue().getFkProduto();
						Produto produto = Produto.getMapaProduto().get(idProduto);
						buffWrite.append("\nProduto: " + produto.getNomeProduto());
						buffWrite.append("\nValor: " + produto.getPrecoProduto());
						buffWrite.append("\nQuantidade: " + produtoPedido.getValue().getQuantidade());
						buffWrite.append("\n\n");
						soma += produto.getPrecoProduto() * produtoPedido.getValue().getQuantidade();
						pedido.setValorTotal(soma);
					}
				}
				buffWrite.append("]");
				buffWrite.append("\nNome Cliente: " + cliente.getNome());
				buffWrite.append("\nValor Total: R$ " + df.format(pedido.getValorTotal()));
				buffWrite.append("\nTipo Pagamento: " + pedido.getTipoPagamentoEnum());
				buffWrite.append("\nData pedido: " + pedido.getDataPedido());
				buffWrite.append("\n\n**\n\n");
				buffWrite.append("Data Comprovante " + dataAtual.format(formato) + "\n");
				buffWrite.append("\n**Fim\n\n\n");

				buffWrite.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
