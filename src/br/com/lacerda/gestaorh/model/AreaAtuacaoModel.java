package br.com.lacerda.gestaorh.model;

import java.io.Serializable;
import java.util.List;

import br.com.lacerda.gestaorh.dao.DaoFactory;


public class AreaAtuacaoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codArea;
	private String nomeArea;
	
    public Boolean salvar(List<AreaAtuacaoModel> element) {
        return DaoFactory.get(AreaAtuacaoModel.class).addListObj(element);
    }

	public int getCodArea() {
		return codArea;
	}

	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}

	public String getNomeArea() {
		return nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

}
