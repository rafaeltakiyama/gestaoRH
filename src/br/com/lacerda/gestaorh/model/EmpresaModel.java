package br.com.lacerda.gestaorh.model;

import java.io.Serializable;
import java.util.List;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class EmpresaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codEmpresa;
	private AreaAtuacaoModel areaAtuacao;
	private String nomeEmpresa;
	private String enderecoEmpresa;
	private String emailEmpresa;

    public Boolean salvar(List<EmpresaModel> element) {
        return DaoFactory.get(EmpresaModel.class).addListObj(element);
    }
	
	public int getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public AreaAtuacaoModel getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacaoModel areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEnderecoEmpresa() {
		return enderecoEmpresa;
	}

	public void setEnderecoEmpresa(String enderecoEmpresa) {
		this.enderecoEmpresa = enderecoEmpresa;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

}
