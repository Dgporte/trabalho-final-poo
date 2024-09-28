package br.com.terratech_store.catalogo_produtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Produto {
	private String tipoDado = "Produto";
	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private double precoProduto;
	private int estoqueProduto;
	private int fkCategoria;
	private static List<Integer> listaIdsProduto = new ArrayList<>();
	private static Map<Integer, Produto> mapaProduto = new HashMap<>();

	public Produto() {
	}

	public Produto(String tipoDado, String nomeProduto, String descricaoProduto, double precoProduto,
			int estoqueProduto, int fkCategoria) {
		verificaId();
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
		this.estoqueProduto = estoqueProduto;
		this.fkCategoria = fkCategoria;
	}

	private void verificaId() {
		if (listaIdsProduto.isEmpty()) {
			this.idProduto = 1;
			listaIdsProduto.add(idProduto);
		} else {
			this.idProduto = listaIdsProduto.get(listaIdsProduto.size() - 1) + 1;
			listaIdsProduto.add(idProduto);
		}
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(int estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public static void setMapaProduto(Map<Integer, Produto> mapaProduto) {
		Produto.mapaProduto = mapaProduto;
	}

	public int getFkCategoria() {
		return fkCategoria;

	}

	public static Map<Integer, Produto> getMapaProduto() {
		return mapaProduto;
	}

	@Override
	public String toString() {
		return "Produto [tipoDado=" + tipoDado + ", idProduto=" + idProduto + ", nomeProduto=" + nomeProduto
				+ ", descricaoProduto=" + descricaoProduto + ", precoProduto=" + precoProduto + ", estoqueProduto="
				+ estoqueProduto + ", fkCategoria=" + fkCategoria + "]";
	}

}
