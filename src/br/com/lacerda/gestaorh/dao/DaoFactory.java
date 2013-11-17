package br.com.lacerda.gestaorh.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;
import br.com.lacerda.gestaorh.model.EntrevistaModel;
import br.com.lacerda.gestaorh.model.EventoSeletivoModel;
import br.com.lacerda.gestaorh.model.SelecaoModel;
import br.com.lacerda.gestaorh.model.VagaModel;

import android.content.Context;

public class DaoFactory {

	private static Map<Class<?>, Dao<?>> daos;
	
	public static void init(Context context){
		daos = new HashMap<Class<?>, Dao<?>>();
		
		daos.put(AreaAtuacaoModel.class, new AreaAtuacaoDao(context));
		daos.put(CandidatoModel.class, new CandidatoDao(context));
		daos.put(EmpresaModel.class, new EmpresaDao(context));
		daos.put(EntrevistaModel.class, new EntrevistaDao(context));
		daos.put(EventoSeletivoModel.class, new EventoSeletivoDao(context));
		daos.put(SelecaoModel.class, new SelecaoDao(context));
		daos.put(VagaModel.class, new VagaDao(context));
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Dao<T> get(Class<T> type){
		return(Dao<T>) daos.get(type);
	}
}
