package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.VagaModel;

public class VagaController {

	public static List<VagaModel> getVagas(Context context){

		List<VagaModel> vagaList = new ArrayList<VagaModel>();
		
		BancoHelper.instance().open(context);
		vagaList = DaoFactory.get(VagaModel.class).selectAll();
		BancoHelper.instance().close();
		
		return vagaList;
	}
	
	public static void salvaVaga(Context context, VagaModel vaga){
		
		VagaModel vagaModel = new VagaModel();
		
		BancoHelper.instance().open(context);
		vagaModel.salvar(vaga);
		BancoHelper.instance().close();
		
	}
	
}
