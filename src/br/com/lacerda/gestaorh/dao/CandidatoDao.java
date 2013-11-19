package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoModel;

public class CandidatoDao extends Dao<CandidatoModel>{

	public CandidatoDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbcandidato";
	}

	@Override
	protected String whereClause() {
		return "codCandidato = ?";
	}

	@Override
	protected String[] whereValues(CandidatoModel element) {
		return new String[]{String.valueOf(element.getCodCandidato())};
	}

	@Override
	protected CandidatoModel fromCursor(Cursor cursor) {
		
		CandidatoModel c = new CandidatoModel();
		
		int idxCodCandidato = cursor.getColumnIndex("codCandidato");
		c.setCodCandidato(cursor.getInt(idxCodCandidato));
		
		int idxNome = cursor.getColumnIndex("nome");
		c.setNome(cursor.getString(idxNome));
		
		int idxCpf = cursor.getColumnIndex("cpf");
		c.setCpf(cursor.getString(idxCpf));
		
		int idxRg = cursor.getColumnIndex("rg");
		c.setRg(cursor.getString(idxRg));
		
		int idxData_nasc = cursor.getColumnIndex("data_nasc");
		c.setData_nasc(cursor.getString(idxData_nasc));
		
		int idxEmail = cursor.getColumnIndex("email");
		c.setEmail(cursor.getString(idxEmail));
		
		int idxEndereco = cursor.getColumnIndex("endereco");
		c.setEndereco(cursor.getString(idxEndereco));
		
		int idxEscolaridade = cursor.getColumnIndex("escolaridade");
		c.setEscolaridade(cursor.getString(idxEscolaridade));
		
		int idxInstituicao_ensino = cursor.getColumnIndex("instituicao_ensino");
		c.setInstituicao_ensino(cursor.getString(idxInstituicao_ensino));
		
		int idxData_conclusao = cursor.getColumnIndex("data_conclusao");
		c.setData_conclusao(cursor.getString(idxData_conclusao));
		
		return c;
	}

	@Override
	protected ContentValues fromElement(CandidatoModel element) {
		
		ContentValues values = new ContentValues();
		
		//values.put("codCandidato", element.getCodCandidato());
		values.put("nome", element.getNome());
		values.put("cpf", element.getCpf());
		values.put("rg", element.getRg());
		values.put("data_nasc", element.getData_nasc());
		values.put("email", element.getEmail());
		values.put("endereco", element.getEndereco());
		values.put("escolaridade", element.getEscolaridade());
		values.put("instituicao_ensino", element.getInstituicao_ensino());
		values.put("data_conclusao", element.getData_conclusao());
		
		return values;
	}

	@Override
	protected void configure(CandidatoModel element, Long codigo) {
	}

	@Override
	protected boolean igual(CandidatoModel elementoLocal,
			CandidatoModel elementoWs) {
		return false;
	}

}
