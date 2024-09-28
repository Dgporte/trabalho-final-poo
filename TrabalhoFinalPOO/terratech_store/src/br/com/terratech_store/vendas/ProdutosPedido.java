package br.com.terratech_store.vendas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutosPedido {
	private String tipoDado = "ProdutosPedido";
	private int idProdutoPedido;
	private int fkProduto;
	private int fkPedido;
	private int quantidade;
	private static List<Integer> listaIdsProdutoPedido = new ArrayList<>();
	private static Map<Integer, ProdutosPedido> mapaProdutosPedido = new HashMap<>();

	public ProdutosPedido() {
	}

	public ProdutosPedido(String tipoDado, int fkProduto, int fkPedido, int quantidade) {
		verificaId();
		this.fkProduto = fkProduto;
		this.fkPedido = fkPedido;
		this.quantidade = quantidade;
	}

	private void verificaId() {
		if (listaIdsProdutoPedido.isEmpty()) {
			this.idProdutoPedido = 1;
			listaIdsProdutoPedido.add(idProdutoPedido);
		} else {
			this.idProdutoPedido = listaIdsProdutoPedido.get(listaIdsProdutoPedido.size() - 1) + 1;
			listaIdsProdutoPedido.add(idProdutoPedido);
		}
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public int getIdProdutoPedido() {
		return idProdutoPedido;
	}

	public int getFkProduto() {
		return fkProduto;
	}

	public int getFkPedido() {
		return fkPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public static Map<Integer, ProdutosPedido> getMapaProdutosPedido() {
		return mapaProdutosPedido;
	}

	@Override
	public String toString() {
		return "ProdutosPedido [tipoDado=" + tipoDado + ", idProdutoPedido=" + idProdutoPedido + ", fkProduto="
				+ fkProduto + ", fkPedido=" + fkPedido + ", quantidade=" + quantidade + "]";
	}

}
