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
		
//		AreaAtuacaoModel a = new AreaAtuacaoModel();
//		a.setCodArea(1);
//		
//		EmpresaModel e = new EmpresaModel();
//		e.setCodEmpresa(1);
//		
//		CandidatoModel cand = new CandidatoModel();
//		cand.setCodCandidato(1);
//		
//		EventoSeletivoModel ev = new EventoSeletivoModel();
//		ev.setCodEventoSeletivo(1);
//		
//		VagaModel v = new VagaModel();
//		v.setCodVaga(1);
//		
//		
//		SelecaoModel s = new SelecaoModel();
//		s.setAreaAtuacaoModel(a);
//		s.setCandidatoModel(cand);
//		s.setEmpresaModel(e);
//		s.setEventoSeletivoModel(ev);
//		s.setVagaModel(v);
//		
//		SelecaoController.salvaSelecao(context, s);
//		
//		List<SelecaoModel> ls = new ArrayList<SelecaoModel>();
//		
//		ls = SelecaoController.getSelecoes(context);
//		
//		ls.size();
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.atividade_principal, menu);
		return true;
	}

}
