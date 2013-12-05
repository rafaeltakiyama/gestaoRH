package br.com.lacerda.gestaorh;

import java.util.ArrayList;
import java.util.List;

import br.com.lacerda.gestaorh.adapter.AdapterList;
import br.com.lacerda.gestaorh.controller.CandidatoController;
import br.com.lacerda.gestaorh.model.CandidatoModel;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;


public class AtividadeListaCandidato extends ListActivity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;

		List<CandidatoModel> listaCandidato = new ArrayList<CandidatoModel>();

		listaCandidato = CandidatoController.getCandidatos(context);
		
		ArrayList<String> stringArray = new ArrayList<String>();
		
		for (CandidatoModel c : listaCandidato) {
			stringArray.add(c.getNome());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, stringArray));
		
	}
	
}
