package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.EmpresaAreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;

public class EmpresaAreaAtuacaoDao extends Dao<EmpresaAreaAtuacaoModel>{

	public EmpresaAreaAtuacaoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tb_empresa_area_atuacao";
	}

	@Override
	protected String whereClause() {
		return "codEmpresaAreaAtuacao = ?";
	}

	@Override
	protected String[] whereValues(EmpresaAreaAtuacaoModel element) {
		return new String[]{String.valueOf(element.getCodEmpresaAreaAtuacao())};
	}

	@Override
	protected EmpresaAreaAtuacaoModel fromCursor(Cursor cursor) {
		
		EmpresaAreaAtuacaoModel empAreaAtuaModel = new EmpresaAreaAtuacaoModel();
		
		int idxCodEmpresaAreaAtuacao = cursor.getColumnIndex("codEmpresaAreaAtuacao");
		empAreaAtuaModel.setCodEmpresaAreaAtuacao(cursor.getInt(idxCodEmpresaAreaAtuacao));
		
		EmpresaDao empDao = (EmpresaDao) DaoFactory.get(EmpresaModel.class);
		int idxEmpresaModel = cursor.getColumnIndex("empresaModel");
		empAreaAtuaModel.setEmpresaModel(empDao.select(cursor.getInt(idxEmpresaModel)));
		
		AreaAtuacaoDao areaDao = (AreaAtuacaoDao) DaoFactory.get(AreaAtuacaoModel.class);
		int idxAreaAtuacaoModel = cursor.getColumnIndex("areaAtuacaoModel");
		empAreaAtuaModel.setAreaAtuacaoModel(areaDao.select(cursor.getInt(idxAreaAtuacaoModel)));
		
		return empAreaAtuaModel;
	}

	@Override
	protected ContentValues fromElement(EmpresaAreaAtuacaoModel element) {
		
		ContentValues values = new ContentValues();
		
		//values.put("codEmpresaAreaAtuacao", element.getCodEmpresaAreaAtuacao());
		values.put("empresaModel", element.getEmpresaModel().getCodEmpresa());
		values.put("areaAtuacaoModel", element.getAreaAtuacaoModel().getCodArea());
		
		return values;
	}

	@Override
	protected void configure(EmpresaAreaAtuacaoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(EmpresaAreaAtuacaoModel elementoLocal,
			EmpresaAreaAtuacaoModel elementoWs) {
		return false;
	}

}
