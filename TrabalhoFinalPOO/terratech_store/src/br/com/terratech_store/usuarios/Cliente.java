package br.com.terratech_store.usuarios;

import java.util.HashMap;
import java.util.Map;

import br.com.terratech_store.enums.TipoUsuarioEnum;

public class Cliente extends Usuario {
	private int idCliente;
	private int fkUsuario;
	private int fkEndereco;
	private String telefone;
	private String cpf;
	private static Map<Integer, Cliente> mapaCliente = new HashMap<>();

	public Cliente() {
		super();
	}

	public Cliente(TipoUsuarioEnum tipoUsuario, int idCliente, String nome, String email, String senha) {
		super(tipoUsuario, nome, email, senha);
		this.idCliente = idCliente;
		this.fkUsuario = super.getIdUsuario();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getfkUsuario() {
		return fkUsuario;
	}

	public int getIdEndereco() {
		return fkEndereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setIdEndereco(int idEndereco) {
		this.fkEndereco = idEndereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public static Map<Integer, Cliente> getMapaCliente() {
		return mapaCliente;
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [tipoUsuario=" + getTipoUsuario() + ", idCliente=" + idCliente
				+ ", fkUsuario=" + fkUsuario + ", fkEndereco=" + fkEndereco + ", telefone=" + telefone + ", cpf=" + cpf
				+ "]";
	}

}
