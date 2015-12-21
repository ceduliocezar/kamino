package br.net.ops.kamino;

import br.net.ops.kamino.gui.console.ProcessamentoConsolePresenter;

/**
 * 
 * @author cedulio
 *
 */
public class MainConsole {

	public static void main(String[] args) {
		try {

			ProcessamentoConsolePresenter presenter = new ProcessamentoConsolePresenter(
					args);
			presenter.init();
			presenter.onSelectFilePath(args[0]);

		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("Ocorreu uma falha e não foi possível prosseguir. Motivo:"
							+ e.getMessage());
		}

	}

}
