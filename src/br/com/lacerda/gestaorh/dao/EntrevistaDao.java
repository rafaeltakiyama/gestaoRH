package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.EntrevistaModel;
import br.com.lacerda.gestaorh.model.EventoSeletivoModel;

public class EntrevistaDao extends Dao<EntrevistaModel>{

	public EntrevistaDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbentrevista";
	}

	@Override
	protected String whereClause() {
		return "codEntrevista = ?";
	}

	@Override
	protected String[] whereValues(EntrevistaModel element) {
		return new String[]{String.valueOf(element.getCodEntrevista())};
	}

	@Override
	protected EntrevistaModel fromCursor(Cursor cursor) {
		
		EntrevistaModel entrevista = new EntrevistaModel();
		
		int idxCodEntrevista = cursor.getColumnIndex("codEntrevista");
		entrevista.setCodEntrevista(cursor.getInt(idxCodEntrevista));
		
		
		EventoSeletivoDao evDao = (EventoSeletivoDao) DaoFactory.get(EventoSeletivoModel.class);
		int idxEventoSeletivoModel = cursor.getColumnIndex("eventoSeletivoModel");
		entrevista.setEventoSeletivoModel(evDao.select(cursor.getInt(idxEventoSeletivoModel)));
		
		int idxPretensaoSalarial = cursor.getColumnIndex("pretensaoSalarial");
		entrevista.setPretensaoSalarial(cursor.getString(idxPretensaoSalarial));
		
		return entrevista;
	}

	@Override
	protected ContentValues fromElement(EntrevistaModel element) {
		
		ContentValues values = new ContentValues();
		
		//values.put("codEntrevista", element.getCodEntrevista());
		values.put("eventoSeletivoModel", element.getEventoSeletivoModel().getCodEventoSeletivo());
		values.put("pretensaoSalarial", element.getPretensaoSalarial());
		
		return values;
	}

	@Override
	protected void configure(EntrevistaModel element, Long codigo) {
	}

	@Override
	protected boolean igual(EntrevistaModel elementoLocal,
			EntrevistaModel elementoWs) {
		return false;
	}

}
