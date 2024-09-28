package br.com.terratech_store.usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.terratech_store.enums.TipoUsuarioEnum;

public abstract class Usuario {
	private TipoUsuarioEnum tipoUsuario;
	private int idUsuario;
	private String nome;
	private String email;
	private String senha;
	private static List<Integer> listaIds = new ArrayList<>();
	private static Map<Integer, Usuario> mapaUsuarios = new HashMap<>();

	Usuario() {
	}

	Usuario(TipoUsuarioEnum tipoUsuario, String nome, String email, String senha) {
		if (listaIds.isEmpty()) {
			this.idUsuario = 1;
			listaIds.add(idUsuario);
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.tipoUsuario = tipoUsuario;
		} else {
			this.idUsuario = listaIds.get(listaIds.size() - 1) + 1;
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.tipoUsuario = tipoUsuario;
			listaIds.add(idUsuario);
		}
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	public boolean fazerLogin(String email, String senha) {
		return this.email.equals(email) && this.senha.equals(senha);
	}

	public static Map<Integer, Usuario> getMapaUsuarios() {
		return mapaUsuarios;
	}

	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}

}
