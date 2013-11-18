package br.com.lacerda.gestaorh.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import br.com.lacerda.gestaorh.banco.BancoHelper;
import br.com.lacerda.gestaorh.dao.DaoFactory;
import br.com.lacerda.gestaorh.model.EventoSeletivoModel;

public class EventoSeletivoController {

	public static List<EventoSeletivoModel> getEventosSeletivos(Context context){

		List<EventoSeletivoModel> eventoList = new ArrayList<EventoSeletivoModel>();
		
		BancoHelper.instance().open(context);
		eventoList = DaoFactory.get(EventoSeletivoModel.class).selectAll();
		BancoHelper.instance().close();
		
		return eventoList;
	}
	
	public static void salvaEvento(Context context, EventoSeletivoModel evento){
		
		EventoSeletivoModel eventoModel = new EventoSeletivoModel();
		
		BancoHelper.instance().open(context);
		eventoModel.salvar(evento);
		BancoHelper.instance().close();
		
	}
	
}
