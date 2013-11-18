package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.SelecaoModel;

public class SelecaoController {

	public static List<SelecaoModel> getSelecoes(Context context){

		List<SelecaoModel> selecaoList = new ArrayList<SelecaoModel>();
		
		BancoHelper.instance().open(context);
		selecaoList = DaoFactory.get(SelecaoModel.class).selectAll();
		BancoHelper.instance().close();
		
		return selecaoList;
	}
	
	public static void salvaSelecao(Context context, SelecaoModel selecao){
		
		SelecaoModel selecaoModel = new SelecaoModel();
		
		BancoHelper.instance().open(context);
		selecaoModel.salvar(selecao);
		BancoHelper.instance().close();
		
	}
	
}
