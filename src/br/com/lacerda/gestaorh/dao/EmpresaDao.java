package br.com.lacerda.gestaorh.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import br.com.lacerda.gestaorh.model.EmpresaModel;

public class EmpresaDao extends Dao<EmpresaModel>{

	public EmpresaDao(Context context) {
		super(context);
	}

	@Override
	protected String nomeTabela() {
		return "tbempresa";
	}

	@Override
	protected String whereClause() {
		return "codEmpresa = ?";
	}

	@Override
	protected String[] whereValues(EmpresaModel element) {
		return new String[]{String.valueOf(element.getCodEmpresa())};
	}

	@Override
	protected EmpresaModel fromCursor(Cursor cursor) {
		
		EmpresaModel empresa = new EmpresaModel();
		
		int idxCodEmpresa = cursor.getColumnIndex("codEmpresa");
		empresa.setCodEmpresa(cursor.getInt(idxCodEmpresa));
		
		int idxNomeEmpresa = cursor.getColumnIndex("nomeEmpresa");
		empresa.setNomeEmpresa(cursor.getString(idxNomeEmpresa));
		
		int idxEnderecoEmpresa = cursor.getColumnIndex("enderecoEmpresa");
		empresa.setEnderecoEmpresa(cursor.getString(idxEnderecoEmpresa));
		
		int idxEmailEmpresa = cursor.getColumnIndex("emailEmpresa");
		empresa.setEmailEmpresa(cursor.getString(idxEmailEmpresa));
		
		return empresa;
	}

	@Override
	protected ContentValues fromElement(EmpresaModel element) {
		
		ContentValues values = new ContentValues();
		
		//values.put("codEmpresa", element.getCodEmpresa());
		values.put("nomeEmpresa", element.getNomeEmpresa());
		values.put("enderecoEmpresa", element.getEnderecoEmpresa());
		values.put("emailEmpresa", element.getEmailEmpresa());
		
		return values;
	}

	@Override
	protected void configure(EmpresaModel element, Long codigo) {
	}

	@Override
	protected boolean igual(EmpresaModel elementoLocal, EmpresaModel elementoWs) {
		return false;
	}

}
