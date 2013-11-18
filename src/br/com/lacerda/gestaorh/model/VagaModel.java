package br.com.lacerda.gestaorh.model;

import java.io.Serializable;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class VagaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codVaga;
	private EmpresaModel empresaModel;
	private AreaAtuacaoModel areaAtuacao;
	private String nomeVaga;
	private String requisitosVaga;
	private String localVaga;
	private String descriVaga;
	private String dataIniVaga;
	
    public Boolean salvar(VagaModel element) {
        return DaoFactory.get(VagaModel.class).addObject(element);
    }

	public int getCodVaga() {
		return codVaga;
	}

	public void setCodVaga(int codVaga) {
		this.codVaga = codVaga;
	}

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}

	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}

	public AreaAtuacaoModel getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacaoModel areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}

	public String getRequisitosVaga() {
		return requisitosVaga;
	}

	public void setRequisitosVaga(String requisitosVaga) {
		this.requisitosVaga = requisitosVaga;
	}

	public String getLocalVaga() {
		return localVaga;
	}

	public void setLocalVaga(String localVaga) {
		this.localVaga = localVaga;
	}

	public String getDescriVaga() {
		return descriVaga;
	}

	public void setDescriVaga(String descriVaga) {
		this.descriVaga = descriVaga;
	}

	public String getDataIniVaga() {
		return dataIniVaga;
	}

	public void setDataIniVaga(String dataIniVaga) {
		this.dataIniVaga = dataIniVaga;
	}

}
