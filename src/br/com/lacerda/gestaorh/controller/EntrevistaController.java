package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.EntrevistaModel;

public class EntrevistaController {

	public static List<EntrevistaModel> getEntrevistas(Context context){

		List<EntrevistaModel> entrevistaList = new ArrayList<EntrevistaModel>();
		
		BancoHelper.instance().open(context);
		entrevistaList = DaoFactory.get(EntrevistaModel.class).selectAll();
		BancoHelper.instance().close();
		
		return entrevistaList;
	}
	
	public static void salvaEvento(Context context, EntrevistaModel entrevista){
		
		EntrevistaModel entrevistaModel = new EntrevistaModel();
		
		BancoHelper.instance().open(context);
		entrevistaModel.salvar(entrevista);
		BancoHelper.instance().close();
		
	}
	
}
