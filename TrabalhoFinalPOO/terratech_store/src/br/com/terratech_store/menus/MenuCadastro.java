package br.com.terratech_store.menus;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.terratech_store.enums.TipoUsuarioEnum;
import br.com.terratech_store.usuarios.Cliente;
import br.com.terratech_store.usuarios.Usuario;
import br.com.terratech_store.utils.Util;
import br.com.terratech_store.utils.Verificacao;

public class MenuCadastro {
	public void cadastrar() {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();

		logger.log(Level.INFO, "Informe o nome: ");
		String nome = sc.nextLine();
		Util.limpar();

		if (Verificacao.verificarNome(nome)) {
			Util.setupLogger().log(Level.INFO, "O nome não pode conter números ou caracteres especiais!");
			Util.aguardar(2000);
			Util.limpar();
			cadastrar();
		}

		logger.log(Level.INFO, "Informe o email: ");
		String email = sc.nextLine();
		Util.limpar();

		if (!Verificacao.verificarEmail(email) || Verificacao.emailExistente(email)) {
			Util.setupLogger().log(Level.INFO, "O email informado é inválido ou já está cadastrado. Tente novamente!");
			Util.aguardar(2000);
			Util.limpar();
			cadastrar();
		}

		logger.log(Level.INFO, "Informe a senha: ");
		String senha = sc.nextLine();
		Util.limpar();

		if (!Verificacao.verificarSenha(senha)) {
			Util.setupLogger().log(Level.INFO, "A senha deve conter no mínimo 3 dígitos.");
			Util.aguardar(2000);
			Util.limpar();
			cadastrar();
		}

		Cliente novoCliente = new Cliente(TipoUsuarioEnum.CLIENTE, Verificacao.proximoId(), nome.trim(), email.trim(),
				senha.trim());
		Cliente.getMapaCliente().put(novoCliente.getIdCliente(), novoCliente);
		Usuario.getMapaUsuarios().put(novoCliente.getfkUsuario(), novoCliente);
		logger.log(Level.INFO, "\t\t\t\t\t\t\t\tCadastro Realizado com sucesso!");
		Util.aguardar(3000);
		MenuInicial.menuInical();
		sc.close();
	}
}
