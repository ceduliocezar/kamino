package br.net.ops.kamino.ui.console;

import java.util.List;

import br.net.ops.kamino.business.ConversorCSVDespesas;
import br.net.ops.kamino.business.SalvarDespesas;
import br.net.ops.kamino.entity.Despesa;
import br.net.ops.kamino.gateway.mysql.connection.KaminoConfig;
import br.net.ops.kamino.ui.base.Presenter;
import br.net.ops.kamino.ui.base.View;

/**
 * 
 * @author cedulio
 *
 */
public class ProcessamentoConsolePresenter extends Presenter {

	private ConversorCSVDespesas conversor;
	private SalvarDespesas salvarDespesas;
	private KaminoConfig config;

	public ProcessamentoConsolePresenter(KaminoConfig config) {
		this.config = config;
	}

	public void init() {
		super.init();
		setConversor(createNewConversor());
		setSalvarDespesas(createNewSalvarDespesas());

		iniciarProcessamento();
	}

	private SalvarDespesas createNewSalvarDespesas() {
		return new SalvarDespesas(config);
	}

	private ConversorCSVDespesas createNewConversor() {
		return new ConversorCSVDespesas();
	}

	private void setConversor(ConversorCSVDespesas conversorCSVDespesas) {
		conversor = conversorCSVDespesas;
	}

	@Override
	protected View createNewInstanceView() {
		return new ProcessamentoConsoleView();
	}

	private void iniciarProcessamento() {
		try {
			List<Despesa> despesas = getConversor().exec(
					config.getCsvFilePath());

			getSalvarDespesas().exec(despesas);

			System.out.println(String.format(
					"Total de registros processados: %d.", despesas.size()));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possível converter. Motivo:"
					+ e.getMessage());
		}
	}

	public ConversorCSVDespesas getConversor() {
		return conversor;
	}

	public SalvarDespesas getSalvarDespesas() {
		return salvarDespesas;
	}

	public void setSalvarDespesas(SalvarDespesas salvarDespesas) {
		this.salvarDespesas = salvarDespesas;
	}

}
