package br.com.lacerda.gestaorh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import br.com.lacerda.gestaorh.dao.DaoFactory;

public class AtividadePrincipal extends Activity {

	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_atividade_principal);
		
		context = this;
		
		DaoFactory.init(context);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.atividade_principal, menu);
		return true;
	}

}
