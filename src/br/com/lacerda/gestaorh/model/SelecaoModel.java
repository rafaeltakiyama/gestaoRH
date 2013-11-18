package br.com.lacerda.gestaorh.model;

import java.io.Serializable;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class SelecaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codSelecao;
	private CandidatoModel candidatoModel;
	private AreaAtuacaoModel areaAtuacaoModel;
	private VagaModel vagaModel;
	private EmpresaModel empresaModel;
	private EventoSeletivoModel eventoSeletivoModel;

	public Boolean salvar(SelecaoModel element) {
		return DaoFactory.get(SelecaoModel.class).addObject(element);
	}

	public int getCodSelecao() {
		return codSelecao;
	}

	public void setCodSelecao(int codSelecao) {
		this.codSelecao = codSelecao;
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

	public VagaModel getVagaModel() {
		return vagaModel;
	}

	public void setVagaModel(VagaModel vagaModel) {
		this.vagaModel = vagaModel;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	public EventoSeletivoModel getEventoSeletivoModel() {
		return eventoSeletivoModel;
	}

	public void setEventoSeletivoModel(EventoSeletivoModel eventoSeletivoModel) {
		this.eventoSeletivoModel = eventoSeletivoModel;
	}

}
