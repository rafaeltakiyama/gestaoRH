package br.com.lacerda.gestaorh.model;

import java.io.Serializable;
import java.util.List;

import br.com.lacerda.gestaorh.dao.DaoFactory;

public class EventoSeletivoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codEventoSeletivo;
	private String nomeEventoSeletivo;
	private String descriEventoSeletivo;
	private String notaEventoSeletivo;

    public Boolean salvar(List<EventoSeletivoModel> element) {
        return DaoFactory.get(EventoSeletivoModel.class).addListObj(element);
    }
	
	public int getCodEventoSeletivo() {
		return codEventoSeletivo;
	}

	public void setCodEventoSeletivo(int codEventoSeletivo) {
		this.codEventoSeletivo = codEventoSeletivo;
	}

	public String getNomeEventoSeletivo() {
		return nomeEventoSeletivo;
	}

	public void setNomeEventoSeletivo(String nomeEventoSeletivo) {
		this.nomeEventoSeletivo = nomeEventoSeletivo;
	}

	public String getDescriEventoSeletivo() {
		return descriEventoSeletivo;
	}

	public void setDescriEventoSeletivo(String descriEventoSeletivo) {
		this.descriEventoSeletivo = descriEventoSeletivo;
	}

	public String getNotaEventoSeletivo() {
		return notaEventoSeletivo;
	}

	public void setNotaEventoSeletivo(String notaEventoSeletivo) {
		this.notaEventoSeletivo = notaEventoSeletivo;
	};

}
