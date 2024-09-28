package br.com.terratech_store.funcionario;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import br.com.terratech_store.catalogo_produtos.Categoria;
import br.com.terratech_store.catalogo_produtos.Produto;
import br.com.terratech_store.menus.Saida;
import br.com.terratech_store.utils.Util;

public class GerenciarProdutos {

	int escolhaCategoria;
	Logger logger = Util.setupLogger();

	public void sistemaProdutos() {
		Scanner sc = new Scanner(System.in);
		logger.info("Deseja entrar no gerenciamento dos produto?\t[Sim]\t[Não]");
		String sistemaProdutos = sc.nextLine();
		switch (sistemaProdutos.trim().toLowerCase()) {
		case "sim":
			alterarProdutos();
			break;
		case "não":
			Saida.executarSaida();
			break;
		default:
			sistemaProdutos();
			break;
		}
		sc.close();
	}

	public void alterarProdutos() {

		Scanner sc = new Scanner(System.in);
		logger.info("Deseja incluir algum produto?\t[Sim]\t[Não]");
		String alterarEscolha = sc.nextLine();
		switch (alterarEscolha.trim().toLowerCase()) {
		case "sim":
			logger.info(
					"Aqui está as categorias dos produtos\nEnergia Renovável[1]\nAcessórios e Dispositivos[2]\nEficiência Energética e Sustentabilidade Doméstica[3]");
			escolhaCategoria = sc.nextInt();
			if (escolhaCategoria == 1) {
				listarProdutos(1);
				adicionarProdutos();
			} else if (escolhaCategoria == 2) {
				listarProdutos(2);
				adicionarProdutos();
			} else if (escolhaCategoria == 3) {
				listarProdutos(3);
				adicionarProdutos();
			} else {
				logger.info("Opção inválida");
			}
			break;
		case "não":
			Saida.executarSaida();
			break;
		default:
			sistemaProdutos();
			break;
		}
		sc.close();
	}

	public void adicionarProdutos() {

		Scanner sc = new Scanner(System.in);
		logger.info("Deseja adicionar algum produto?\t[Sim]\t[Não]");
		String adicionarEscolha = sc.nextLine();
		switch (adicionarEscolha.trim().toLowerCase()) {
		case "sim":
			logger.info("Escreva o nome do novo produto");
			String novoNome = sc.nextLine();
			logger.info("Escreva a descrição do novo produto");
			String novoDesc = sc.nextLine();
			logger.info("Escreva o preço do novo produto");
			double novoPreco = sc.nextDouble();
			logger.info("Escreva o estoque do novo produto");
			int novoEstoque = sc.nextInt();
			logger.info("Escreva o id da categoria do seu novo produto");
			int novoCategoria = sc.nextInt();
			Produto novoProduto = new Produto("Produto", novoNome, novoDesc, novoPreco, novoEstoque, novoCategoria);
			Produto.getMapaProduto().put(novoProduto.getIdProduto(), novoProduto);
			logger.info("Aqui está sua categoria com novos produtos ");
			listarProdutos(novoCategoria);
			Util.aguardar(4000);
			Saida.executarSaida();
			break;
		case "não":
			Saida.executarSaida();
			break;
		default:
			Util.carregando("Opção Inválida", ".");
			adicionarProdutos();
			break;
		}
		sc.close();
	}

	public void listarProdutos(int idCategoria) {
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
	}
}
