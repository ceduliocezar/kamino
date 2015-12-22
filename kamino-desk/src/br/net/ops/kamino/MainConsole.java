package br.net.ops.kamino;

import java.util.Calendar;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import br.net.ops.kamino.gateway.mysql.connection.KaminoConfig;
import br.net.ops.kamino.ui.console.OptionsFactory;
import br.net.ops.kamino.ui.console.ProcessamentoConsolePresenter;

/**
 * 
 * @author cedulio
 *
 */
public class MainConsole {

	private final static String JAR_NAME = "kamino";

	public static void main(String[] args) {

		try {
			Options options = OptionsFactory.getCommandLineOptions();
			CommandLineParser parser = new BasicParser();
			CommandLine line = parser.parse(options, args);

			if (deveMostrarHelp(line)) {
				showHelp(options);
			} else {
				iniciarExecucao(line);
			}

		} catch (ParseException exp) {
			exp.printStackTrace();
			System.err
					.println("Não foi possível efetuar o parse da linha de comando.  Motivo: "
							+ exp.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Ocorreu uma falha e não foi possível prosseguir. Motivo:"
							+ e.getMessage());
		}
	}

	private static void iniciarExecucao(CommandLine line) {

		KaminoConfig config = getConfig(line);

		System.out.println("[BEGIN]" + Calendar.getInstance().getTime());

		ProcessamentoConsolePresenter presenter = new ProcessamentoConsolePresenter(
				config);
		presenter.init();

		System.out.println("[END]" + Calendar.getInstance().getTime());
	}

	private static KaminoConfig getConfig(CommandLine line) {
		KaminoConfig config = new KaminoConfig();

		config.setHost(line.getOptionValue(OptionsFactory.LONG_HOST));
		config.setPort(line.getOptionValue(OptionsFactory.LONG_HOST_PORT));
		config.setSchema(line.getOptionValue(OptionsFactory.LONG_SCHEMA));
		config.setUser(line.getOptionValue(OptionsFactory.LONG_USER));
		config.setPass(line.getOptionValue(OptionsFactory.LONG_USER_PASS));
		config.setCsvFilePath(line
				.getOptionValue(OptionsFactory.LONG_FILE_PATH));

		return config;
	}

	private static boolean deveMostrarHelp(CommandLine line) {
		return verificarPossuiComandoHelp(line)
				|| verificarNaoPossuiOptions(line);
	}

	private static boolean verificarPossuiComandoHelp(CommandLine line) {
		return line.hasOption("help");
	}

	private static void showHelp(Options options) {

		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(JAR_NAME, options);

		System.out
				.println("\n\nExemplo de uso: \njava -jar /home/usuario/kamino.jar"
						+ " -file_path /home/usuario/Downloads/2015.csv"
						+ " -host localhost -host_port 3306 -schema ops_kamino"
						+ " -user root -user_pass your_pass");

	}

	private static boolean verificarNaoPossuiOptions(CommandLine line) {
		return line.getOptions().length == 0;
	}

}
