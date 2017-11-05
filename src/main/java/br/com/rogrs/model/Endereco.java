package br.com.rogrs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "ENDERECO")
public class Endereco extends AbstractPersistable<Long> {

	@Transient
	private static final long serialVersionUID = 1L;

	@Transient
	private static String FORMAT = "Endereco{cep='%s', logradouro='%s', complemento='%s', bairro='%s', localidade='%s', uf='%s', unidade='%s', ibge='%s', gia='%s', erro=%s}'";

	@NotEmpty
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String unidade;
	private String ibge;
	private String gia;
	private boolean erro;

	public Endereco() {

	}

	public Endereco(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public boolean isErro() {
		return erro;
	}

	@Override
	public String toString() {

		return String.format(FORMAT, cep, logradouro, complemento, bairro, localidade, uf, unidade, ibge, gia, erro);
	}

}
