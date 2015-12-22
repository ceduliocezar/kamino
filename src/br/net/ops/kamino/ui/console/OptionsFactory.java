package br.net.ops.kamino.ui.console;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * @author cedulio
 *
 */
public class OptionsFactory {

	public static final String LONG_HOST = "host";
	public static final String HOST = "h";
	public static final String LONG_USER = "user";
	public static final String USER = "u";
	public static final String LONG_USER_PASS = "user_pass";
	public static final String USER_PASS = "up";
	public static final String LONG_SCHEMA = "schema";
	public static final String SCHEMA = "s";
	public static final String LONG_HOST_PORT = "host_port";
	public static final String HOST_PORT = "hp";
	public static final String LONG_HELP = "help";
	public static final String LONG_FILE_PATH = "file_path";
	public static final String FILE_PATH = "fp";

	public static Options getCommandLineOptions() {

		Options options = new Options();
		options.addOption(criarOpcaoHelp());
		options.addOption(criarOpcaoFilePath());
		options.addOption(criarOpcaoEnderecoHostDataBase());
		options.addOption(criarOpcaoPortaHostDatabase());
		options.addOption(criarOpcaoUsuario());
		options.addOption(criarOpcaoSenha());
		options.addOption(criarOpcaoDatabaseName());

		return options;
	}

	private static Option criarOpcaoFilePath() {
		return new Option(FILE_PATH, LONG_FILE_PATH, true,
				"Caminho para o arquivo CSV. (Obrigatorio)");
	}

	private static Option criarOpcaoDatabaseName() {
		return new Option(SCHEMA, LONG_SCHEMA, true,
				"Nome da base de dados. (Obrigatorio)");
	}

	private static Option criarOpcaoSenha() {
		return new Option(USER_PASS, LONG_USER_PASS, true,
				"Senha para acesso a base de dados. (Obrigatorio)");
	}

	private static Option criarOpcaoUsuario() {
		return new Option(USER, LONG_USER, true,
				"Usuario para acesso a base de dados. (Obrigatorio)");
	}

	private static Option criarOpcaoEnderecoHostDataBase() {
		return new Option(HOST, LONG_HOST, true,
				"Define o endereço da base de dados, exemplo: 192.168.0.46 . (Obrigatorio)");
	}

	private static Option criarOpcaoPortaHostDatabase() {

		return new Option(HOST_PORT, LONG_HOST_PORT, true,
				"Define a porta para acesso a base de dados. (Obrigatorio)");
	}

	private static Option criarOpcaoHelp() {
		return new Option(LONG_HELP, "Show help.");
	}
}
