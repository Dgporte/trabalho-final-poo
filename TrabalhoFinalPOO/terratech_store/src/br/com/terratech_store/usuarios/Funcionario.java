package br.com.terratech_store.usuarios;

import java.util.HashMap;
import java.util.Map;

import br.com.terratech_store.enums.TipoUsuarioEnum;

public class Funcionario extends Usuario {
	private int idFuncionario;
	private int fkUsuario;
	private static Map<Integer, Funcionario> mapaFuncionario = new HashMap<>();

	public Funcionario() {
		super();
	}

	public Funcionario(TipoUsuarioEnum tipoUsuario, int idFuncionario, String nome, String email, String senha) {
		super(tipoUsuario, nome, email, senha);
		this.idFuncionario = idFuncionario;
		this.fkUsuario = super.getIdUsuario();
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public int getfkUsuario() {
		return fkUsuario;
	}

	public static Map<Integer, Funcionario> getMapaFuncionario() {
		return mapaFuncionario;
	}

	@Override
	public String toString() {
		return super.toString() + "Funcionario [ " + ", idFuncionario=" + idFuncionario + ", fkUsuario="

				+ fkUsuario + "]";
	}

}
