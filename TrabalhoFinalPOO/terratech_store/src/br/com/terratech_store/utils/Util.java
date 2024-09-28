package br.com.terratech_store.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Util {
	private static boolean isLoading = false;

	private static Logger logger = Logger.getLogger(Util.class.getName());

	private Util() {
		throw new IllegalStateException("Erro ao tentar criar uma instância desta classe!");
	}

	public static Logger setupLogger() {
		logger.setUseParentHandlers(false);

		customizer();

		ConsoleHandler customHandler = new ConsoleHandler();

		customHandler.setFormatter(new Formatter() {
			@Override
			public String format(LogRecord rec) {
				if (isLoading) {
					return rec.getMessage();
				} else {
					return rec.getMessage() + "\n";
				}

			}
		});

		logger.addHandler(customHandler);

		return logger;
	}

	public static void customizer() {
		if (logger.getHandlers().length > 0) {
			for (Handler log : logger.getHandlers()) {
				logger.removeHandler(log);
				if (logger.getHandlers().length == 1) {
					break;
				}
			}
		}
	}

	public static void aguardar(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (Exception e) {
			setupLogger().log(Level.INFO, "Erro no método Util.aguardar()");
		}
	}

	public static void limpar() {
		setupLogger().log(Level.INFO, "\n".repeat(100));
	}

	public static void carregando(String mensagem, String repetidor) {
		isLoading = true;
		limpar();
		setupLogger().log(Level.INFO, mensagem);
		for (int i = 0; i < 3; i++) {
			setupLogger().log(Level.INFO, repetidor);
			aguardar(1000);
		}
		limpar();
		isLoading = false;
	}

}
