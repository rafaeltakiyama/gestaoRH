package br.com.lacerda.gestaorh.model;

import java.io.Serializable;
import java.util.List;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class CandidatoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCandidato;
	private AreaAtuacaoModel areaAtuacaoModel;
	private String nome;
	private String cpf;
	private String rg;
	private String data_nasc;
	private String email;
	private String endereco;
	private String escolaridade;
	private String instituicao_ensino;
	private String data_conclusao;
	
    public Boolean salvar(List<CandidatoModel> element) {
        return DaoFactory.get(CandidatoModel.class).addListObj(element);
    }

	public int getCodCandidato() {
		return codCandidato;
	}

	public void setCodCandidato(int codCandidato) {
		this.codCandidato = codCandidato;
	}

	public AreaAtuacaoModel getAreaAtuacaoModel() {
		return areaAtuacaoModel;
	}

	public void setAreaAtuacaoModel(AreaAtuacaoModel areaAtuacaoModel) {
		this.areaAtuacaoModel = areaAtuacaoModel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getInstituicao_ensino() {
		return instituicao_ensino;
	}

	public void setInstituicao_ensino(String instituicao_ensino) {
		this.instituicao_ensino = instituicao_ensino;
	}

	public String getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(String data_conclusao) {
		this.data_conclusao = data_conclusao;
	}

}
