package br.com.lacerda.gestaorh.model;

import java.io.Serializable;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class CandidatoAreaAtuacaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCandidatoAreaAtuacao;
	private CandidatoModel candidatoModel;
	private AreaAtuacaoModel areaAtuacaoModel;

	public Boolean salvar(CandidatoAreaAtuacaoModel element) {
		return DaoFactory.get(CandidatoAreaAtuacaoModel.class).addObject(
				element);
	}

	public int getCodCandidatoAreaAtuacao() {
		return codCandidatoAreaAtuacao;
	}

	public void setCodCandidatoAreaAtuacao(int codCandidatoAreaAtuacao) {
		this.codCandidatoAreaAtuacao = codCandidatoAreaAtuacao;
	}

	public CandidatoModel getCandidatoModel() {
		return candidatoModel;
	}

	public void setCandidatoModel(CandidatoModel candidatoModel) {
		this.candidatoModel = candidatoModel;
	}

	public AreaAtuacaoModel getAreaAtuacaoModel() {
		return areaAtuacaoModel;
	}

	public void setAreaAtuacaoModel(AreaAtuacaoModel areaAtuacaoModel) {
		this.areaAtuacaoModel = areaAtuacaoModel;
	}

}
