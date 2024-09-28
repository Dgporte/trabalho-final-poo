package br.com.terratech_store.funcionario;

import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.terratech_store.enums.TipoUsuarioEnum;
import br.com.terratech_store.menus.MenuFuncionario;
import br.com.terratech_store.menus.Saida;
import br.com.terratech_store.usuarios.Cliente;
import br.com.terratech_store.usuarios.Usuario;
import br.com.terratech_store.utils.Util;
import br.com.terratech_store.utils.Verificacao;

public class GerenciarClientes {

	public void menu(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();

		logger.info(
				"Qual opção deseja? \n\n[1] - Listar clientes cadastrados\n\n[2] - Cadastrar novo cliente\n\n[3] - Atualizar dados cliente\n\n[4] - Voltar\n\n");
		String opcao = sc.nextLine();
		Util.limpar();

		switch (opcao) {

		case "1":
			listarClientes(fkUsuario);
			break;

		case "2":
			cadastrarCliente(fkUsuario);
			break;

		case "3":
			atualizarDadosCliente(fkUsuario);
			break;

		case "4":
			new MenuFuncionario().telaFuncionario(fkUsuario);
			break;

		default:
			Util.carregando("Opção Inválida", ".");
			menu(fkUsuario);
			break;
		}

		sc.close();
	}

	public void listarClientes(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();
		for (Map.Entry<Integer, Cliente> cliente : Cliente.getMapaCliente().entrySet()) {
			logger.info("Id do cliente: " + cliente.getValue().getIdCliente());
			logger.info("Nome do cliente: " + cliente.getValue().getNome());
			logger.info("CPF do cliente: " + cliente.getValue().getCpf());
			logger.info("Email do cliente: " + cliente.getValue().getEmail());
			logger.info("Telefone do cliente: " + cliente.getValue().getTelefone());

			logger.info("\n\n");
		}

		logger.info("Digite:\n\n [1] - Para voltar \n\n [2] - Para sair");
		String opcao = sc.nextLine();
		Util.limpar();
		switch (opcao) {
		case "1":
			menu(fkUsuario);
			break;
		case "2":
			Saida.executarSaida();
			break;
		default:
			Util.carregando("Opção Inválida", ".");
			menu(fkUsuario);
			break;

		}
		sc.close();
	}

	public void cadastrarCliente(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();

		logger.log(Level.INFO, "Informe o nome do cliente: ");
		String nome = sc.nextLine();
		Util.limpar();

		if (Verificacao.verificarNome(nome)) {
			Util.setupLogger().log(Level.INFO, "O nome não pode conter números ou caracteres especiais!");
			Util.aguardar(2000);
			Util.limpar();
			cadastrarCliente(fkUsuario);
		}

		logger.log(Level.INFO, "Informe o email cliente: ");
		String email = sc.nextLine();
		Util.limpar();

		if (!Verificacao.verificarEmail(email) || Verificacao.emailExistente(email)) {
			Util.setupLogger().log(Level.INFO, "O email informado é inválido ou já está cadastrado. Tente novamente!");
			Util.aguardar(2000);
			Util.limpar();
			cadastrarCliente(fkUsuario);
		}

		logger.log(Level.INFO, "Informe a nova senha do cliente: ");
		String senha = sc.nextLine();
		Util.limpar();

		if (!Verificacao.verificarSenha(senha)) {
			Util.setupLogger().log(Level.INFO, "A senha deve conter no mínimo 3 dígitos.");
			Util.aguardar(2000);
			Util.limpar();
			cadastrarCliente(fkUsuario);
		}

		Cliente novoCliente = new Cliente(TipoUsuarioEnum.CLIENTE, Verificacao.proximoId(), nome.trim(), email.trim(),
				senha.trim());
		Cliente.getMapaCliente().put(novoCliente.getIdCliente(), novoCliente);
		Usuario.getMapaUsuarios().put(novoCliente.getfkUsuario(), novoCliente);
		logger.log(Level.INFO, "\t\t\t\t\t\t\t\tCadastro Realizado com sucesso!");
		Util.aguardar(3000);
		Util.limpar();
		menu(fkUsuario);
		sc.close();
	}

	public void atualizarDadosCliente(int fkUsuario) {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();
		int idCli = 0;

		logger.info("Informe o id do cliente que deseja alterar: ");
		String idCliente = sc.nextLine();
		Util.limpar();

		try {
			idCli = Integer.parseInt(idCliente);
		} catch (NumberFormatException err) {
			logger.info("O id deve ser um número inteiro.");
			Util.aguardar(3000);
			Util.limpar();
			atualizarDadosCliente(fkUsuario);
		}

		if (!Verificacao.clienteExiste(idCli)) {
			logger.info("O cliente informado não existe!");
			Util.aguardar(3000);
			Util.limpar();
			atualizarDadosCliente(fkUsuario);
		} else {

			logger.info("Informe o novo nome do cliente: ");
			String nome = sc.nextLine();

			if (Verificacao.verificarNome(nome)) {
				logger.info("O nome não pode conter números ou caracteres especiais!");
				Util.aguardar(2000);
				Util.limpar();
				atualizarDadosCliente(fkUsuario);
			}

			logger.info("Informe o novo email cliente: ");
			String email = sc.nextLine();
			Util.limpar();

			if (!Verificacao.verificarEmail(email) || Verificacao.emailExistente(email)) {
				logger.info("O email informado é inválido ou já está cadastrado. Tente novamente!");
				Util.aguardar(2000);
				Util.limpar();
				atualizarDadosCliente(fkUsuario);
			}

			logger.info("Informe a nova senha do cliente: ");
			String senha = sc.nextLine();
			Util.limpar();

			if (!Verificacao.verificarSenha(senha)) {
				logger.info("A senha deve conter no mínimo 3 dígitos.");
				Util.aguardar(2000);
				Util.limpar();
				atualizarDadosCliente(fkUsuario);
			}

			Cliente.getMapaCliente().get(idCli).setNome(nome);
			Cliente.getMapaCliente().get(idCli).setEmail(email);
			Cliente.getMapaCliente().get(idCli).setSenha(senha);
			Usuario.getMapaUsuarios().get(Cliente.getMapaCliente().get(idCli).getfkUsuario()).setNome(nome);
			Usuario.getMapaUsuarios().get(Cliente.getMapaCliente().get(idCli).getfkUsuario()).setEmail(email);
			Usuario.getMapaUsuarios().get(Cliente.getMapaCliente().get(idCli).getfkUsuario()).setSenha(senha);
			logger.info("\t\t\t\t\t\t\t\tAlteração Realizada com sucesso!");
			Util.aguardar(3000);
			Util.limpar();
			menu(fkUsuario);

		}
		sc.close();
	}

}
