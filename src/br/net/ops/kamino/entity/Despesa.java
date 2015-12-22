package br.net.ops.kamino.entity;

import java.util.Date;

/**
 * 
 * @author cedulio
 *
 */
public class Despesa extends Entity {

	private int ano;
	private int mes;
	private String senador;
	private String tipoDespesa;
	private String cnpjCpf;
	private String fornecedor;
	private String documento;
	private Date data;
	private String detalhamento;
	private double valor;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getSenador() {
		return senador;
	}

	public void setSenador(String senador) {
		this.senador = senador;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDetalhamento() {
		return detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\nano:" + ano);
		sb.append("\nmes:" + mes);
		sb.append("\nsenador:" + senador);
		sb.append("\ntipoDespesa:" + tipoDespesa);
		sb.append("\ncnpjCpf:" + cnpjCpf);
		sb.append("\nfornecedor:" + fornecedor);
		sb.append("\ndocumento:" + documento);
		sb.append("\ndata:" + data);
		sb.append("\ndetalhamento:" + detalhamento);
		sb.append("\nvalor:" + valor);

		return sb.toString();
	}

}
