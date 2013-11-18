package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;

public class AreaAtuacaoController {

	public static List<AreaAtuacaoModel> getAreasAtuacao(Context context){

		List<AreaAtuacaoModel> areaAtuacaoList = new ArrayList<AreaAtuacaoModel>();
		
		BancoHelper.instance().open(context);
		areaAtuacaoList = DaoFactory.get(AreaAtuacaoModel.class).selectAll();
		BancoHelper.instance().close();
		
		return areaAtuacaoList;
	}
	
	public static void salvaAreaAtuacao(Context context, AreaAtuacaoModel areaAtuacao){
		
		AreaAtuacaoModel area = new AreaAtuacaoModel();
		
		BancoHelper.instance().open(context);
		area.salvar(areaAtuacao);
		BancoHelper.instance().close();
		
	}
	
}
