package br.com.lacerda.gestaorh;

import java.util.ArrayList;
import java.util.List;

import br.com.lacerda.gestaorh.adapter.AdapterList;
import br.com.lacerda.gestaorh.controller.CandidatoController;
import br.com.lacerda.gestaorh.controller.EmpresaController;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;


public class AtividadeListaEmpresa extends ListActivity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = this;

		List<EmpresaModel> listaEmpresa = new ArrayList<EmpresaModel>();

		listaEmpresa = EmpresaController.getEmpresas(context);
		
		ArrayList<String> stringArray = new ArrayList<String>();
		
		for (EmpresaModel e : listaEmpresa) {
			stringArray.add(e.getNomeEmpresa());
		}
		
		setListAdapter(new AdapterList(context, R.layout.layout_item_lista, stringArray));
		
	}
	
}
