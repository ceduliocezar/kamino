package br.net.ops.kamino.business;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.net.ops.kamino.entity.Despesa;

import com.opencsv.CSVReader;

/**
 * 
 * @author cedulio
 *
 */
public class ConversorCSVDespesas extends UseCase {

	private DateFormat format = new SimpleDateFormat("dd/MM/yy");

	public List<Despesa> exec(String csvFilePath) throws IOException {

		System.out.println("Iniciando conversão");

		CSVReader reader = new CSVReader(new FileReader(csvFilePath), ';',
				'\"', 2);

		String[] nextLine;
		Despesa despesa;

		List<Despesa> despesas = new ArrayList<Despesa>();

		long totalLidos = 2; // CONTAR 2 linhas cabeçalho

		while ((nextLine = reader.readNext()) != null) {
			totalLidos++;

			try {
				despesa = convert(nextLine);
				despesas.add(despesa);
			} catch (Exception e) {
				e.printStackTrace();
				tratarErroConversao(nextLine, totalLidos);
			}
		}
		System.out
				.println("Finalizou conversão total de registros convertidos:"
						+ despesas.size());
		return despesas;
	}

	private void tratarErroConversao(String[] registro, long totalLidos) {

		System.out.print(">>FALHA: Não foi possível converter o registro:");

		StringBuilder sb = new StringBuilder("[");

		for (String string : registro) {
			sb.append(string);
		}
		sb.append("]");

		System.out.println(sb.toString());
		System.out.println(String.format(
				">>FALHA: Registros lidos até o momento: %d", totalLidos));

	}

	private Despesa convert(String[] registro) throws ParseException {
		Despesa despesa = new Despesa();

		int index = -1;
		despesa.setAno(Integer.valueOf(registro[++index]));
		despesa.setMes(Integer.valueOf(registro[++index]));
		despesa.setSenador(registro[++index]);
		despesa.setTipoDespesa(registro[++index]);
		despesa.setCnpjCpf(registro[++index]);
		despesa.setFornecedor(registro[++index]);
		despesa.setDocumento(registro[++index]);
		despesa.setData(getDataFromText(registro[++index]));
		despesa.setDetalhamento(registro[++index]);
		despesa.setValor(getDoubleValueFromText(registro[++index]));

		return despesa;
	}

	/**
	 * @param string
	 * @return
	 */
	private double getDoubleValueFromText(String string) {

		string = string.replace(',', '.');
		return Double.valueOf(string);
	}

	private Date getDataFromText(String dateString) throws ParseException {

		Date date = format.parse(dateString);

		return date;
	}

}
