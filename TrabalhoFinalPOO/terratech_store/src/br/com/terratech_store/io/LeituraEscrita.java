package br.com.terratech_store.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.terratech_store.catalogo_produtos.Categoria;
import br.com.terratech_store.catalogo_produtos.Produto;
import br.com.terratech_store.enums.TipoUsuarioEnum;
import br.com.terratech_store.usuarios.Cliente;
import br.com.terratech_store.usuarios.Funcionario;
import br.com.terratech_store.usuarios.Usuario;
import br.com.terratech_store.vendas.Carrinho;
import br.com.terratech_store.vendas.Endereco;
import br.com.terratech_store.vendas.Pedido;
import br.com.terratech_store.vendas.ProdutosPedido;

public class LeituraEscrita {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		// Logger logger = Util.setupLogger();
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");
				if (dados[0].equalsIgnoreCase("Categoria")) {
					Categoria categoria = new Categoria(dados[0], Integer.parseInt(dados[1]), dados[2]);
					// logger.log(Level.INFO, categoria::toString);
					Categoria.getMapaCategoria().put(Integer.parseInt(dados[1]), categoria);
				} else if (dados[0].equalsIgnoreCase("Produto")) {

					Produto produto = new Produto(dados[0], dados[1], dados[2], Double.parseDouble(dados[3]),
							Integer.parseInt(dados[4]), Integer.parseInt(dados[5]));
					// logger.log(Level.INFO, produto::toString);
					Produto.getMapaProduto().put(produto.getIdProduto(), produto);

				} else if (dados[0].equalsIgnoreCase("Cliente")) {

					Cliente cliente = new Cliente(TipoUsuarioEnum.CLIENTE, Integer.parseInt(dados[1]), dados[2],
							dados[3], (dados[4]));
					// logger.log(Level.INFO, cliente::toString);
					Cliente.getMapaCliente().put(Integer.parseInt(dados[1]), cliente);
					Usuario.getMapaUsuarios().put(cliente.getfkUsuario(), cliente);

				} else if (dados[0].equalsIgnoreCase("Funcionario")) {

					Funcionario funcionario = new Funcionario(TipoUsuarioEnum.FUNCIONARIO, Integer.parseInt(dados[1]),
							dados[2], dados[3], (dados[4]));
					// logger.log(Level.INFO, funcionario::toString);
					Funcionario.getMapaFuncionario().put(Integer.parseInt(dados[1]), funcionario);
					Usuario.getMapaUsuarios().put(funcionario.getfkUsuario(), funcionario);

				} else if (dados[0].equalsIgnoreCase("Carrinho")) {
					Carrinho carrinho = new Carrinho(dados[0], Integer.parseInt(dados[1]));
					// logger.log(Level.INFO, carrinho::toString);
					Carrinho.getMapaCarrinho().put(carrinho.getIdCarrinho(), carrinho);

				} else if (dados[0].equalsIgnoreCase("Endereco")) {
					Endereco endereco = new Endereco(dados[0], Integer.parseInt(dados[1]), (dados[2]), (dados[3]),
							(dados[4]), (dados[5]), Integer.parseInt(dados[6]));
					// logger.log(Level.INFO, endereco::toString);
					Endereco.getMapaEndereco().put(Integer.parseInt(dados[1]), endereco);

				} else if (dados[0].equalsIgnoreCase("Pedido")) {
					Pedido pedido = new Pedido(dados[0], Integer.parseInt(dados[1]));
					// logger.log(Level.INFO, pedido::toString);
					Pedido.getMapaPedido().put(pedido.getIdPedido(), pedido);

				} else if (dados[0].equalsIgnoreCase("ProdutosPedido")) {
					ProdutosPedido produtospedido = new ProdutosPedido(dados[0], Integer.parseInt(dados[1]),
							Integer.parseInt(dados[2]), Integer.parseInt(dados[3]));
					// logger.log(Level.INFO, produtospedido::toString);
					ProdutosPedido.getMapaProdutosPedido().put(produtospedido.getIdProdutoPedido(), produtospedido);
				}
			} else {

				break;
			}
		}
		buffRead.close();
	}
}
