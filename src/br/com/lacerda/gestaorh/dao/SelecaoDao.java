package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;
import br.com.lacerda.gestaorh.model.EventoSeletivoModel;
import br.com.lacerda.gestaorh.model.SelecaoModel;
import br.com.lacerda.gestaorh.model.VagaModel;

public class SelecaoDao extends Dao<SelecaoModel>{

	public SelecaoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tdselecao";
	}

	@Override
	protected String whereClause() {
		return "codSelecao = ?";
	}

	@Override
	protected String[] whereValues(SelecaoModel element) {
		return new String[]{String.valueOf(element.getCodSelecao())};
	}

	@Override
	protected SelecaoModel fromCursor(Cursor cursor) {
		
		SelecaoModel selecao = new SelecaoModel();
		
		int idxCodSelecao = cursor.getColumnIndex("codSelecao");
		selecao.setCodSelecao(cursor.getInt(idxCodSelecao));
		
		CandidatoDao canDao = (CandidatoDao) DaoFactory.get(CandidatoModel.class);
		int idxCandidatoModel = cursor.getColumnIndex("candidatoModel");
		selecao.setCandidatoModel(canDao.select(cursor.getInt(idxCandidatoModel)));
		
		AreaAtuacaoDao areaDao = (AreaAtuacaoDao) DaoFactory.get(AreaAtuacaoModel.class);
		int idxAreaAtuacaoModel = cursor.getColumnIndex("areaAtuacaoModel");
		selecao.setAreaAtuacaoModel(areaDao.select(cursor.getInt(idxAreaAtuacaoModel)));
		
		VagaDao vagaDao = (VagaDao) DaoFactory.get(VagaModel.class);
		int idxVagaModel = cursor.getColumnIndex("vagaModel");
		selecao.setVagaModel(vagaDao.select(cursor.getInt(idxVagaModel)));
		
		EmpresaDao empDao = (EmpresaDao) DaoFactory.get(EmpresaModel.class);
		int idxEmpresaModel = cursor.getColumnIndex("empresaModel");
		selecao.setEmpresaModel(empDao.select(cursor.getInt(idxEmpresaModel)));
		
		EventoSeletivoDao evDao = (EventoSeletivoDao) DaoFactory.get(EventoSeletivoModel.class);
		int idxEventoSeletivoModel = cursor.getColumnIndex("eventoSeletivoModel");
		selecao.setEventoSeletivoModel(evDao.select(cursor.getInt(idxEventoSeletivoModel)));
		
		return selecao;
	}

	@Override
	protected ContentValues fromElement(SelecaoModel element) {
		
		ContentValues values = new ContentValues();
		
		values.put("codSelecao", element.getCodSelecao());
		values.put("candidatoModel", element.getCandidatoModel().getCodCandidato());
		values.put("areaAtuacaoModel", element.getAreaAtuacaoModel().getCodArea());
		values.put("vagaModel", element.getVagaModel().getCodVaga());
		values.put("empresaModel", element.getEmpresaModel().getCodEmpresa());
		values.put("eventoSeletivoModel", element.getEventoSeletivoModel().getCodEventoSeletivo());
		
		return values;
	}

	@Override
	protected void configure(SelecaoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(SelecaoModel elementoLocal, SelecaoModel elementoWs) {
		return false;
	}

}
