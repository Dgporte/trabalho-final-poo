package br.com.terratech_store.menus;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;

import java.util.logging.Logger;

public class Saida {

	private Saida() {
	}

	public static void executarSaida() {
		setupLogger();

		// Logo de saída
		printHighlightedMessageGray(
				"  -------------------------------------------------------------------------------------------------------------------------------------------");
		printHighlightedMessageGray(
				"                                              ☼  Obrigado por usar o TERRATECH! Volte sempre!  ☼ ");
		printHighlightedMessageGray(
				"  -------------------------------------------------------------------------------------------------------------------------------------------");

		// Adicionando as folhas verdes ao redor do texto "TERRATECH"
		printHighlightedMessageGreen(
				"                        |          _____   _____   ____    ____       _      _____   _____    ____   _   _           |");
		printHighlightedMessageGreen(
				"                      .'|'.       |_   _| | ____| |  _ \\  |  _ \\     / \\    |_   _| | ____|  / ___| | | | |        .'|'.");
		printHighlightedMessageGreen(
				"                     /.'|\\ \\        | |   |  _|   | |_) | | |_) |   / _ \\     | |   |  _|   | |     | |_| |       /.'|\\ \\");
		printHighlightedMessageGreen(
				"                     | /|'.|        | |   | |___  |  _ <  |  _ <   / ___ \\    | |   | |___  | |___  |  _  |       | /|'.|");
		printHighlightedMessageGreen(
				"                      \\ |\\/         |_|   |_____| |_| \\_\\ |_| \\_\\ /_/   \\_\\   |_|   |_____|  \\____| |_| |_|        \\ |\\/");
		printHighlightedMessageGreen(
				"                       \\|/                                                                                          \\|/");

		// Desenho do computador (ASCII) em cinza
		printHighlightedMessageGray("                                                                   ___________");
		printHighlightedMessageGray("                                                                  |.---------.|");
		printHighlightedMessageGray("                                                                  ||         ||");
		printHighlightedMessageGray("                                                                  ||         ||");
		printHighlightedMessageGray("                                                                  ||         ||");
		printHighlightedMessageGray("                                                                  |'---------'|");
		printHighlightedMessageGray("                                                                   `)__ ____('");
		printHighlightedMessageGray(
				"                                                                   [=== -- o ]--.");
		printHighlightedMessageGray(
				"                                                                 __'---------'__ \\ ");
		printHighlightedMessageGray(
				"                                                                [::::::::::: :::] )");
		printHighlightedMessageGray(
				"                                                                 `\"\"'\"\"\"\"\"'\"\"\"\"`/T\\");
		printHighlightedMessageGray(
				"                                                                                \\_/");
		printHighlightedMessageGray(
				"                                                                                    ");

		printHighlightedMessageGray(
				"  -------------------------------------------------------------------------------------------------------------------------------------------"); // Mensagem
																																									// final
		printHighlightedMessageGreen(
				"                                    ☼   Juntos, podemos construir um amanhã mais verde e mais conectado.   ☼");
		printHighlightedMessageGray(
				"  -------------------------------------------------------------------------------------------------------------------------------------------"); // Mensagem
																																									// final

	}

	private static void setupLogger() {
		Logger rootLogger = Logger.getLogger("");
		for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
			rootLogger.removeHandler(handler);
		}

		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new Formatter() {
			@Override
			public String format(java.util.logging.LogRecord record) {
				return record.getMessage() + System.lineSeparator();
			}
		});

		rootLogger.addHandler(consoleHandler);
		rootLogger.setLevel(Level.ALL);
	}

	private static void printHighlightedMessageGreen(String message) {
		String RESET = "\033[0m";
		String GREEN = "\033[32m";
		System.out.println(GREEN + message + RESET);
	}

	private static void printHighlightedMessageGray(String message) {
		String RESET = "\033[0m";
		String GRAY = "\033[37m";
		System.out.println(GRAY + message + RESET);
	}
}
