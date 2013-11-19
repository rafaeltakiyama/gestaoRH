package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoAreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoModel;

public class CandidatoAreaAtuacaoDao extends Dao<CandidatoAreaAtuacaoModel>{

	public CandidatoAreaAtuacaoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tb_candidato_area_atuacao";
	}

	@Override
	protected String whereClause() {
		return "codCandidatoAreaAtuacao = ?";
	}

	@Override
	protected String[] whereValues(CandidatoAreaAtuacaoModel element) {
		return new String[]{String.valueOf(element.getCodCandidatoAreaAtuacao())};
	}

	@Override
	protected CandidatoAreaAtuacaoModel fromCursor(Cursor cursor) {
		
		CandidatoAreaAtuacaoModel candAreaAtuaModel = new CandidatoAreaAtuacaoModel();
		
		int idxCodCandidatoAreaAtuacao = cursor.getColumnIndex("codCandidatoAreaAtuacao");
		candAreaAtuaModel.setCodCandidatoAreaAtuacao(cursor.getInt(idxCodCandidatoAreaAtuacao));
		
		CandidatoDao candDao = (CandidatoDao) DaoFactory.get(CandidatoModel.class);
		int idxCandidatoModel = cursor.getColumnIndex("candidatoModel");
		candAreaAtuaModel.setCandidatoModel(candDao.select(cursor.getInt(idxCandidatoModel)));
		
		AreaAtuacaoDao areaDao = (AreaAtuacaoDao) DaoFactory.get(AreaAtuacaoModel.class);
		int idxAreaAtuacaoModel = cursor.getColumnIndex("areaAtuacaoModel");
		candAreaAtuaModel.setAreaAtuacaoModel(areaDao.select(cursor.getInt(idxAreaAtuacaoModel)));
		
		return candAreaAtuaModel;
	}

	@Override
	protected ContentValues fromElement(CandidatoAreaAtuacaoModel element) {
		
		ContentValues values = new ContentValues();
		
		//values.put("codCandidatoAreaAtuacao", element.getCodCandidatoAreaAtuacao());
		values.put("candidatoModel", element.getCandidatoModel().getCodCandidato());
		values.put("areaAtuacaoModel", element.getAreaAtuacaoModel().getCodArea());
		
		return values;
	}

	@Override
	protected void configure(CandidatoAreaAtuacaoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(CandidatoAreaAtuacaoModel elementoLocal,
			CandidatoAreaAtuacaoModel elementoWs) {
		return false;
	}

}
