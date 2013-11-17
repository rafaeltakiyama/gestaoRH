package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;

public class AreaAtuacaoDao extends Dao<AreaAtuacaoModel>{

	public AreaAtuacaoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbareaatuacao";
	}

	@Override
	protected String whereClause() {
		return "codArea = ?";
	}

	@Override
	protected String[] whereValues(AreaAtuacaoModel element) {
		return new String[]{String.valueOf(element.getCodArea())};
	}

	@Override
	protected AreaAtuacaoModel fromCursor(Cursor cursor) {
		
		AreaAtuacaoModel area = new AreaAtuacaoModel();
		
		int idxCodArea = cursor.getColumnIndex("codArea");
		area.setCodArea(cursor.getInt(idxCodArea));
		
		int idxNomeArea = cursor.getColumnIndex("nomeArea");
		area.setNomeArea(cursor.getString(idxNomeArea));
		
		return area;
	}

	@Override
	protected ContentValues fromElement(AreaAtuacaoModel element) {
		
		ContentValues values = new ContentValues();
		
		values.put("codArea", element.getCodArea());
		values.put("nomeArea", element.getNomeArea());
		
		return values;
	}

	@Override
	protected void configure(AreaAtuacaoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(AreaAtuacaoModel elementoLocal,
			AreaAtuacaoModel elementoWs) {
		return false;
	}

}
