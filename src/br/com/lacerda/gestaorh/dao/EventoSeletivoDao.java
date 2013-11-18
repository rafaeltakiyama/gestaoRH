package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.EventoSeletivoModel;

public class EventoSeletivoDao  extends Dao<EventoSeletivoModel>{

	public EventoSeletivoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbeventoseletivo";
	}

	@Override
	protected String whereClause() {
		return "codEventoSeletivo = ?";
	}

	@Override
	protected String[] whereValues(EventoSeletivoModel element) {
		return new String[]{String.valueOf(element.getCodEventoSeletivo())};
	}

	@Override
	protected EventoSeletivoModel fromCursor(Cursor cursor) {
		
		EventoSeletivoModel evento = new EventoSeletivoModel();
		
		int idxcodEventoSeletivo = cursor.getColumnIndex("codEventoSeletivo");
		evento.setCodEventoSeletivo(cursor.getInt(idxcodEventoSeletivo));
		
		int idxnomeEventoSeletivo = cursor.getColumnIndex("nomeEventoSeletivo");
		evento.setNomeEventoSeletivo(cursor.getString(idxnomeEventoSeletivo));
		
		int idxdescriEventoSeletivo = cursor.getColumnIndex("descriEventoSeletivo");
		evento.setDescriEventoSeletivo(cursor.getString(idxdescriEventoSeletivo));
		
		int idxnotaEventoSeletivo = cursor.getColumnIndex("notaEventoSeletivo");
		evento.setNotaEventoSeletivo(cursor.getString(idxnotaEventoSeletivo));
		
		return evento;
	}

	@Override
	protected ContentValues fromElement(EventoSeletivoModel element) {
		
		ContentValues values = new ContentValues();
		
		//values.put("codEventoSeletivo", element.getCodEventoSeletivo());
		values.put("nomeEventoSeletivo", element.getNomeEventoSeletivo());
		values.put("descriEventoSeletivo", element.getDescriEventoSeletivo());
		values.put("notaEventoSeletivo", element.getNotaEventoSeletivo());
		
		return values;
	}

	@Override
	protected void configure(EventoSeletivoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(EventoSeletivoModel elementoLocal,
			EventoSeletivoModel elementoWs) {
		return false;
	}

}
