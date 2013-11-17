package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;
import br.com.lacerda.gestaorh.model.VagaModel;

public class VagaDao extends Dao<VagaModel>{

	public VagaDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbvaga";
	}

	@Override
	protected String whereClause() {
		return "codVaga = ?";
	}

	@Override
	protected String[] whereValues(VagaModel element) {
		return new String[]{String.valueOf(element.getCodVaga())};
	}

	@Override
	protected VagaModel fromCursor(Cursor cursor) {

		VagaModel vaga = new VagaModel();
		
		int idxCodVaga = cursor.getColumnIndex("codVaga");
		vaga.setCodVaga(cursor.getInt(idxCodVaga));
		
		EmpresaDao empDao = (EmpresaDao) DaoFactory.get(EmpresaModel.class);
		int idxEmpresaModel = cursor.getColumnIndex("empresaModel");
		vaga.setEmpresaModel(empDao.select(cursor.getInt(idxEmpresaModel)));
		
		AreaAtuacaoDao areaDao = (AreaAtuacaoDao) DaoFactory.get(AreaAtuacaoModel.class);
		int idxAreaAtuacao = cursor.getColumnIndex("areaAtuacao");
		vaga.setAreaAtuacao(areaDao.select(cursor.getInt(idxAreaAtuacao)));
		
		int idxNomeVaga = cursor.getColumnIndex("nomeVaga");
		vaga.setNomeVaga(cursor.getString(idxNomeVaga));
		
		int idxRequisitosVaga = cursor.getColumnIndex("requisitosVaga");
		vaga.setRequisitosVaga(cursor.getString(idxRequisitosVaga));
		
		int idxLocalVaga = cursor.getColumnIndex("localVaga");
		vaga.setLocalVaga(cursor.getString(idxLocalVaga));
		
		int idxDescriVaga = cursor.getColumnIndex("descriVaga");
		vaga.setDescriVaga(cursor.getString(idxDescriVaga));
		
		int idxDataIniVaga = cursor.getColumnIndex("dataIniVaga");
		vaga.setDataIniVaga(cursor.getString(idxDataIniVaga));
		
		return vaga;
	}

	@Override
	protected ContentValues fromElement(VagaModel element) {

		ContentValues values = new ContentValues();
		
		values.put("codVaga", element.getCodVaga());
		values.put("empresaModel", element.getEmpresaModel().getCodEmpresa());
		values.put("areaAtuacao", element.getAreaAtuacao().getCodArea());
		values.put("nomeVaga", element.getNomeVaga());
		values.put("requisitosVaga", element.getRequisitosVaga());
		values.put("localVaga", element.getLocalVaga());
		values.put("descriVaga", element.getDescriVaga());
		values.put("dataIniVaga", element.getDataIniVaga());
		
		return values;
	}

	@Override
	protected void configure(VagaModel element, Long codigo) {
	}

	@Override
	protected boolean igual(VagaModel elementoLocal, VagaModel elementoWs) {
		return false;
	}

}
