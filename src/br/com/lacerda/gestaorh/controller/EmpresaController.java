package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.EmpresaModel;

public class EmpresaController {

	public static List<EmpresaModel> getEmpresas(Context context){

		List<EmpresaModel> empresaList = new ArrayList<EmpresaModel>();
		
		BancoHelper.instance().open(context);
		empresaList = DaoFactory.get(EmpresaModel.class).selectAll();
		BancoHelper.instance().close();
		
		return empresaList;
	}
	
	public static void salvaEmpresa(Context context, EmpresaModel empresa){
		
		EmpresaModel empresaModel = new EmpresaModel();
		
		BancoHelper.instance().open(context);
		empresaModel.salvar(empresa);
		BancoHelper.instance().close();
		
	}
	
}
