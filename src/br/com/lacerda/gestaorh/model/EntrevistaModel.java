package br.com.lacerda.gestaorh.model;

import java.io.Serializable;
import java.util.List;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class EntrevistaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codEntrevista;
	private String pretensaoSalarial;
	private EventoSeletivoModel eventoSeletivoModel;

	public Boolean salvar(List<EntrevistaModel> element) {
		return DaoFactory.get(EntrevistaModel.class).addListObj(element);
	}
	
	public int getCodEntrevista() {
		return codEntrevista;
	}

	public void setCodEntrevista(int codEntrevista) {
		this.codEntrevista = codEntrevista;
	}

	public EventoSeletivoModel getEventoSeletivoModel() {
		return eventoSeletivoModel;
	}

	public void setEventoSeletivoModel(EventoSeletivoModel eventoSeletivoModel) {
		this.eventoSeletivoModel = eventoSeletivoModel;
	}

	public String getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public void setPretensaoSalarial(String pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

}
