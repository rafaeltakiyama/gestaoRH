package br.com.lacerda.gestaorh.model;

import java.io.Serializable;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class EmpresaAreaAtuacaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codEmpresaAreaAtuacao;
	private EmpresaModel empresaModel;
	private AreaAtuacaoModel areaAtuacaoModel;
	
	public Boolean salvar(EmpresaAreaAtuacaoModel element) {
		return DaoFactory.get(EmpresaAreaAtuacaoModel.class).addObject(element);
	}

	public int getCodEmpresaAreaAtuacao() {
		return codEmpresaAreaAtuacao;
	}

	public void setCodEmpresaAreaAtuacao(int codEmpresaAreaAtuacao) {
		this.codEmpresaAreaAtuacao = codEmpresaAreaAtuacao;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	public AreaAtuacaoModel getAreaAtuacaoModel() {
		return areaAtuacaoModel;
	}

	public void setAreaAtuacaoModel(AreaAtuacaoModel areaAtuacaoModel) {
		this.areaAtuacaoModel = areaAtuacaoModel;
	}

}
