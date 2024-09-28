package br.com.terratech_store.menus;

import java.io.IOException;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.terratech_store.io.LeituraEscrita;

import br.com.terratech_store.utils.Util;

public class MenuInicial {

	public void inicializarDados() {
		try {
			LeituraEscrita.leitor("dados");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void imprimirLogo() {
		Logger logger = Util.setupLogger();
		logger.log(Level.INFO,
				".----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.");// _______
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");// |\___
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| |  _________   | || |  _________   | || |  _______     | || |  _______     | || |      __      | || |  _________   | || |  _________   | || |     ______   | || |  ____  ____  | |"); // \|___
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| |  _________   | || |  _________   | || |  _______     | || |  _______     | || |      __      | || |  _________   | || |  _________   | || |     ______   | || |  ____  ____  | |");// \
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| | |  _   _  |  | || | |_   ___  |  | || | |_   __ \\    | || | |_   __ \\    | || |     /  \\     | || | |  _   _  |  | || | |_   ___  |  | || |   .' ___  |  | || | |_   ||   _| | |");// \
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| | |_/ | | \\_|  | || |   | |_  \\_|  | || |   | |__) |   | || |   | |__) |   | || |    / /\\ \\    | || | |_/ | | \\_|  | || |   | |_  \\_|  | || |  / .'   \\_|  | || |   | |__| |   | |");// \
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| |     | |      | || |   |  _|  _   | || |   |  __ /    | || |   |  __ /    | || |   / ____ \\   | || |     | |      | || |   |  _|  _   | || |  | |         | || |   |  __  |   | |");// \|__|
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| |    _| |_     | || |  _| |___/ |  | || |  _| |  \\ \\_  | || |  _| |  \\ \\_  | || | _/ /    \\ \\_ | || |    _| |_     | || |  _| |___/ |  | || |  \\ `.___.'\\  | || |  _| |  | |_  | |");
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| |   |_____|    | || | |_________|  | || | |____| |___| | || | |____| |___| | || ||____|  |____|| || |   |_____|    | || | |_________|  | || |   `._____.'  | || | |____||____| | |");
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |");
		Util.aguardar(200);
		logger.log(Level.INFO,
				"| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |");
		Util.aguardar(200);
		logger.log(Level.INFO,
				" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n\n\n");
		Util.aguardar(200);
	}

	public static void menuInical() {
		Scanner sc = new Scanner(System.in);
		Logger logger = Util.setupLogger();

		boolean opcaoInvalida = true;

		while (opcaoInvalida) {
			Util.limpar();
			new MenuInicial().imprimirLogo();
			logger.log(Level.INFO,
					"\t\t\t\t\t\t\t\tBem vindo(a) à TerraTech Store! O que deseja fazer? \n\n\t\t\t\t\t\t\t\t\t\t[1] - Fazer Login\n\t\t\t\t\t\t\t\t\t\t[2] - Cadastrar na loja\n\t\t\t\t\t\t\t\t\t\t[3] - Sair");
			String opcao = sc.nextLine();
			Util.limpar();

			switch (opcao.trim()) {
			case "1":
				new MenuLogin().login();

				opcaoInvalida = false;
				break;
			case "2":
				new MenuCadastro().cadastrar();
				opcaoInvalida = false;
				break;
			case "3":
				opcaoInvalida = false;
				Saida.executarSaida();
				break;
			default:
				opcaoInvalida = true;
				Util.carregando("\t\t\t\t\t\t\t\tOpção inválida! Retornando ao menu", ".");
				Util.aguardar(2000);
				Util.limpar();

				break;

			}
		}
		sc.close();
	}
}
