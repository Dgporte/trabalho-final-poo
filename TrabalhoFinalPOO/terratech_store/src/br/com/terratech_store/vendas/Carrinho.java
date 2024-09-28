package br.com.terratech_store.vendas;

import java.util.*;

public class Carrinho {
	private String tipoDado = "Carrinho";
	private int idCarrinho;
	private int fkCliente;
	private double valorTotal;
	private List<ProdutosPedido> produtosPedido;
	private static List<Integer> listaIdsCategoria = new ArrayList<>();
	private static Map<Integer, Carrinho> mapaCarrinho = new HashMap<>();

	public Carrinho() {
	}

	public Carrinho(String tipoDado, int fkCliente) {
		verificaId();
		this.fkCliente = fkCliente;
		this.produtosPedido = new ArrayList<>();
	}

	private void verificaId() {
		if (listaIdsCategoria.isEmpty()) {
			this.idCarrinho = 1;
			listaIdsCategoria.add(idCarrinho);
		} else {
			this.idCarrinho = listaIdsCategoria.get(listaIdsCategoria.size() - 1) + 1;
			listaIdsCategoria.add(idCarrinho);
		}
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public int getFkCliente() {
		return fkCliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ProdutosPedido> getProdutosPedido() {
		return produtosPedido;
	}

	public static Map<Integer, Carrinho> getMapaCarrinho() {
		return mapaCarrinho;
	}

	/*
	 * public void adicionarProduto(int idProduto, int quantidade) { for
	 * (Map.Entry<Integer, Produto> produto : Produto.getMapaProduto().entrySet()) {
	 * if (produto.getValue().getIdProduto() == idProduto &&
	 * produto.getValue().getEstoqueProduto() >= quantidade) {
	 * 
	 * } } }
	 */

	@Override
	public String toString() {
		return "Carrinho [tipoDado=" + tipoDado + ", idCarrinho=" + idCarrinho + ", fkCliente=" + fkCliente
				+ ", valorTotal=" + valorTotal + ", produtosPedido=" + produtosPedido + "]";
	}

}
