package br.net.ops.kamino.gui.console;

import java.util.List;

import br.net.ops.kamino.business.ConversorCSVDespesas;
import br.net.ops.kamino.business.SalvarDespesas;
import br.net.ops.kamino.entity.Despesa;
import br.net.ops.kamino.gateway.mysql.connection.ConnectionConfig;
import br.net.ops.kamino.gui.base.Presenter;
import br.net.ops.kamino.gui.base.View;

/**
 * 
 * @author cedulio
 *
 */
public class ProcessamentoConsolePresenter extends Presenter {

	private ConversorCSVDespesas conversor;
	private SalvarDespesas salvarDespesas;
	private String[] args;

	public ProcessamentoConsolePresenter(String[] args2) {
		this.args = args2;
	}

	public void init() {
		setConversor(createNewConversor());
		setSalvarDespesas(createNewSalvarDespesas());

		super.init();
	}

	private SalvarDespesas createNewSalvarDespesas() {
		return new SalvarDespesas(createConnectionConfig());
	}

	private ConnectionConfig createConnectionConfig() {

		ConnectionConfig config = new ConnectionConfig();
		config.setHost(args[1]);
		config.setPort(args[2]);
		config.setSchema(args[3]);
		config.setUser(args[4]);
		config.setPass(args[5]);
		return config;
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

	public void onSelectFilePath(String filePath) {
		iniciarProcessamento(filePath);
	}

	private void iniciarProcessamento(String filePath) {
		try {
			List<Despesa> despesas = getConversor().exec(filePath);

			getSalvarDespesas().exec(despesas);
			
			System.out.println(String.format("Total de registros processados: %d.",
					despesas.size()));

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
