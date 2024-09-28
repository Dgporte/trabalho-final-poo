package br.com.terratech_store.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import br.com.terratech_store.catalogo_produtos.Produto;
import br.com.terratech_store.usuarios.Cliente;
import br.com.terratech_store.utils.Util;
import br.com.terratech_store.vendas.Carrinho;
import br.com.terratech_store.vendas.Pedido;
import br.com.terratech_store.vendas.ProdutosPedido;

public class MenuCarrinho {
	MenuDetalhesProduto menuProdutos = new MenuDetalhesProduto();
	List<Integer> listaIdsProduto = new ArrayList<>();
	List<Integer> listaQtdsProduto = new ArrayList<>();
	Logger logger = Util.setupLogger();

	public void opcoesCarrinho(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		logger.info(
				"\t\t\t\t\t\t\t\tOpções:\n\n\t\t\t\t\t\t\t\t\t\t[1] - Adicionar um produto ao carrinho\n\t\t\t\t\t\t\t\t\t\t[2] - Voltar\n");

		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			adicionarProduto(fkUsuario);
			break;
		case 2:
			menuProdutos.detalhesProdutos(fkUsuario);
			break;
		default:
			Util.carregando("Opção Inválida", ".");
			opcoesCarrinho(fkUsuario);
			break;
		}
		sc.close();
	}

	public void mostrarCarrinho(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		for (Integer idProduto : listaIdsProduto) {
			for (Map.Entry<Integer, Produto> produto : Produto.getMapaProduto().entrySet()) {
				int idQuantiddade = listaIdsProduto.indexOf(idProduto);
				if (produto.getValue().getIdProduto() == idProduto) {
					logger.info("O id do produto: " + produto.getValue().getIdProduto());
					logger.info("O nome do produto: " + produto.getValue().getNomeProduto());
					logger.info("O preço do produto: " + produto.getValue().getPrecoProduto());
					logger.info("A quantidade do produto: " + listaQtdsProduto.get(idQuantiddade));
					logger.info("\n");
				}
			}
		}
		continuarComprando(fkUsuario);
		sc.close();
	}

	public void adicionarProduto(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		logger.info("Qual id do produto você deseja adicionar");
		String idProduto = sc.nextLine();
		int intIdProduto = 0;

		logger.info("Quantas unidades deste produto você deseja adicionar");
		String quantidade = sc.nextLine();
		int intQuantidade = 1;
		try {
			intIdProduto = Integer.parseInt(idProduto);
			intQuantidade = Integer.parseInt(quantidade);

		} catch (NumberFormatException e) {
			Util.carregando("Opção Inválida", ".");
			adicionarProduto(fkUsuario);
		}
		if (!produtoExiste(intIdProduto)) {
			logger.info("O id informado não existe!");
			Util.aguardar(3000);
			adicionarProduto(fkUsuario);
		}
		if (!possuiEstoque(intIdProduto, intQuantidade)) {
			logger.info("Infelizmente no momento temos apenas "
					+ Produto.getMapaProduto().get(intIdProduto).getEstoqueProduto() + " unidade(s) deste produto.");
			Util.aguardar(3000);
			adicionarProduto(fkUsuario);
		}
		if (listaIdsProduto.contains(intIdProduto)) {
			logger.info("Este produto já está no carrinho. Deseja alterar a quantidade? [s] - sim / [n] - não");
			String opcao = sc.nextLine();
			switch (opcao.trim().toLowerCase()) {
			case "s":
				alterarQuantidade(fkUsuario,intIdProduto,intQuantidade);
				break;
			case "n":
				continuarComprando(fkUsuario);
				break;
			default:
				Util.carregando("Opção Inválida", ".");
				adicionarProduto(fkUsuario);
				break;
				
			}
		} else {
			listaIdsProduto.add(Integer.parseInt(idProduto));
			listaQtdsProduto.add(Integer.parseInt(quantidade));
			continuarComprando(fkUsuario);
		}

		sc.close();
	}

	public void alterarQuantidade(int fkUsuario, int idProduto,int quantidade) {
		if (!possuiEstoque(idProduto, quantidade)) {
			logger.info("Infelizmente no momento temos apenas "
					+ Produto.getMapaProduto().get(idProduto).getEstoqueProduto() + " unidade(s) deste produto.");
			Util.aguardar(3000);
			adicionarProduto(fkUsuario);
		} else {
			int idQuantidade = listaIdsProduto.indexOf(idProduto);
			listaQtdsProduto.set(idQuantidade, quantidade);
			continuarComprando(fkUsuario);
		}
	}

	public boolean produtoExiste(int idProduto) {
		boolean existe = false;
		for (Map.Entry<Integer, Produto> produto : Produto.getMapaProduto().entrySet()) {
			if (produto.getValue().getIdProduto() == idProduto) {
				existe = true;
			}
		}
		return existe;
	}

	public boolean possuiEstoque(int idProduto, int quantidade) {
		return Produto.getMapaProduto().get(idProduto).getEstoqueProduto() >= quantidade;
	}

	public void continuarComprando(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		logger.info(
				"O que você deseja?\n [1] - Continuar comprando \n [2] - Visualizar carrinho \n [3] - Finalizar Compra \n [4] - Sair");
		int outroProduto = sc.nextInt();
		switch (outroProduto) {
		case 1:
			adicionarProduto(fkUsuario);
			break;
		case 2:
			mostrarCarrinho(fkUsuario);
			break;
		case 3:
			finalizarCompra(fkUsuario);
			Saida.executarSaida();
			break;
		case 4:
			logoutCarrinho(fkUsuario);
			break;
		default:
			Util.carregando("Esse Opção Inválida", ".");
			opcoesCarrinho(fkUsuario);
			break;
		}
		sc.close();
	}

	public void finalizarCompra(int fkUsuario) {
		if (listaIdsProduto.isEmpty()) {
			logger.info("Carrinho está vazio");
			Util.aguardar(3000);
			continuarComprando(fkUsuario);
		} else {
			int idCliente = 0;
			for (Map.Entry<Integer, Cliente> cliente : Cliente.getMapaCliente()
					.entrySet()) {
				if(cliente.getValue().getfkUsuario() == fkUsuario) {
					idCliente = cliente.getValue().getIdCliente();
				}
			}
			Carrinho carrinho = new Carrinho("Carrinho", idCliente);
			Carrinho.getMapaCarrinho().put(carrinho.getIdCarrinho(), carrinho);
			Pedido pedido = new Pedido("Pedido", carrinho.getIdCarrinho());
			Pedido.getMapaPedido().put(pedido.getIdPedido(), pedido);
			ProdutosPedido protudosPedido;
			for (int idProduto : listaIdsProduto) {
				int estoqueAtual = Produto.getMapaProduto().get(idProduto).getEstoqueProduto();
				int idQuantiddade = listaIdsProduto.indexOf(idProduto);
				protudosPedido = new ProdutosPedido("ProdutosPedido", idProduto, pedido.getIdPedido(),
						listaQtdsProduto.get(idQuantiddade));
				ProdutosPedido.getMapaProdutosPedido().put(protudosPedido.getIdProdutoPedido(), protudosPedido);
				Produto.getMapaProduto().get(idProduto)
						.setEstoqueProduto(estoqueAtual - listaQtdsProduto.get(idQuantiddade));
			}
			new TelaPedido().telaPedido(fkUsuario, pedido.getIdPedido());
		}
	}

	public void logoutCarrinho(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		logger.info("Seu carrinho será perdido! Deseja mesmo sair? \n [s] - sim \n [n] - não");
		String opcao = sc.nextLine();
		switch (opcao.trim().toLowerCase()) {
		case "s":
			Saida.executarSaida();
			break;
		case "n":
			continuarComprando(fkUsuario);
			break;
		default:
			Util.carregando("Este Opção Inválida", ".");
			logoutCarrinho(fkUsuario);
			break;
		}
		sc.close();
	}

}
