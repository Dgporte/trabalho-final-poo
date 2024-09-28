package br.com.terratech_store.menus;

import java.util.Scanner;
import java.util.logging.Logger;

import br.com.terratech_store.funcionario.GerenciarClientes;
import br.com.terratech_store.funcionario.GerenciarProdutos;
import br.com.terratech_store.usuarios.Usuario;
import br.com.terratech_store.utils.Util;

public class MenuFuncionario {
	public void telaFuncionario(int fkUsuario) {
		Logger logger = Util.setupLogger();
		Scanner sc = new Scanner(System.in);
		Usuario funcionario = Usuario.getMapaUsuarios().get(fkUsuario);

		logger.info("Olá, " + funcionario.getNome() + "! Bem vindo de volta!");
		logger.info("Aqui estão suas opções:\n\n [1] - Gerenciar produtos \n [2] - Gerenciar clientes\n [3] - Sair\n ");
		String entrarSystem = sc.nextLine();
		Util.limpar();
		switch (entrarSystem) {
		case "1":
			new GerenciarProdutos().sistemaProdutos();
			break;
		case "2":
			new GerenciarClientes().menu(fkUsuario);
			break;
		case "3":
			Saida.executarSaida();
			break;
		default:
			Util.carregando("Opção Inválida", ".");
			telaFuncionario(fkUsuario);
			break;

		}
		sc.close();
	}
}
