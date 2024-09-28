package br.com.terratech_store.vendas;

import java.util.HashMap;
import java.util.Map;

public class Endereco {
	private String tipoDado = "Endereco";
	private int idEndereco;
	private String cep;
	private String uf;
	private String cidade;
	private String bairro;
	private int numero;
	private static Map<Integer, Endereco> mapaEndereco = new HashMap<>();

	public Endereco() {
	}

	public Endereco(String tipoDado, int idendereco, String cep, String uf, String cidade, String bairro, int numero) {
		this.idEndereco = idendereco;
		this.cep = cep;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
	}

	public String getTipoDado() {
		return tipoDado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public static Map<Integer, Endereco> getMapaEndereco() {
		return mapaEndereco;
	}

	@Override
	public String toString() {
		return "Endereco [tipoDado=" + tipoDado + ", idEndereco=" + idEndereco + ", cep=" + cep + ", uf=" + uf
				+ ", cidade=" + cidade + ", bairro=" + bairro + ", numero=" + numero + "]";
	}

}
