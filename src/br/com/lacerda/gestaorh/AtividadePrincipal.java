package br.com.lacerda.gestaorh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.lacerda.gestaorh.dao.DaoFactory;

public class AtividadePrincipal extends Activity {

	Context context;
	
	private String[] menu = {
			
			"Cadastro Candidato"
			
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_principal);
		
		context = this;
		
		DaoFactory.init(context);
		
		ListView menuList = (ListView) findViewById(R.menu.menulist);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, menu);
		menuList.setAdapter(adapter);
		
		menuList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
				
				switch (position) {
				case 0:
					startActivity(new Intent(context, AtividadeCadastroCandidato.class));
					break;

				default:
					break;
				}
				
			}
		
		
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.atividade_principal, menu);
		return true;
	}

}
