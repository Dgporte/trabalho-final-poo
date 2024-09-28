package br.com.terratech_store.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.terratech_store.usuarios.Cliente;

public class Verificacao {

	private Verificacao() {
	}

	public static boolean verificarNome(String nome) {
		Pattern patternNumeros = Pattern.compile("[0-9\\W]");
		Matcher matcher = patternNumeros.matcher(nome.trim());
		return matcher.find();
	}

	public static boolean verificarEmail(String email) {
		String regexEmail = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
		Pattern patternEmail = Pattern.compile(regexEmail);
		Matcher matcher = patternEmail.matcher(email.trim());
		return matcher.matches();
	}

	public static boolean emailExistente(String email) {
		boolean emailExiste = false;
		for (Map.Entry<Integer, Cliente> cliente : Cliente.getMapaCliente().entrySet()) {
			if (cliente.getValue().getEmail().equals(email.trim())) {
				emailExiste = true;
			}
		}
		return emailExiste;
	}

	public static boolean verificarSenha(String senha) {
		return senha.trim().length() >= 3;
	}

	public static int proximoId() {
		List<Integer> listaId = new ArrayList<>();

		for (Map.Entry<Integer, Cliente> cliente : Cliente.getMapaCliente().entrySet()) {
			listaId.add(cliente.getValue().getIdCliente());
		}
		return listaId.size() + 1;
	}

	public static boolean clienteExiste(int idCliente) {
		boolean clienteExiste = false;
		for (Map.Entry<Integer, Cliente> cliente : Cliente.getMapaCliente().entrySet()) {
			if (cliente.getValue().getIdCliente() == idCliente) {
				clienteExiste = true;
				break;
			}
		}
		return clienteExiste;
	}
}
