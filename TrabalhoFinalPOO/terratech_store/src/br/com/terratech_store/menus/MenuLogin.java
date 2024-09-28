package br.com.terratech_store.menus;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.terratech_store.enums.TipoUsuarioEnum;
import br.com.terratech_store.usuarios.Usuario;
import br.com.terratech_store.utils.Util;

public class MenuLogin {
	public void login() {
		Logger logger = Util.setupLogger();
		Scanner sc = new Scanner(System.in);
		boolean logado = false;
		logger.log(Level.INFO, "Informe o seu Email: ");
		String email = sc.nextLine();
		Util.limpar();
		logger.log(Level.INFO, "Informe a sua senha: ");
		String senha = sc.nextLine();
		Util.limpar();

		for (Map.Entry<Integer, Usuario> usuario : Usuario.getMapaUsuarios().entrySet()) {
			if (usuario.getValue().fazerLogin(email, senha)) {
				logado = true;
				if (usuario.getValue().getTipoUsuario().equals(TipoUsuarioEnum.CLIENTE)) {
					new MenuDetalhesProduto().detalhesProdutos(usuario.getValue().getIdUsuario());
					break;
				} else if (usuario.getValue().getTipoUsuario().equals(TipoUsuarioEnum.FUNCIONARIO)) {
					new MenuFuncionario().telaFuncionario(usuario.getValue().getIdUsuario());
					break;
				}
			}
		}

		if (!logado) {
			Util.limpar();
			logger.log(Level.INFO, "Email ou senha incorretos. Tente novamente!");
			Util.aguardar(3000);
			Util.limpar();
			login();
		}
		sc.close();
	}
}
