package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.CandidatoModel;

public class CandidatoController {

	public static List<CandidatoModel> getCandidatos(Context context){

		List<CandidatoModel> candidatoList = new ArrayList<CandidatoModel>();
		
		BancoHelper.instance().open(context);
		candidatoList = DaoFactory.get(CandidatoModel.class).selectAll();
		BancoHelper.instance().close();
		
		return candidatoList;
	}
	
	public static void salvaCandidato(Context context, CandidatoModel candidato){
		
		CandidatoModel candidatoModel = new CandidatoModel();
		
		BancoHelper.instance().open(context);
		candidatoModel.salvar(candidato);
		BancoHelper.instance().close();
		
	}
	
}
