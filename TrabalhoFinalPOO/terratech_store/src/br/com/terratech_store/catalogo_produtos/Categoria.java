package br.com.terratech_store.catalogo_produtos;

import java.util.HashMap;
import java.util.Map;

public class Categoria {
	private String tipoDado = "Categoria";
	private int idCategoria;
	private String nomeCategoria;
	private static Map<Integer, Categoria> mapaCategoria = new HashMap<>();

	public Categoria() {

	}

	public Categoria(String tipoDado, int idCategoria, String nomeCategoria) {
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public static Map<Integer, Categoria> getMapaCategoria() {
		return mapaCategoria;
	}

	@Override
	public String toString() {
		return "Categoria [tipoDado=" + tipoDado + ", idCategoria=" + idCategoria + ", nomeCategoria=" + nomeCategoria
				+ "]";
	}

}
