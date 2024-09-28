package br.com.terratech_store.menus;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import br.com.terratech_store.catalogo_produtos.Categoria;
import br.com.terratech_store.catalogo_produtos.Produto;
import br.com.terratech_store.utils.Util;

public class MenuDetalhesProduto {
	public void detalhesProdutos(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();

		logger.info("Deseja acessar a lista de produtos? \t[Sim]\t[Não]");
		String acessarPro = sc.nextLine();
		Util.limpar();
		switch (acessarPro.trim().toLowerCase()) {
		case "sim":
			menuCategorias(fkUsuario);
			break;
		case "não":
			Saida.executarSaida();
			break;
		default:
			Util.carregando("Opção inválida", ".");
			detalhesProdutos(fkUsuario);
			break;
		}
		sc.close();
	}

	public void menuCategorias(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();

		logger.info(
				"\t\t\t\t\t\t\t\tEscolha uma categoria de produtos\n\n\t\t\t\t\t\t\t\t\t\t[1] - Energia Renovável\n\t\t\t\t\t\t\t\t\t\t[2] - Acessórios e Dispositivos\n\t\t\t\t\t\t\t\t\t\t[3] - Eficiência Energética e Sustentabilidade Doméstica\n\t\t\t\t\t\t\t\t\t\t[4] - Voltar ao menu anterior");

		String opcao = sc.nextLine();
		Util.limpar();
		switch (opcao) {

		case "1":
			buscarProdutos(Integer.parseInt(opcao), fkUsuario);
			break;
		case "2":
			buscarProdutos(Integer.parseInt(opcao), fkUsuario);
			break;
		case "3":
			buscarProdutos(Integer.parseInt(opcao), fkUsuario);
			break;
		case "4":
			detalhesProdutos(fkUsuario);
			break;
		default:
			Util.carregando("Opção inválida", ".");
			menuCategorias(fkUsuario);
			break;

		}
		sc.close();
	}

	public void buscarProdutos(int idCategoria, int fkUsuario) {
		Logger logger = Util.setupLogger();
		for (Map.Entry<Integer, Produto> produto : Produto.getMapaProduto().entrySet()) {
			if (produto.getValue().getFkCategoria() == idCategoria) {
				logger.info("O id do produto: " + produto.getValue().getIdProduto());
				logger.info("O nome do produto: " + produto.getValue().getNomeProduto());
				logger.info("A descrição do produto: " + produto.getValue().getDescricaoProduto());
				logger.info("O preço do produto: " + produto.getValue().getPrecoProduto());
				logger.info("A categoria do produto: "
						+ Categoria.getMapaCategoria().get(produto.getValue().getFkCategoria()).getNomeCategoria());
				logger.info("\n\n");

			}
		}
		new MenuCarrinho().opcoesCarrinho(fkUsuario);
	}
}
