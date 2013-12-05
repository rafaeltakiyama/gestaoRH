package br.com.lacerda.gestaorh;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.com.lacerda.gestaorh.adapter.CheckBoxListAdapter;
import br.com.lacerda.gestaorh.adapter.EmpresaAdapter;
import br.com.lacerda.gestaorh.controller.AreaAtuacaoController;
import br.com.lacerda.gestaorh.controller.EmpresaController;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;

public class AtividadeCadastroEmpresa extends Activity {

	private Context context;
	private EditText nomeEmpresa;
	private EditText enderecoEmpresa;
	private EditText emailEmpresa;
	private Button btnSalvar;
	private Button btnCancelar;
	private Button btnAreaEmpresa;
	
	private EmpresaModel empresaModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_atividade_cadastro_empresa);

		context = this;

		nomeEmpresa = (EditText) findViewById(R.cadastroEmpresa.nomeEmpresaEditTxt);
		enderecoEmpresa = (EditText) findViewById(R.cadastroEmpresa.enderecoEmpresaEditTxt);
		emailEmpresa = (EditText) findViewById(R.cadastroEmpresa.emailEditTxt);

		btnAreaEmpresa = (Button) findViewById(R.cadastroEmpresa.areaEmpresaBtn);
		btnSalvar = (Button) findViewById(R.cadastroEmpresa.salvarBtn);
		btnCancelar = (Button) findViewById(R.cadastroEmpresa.cancelarBtn);

		btnAreaEmpresa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialogAreaAtuacao();
			}
		});
		
		
		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(getDadosEmpresa()){
					dialogConfirmaDadosEmpresa(empresaModel);
				}
			}
		});

		btnCancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		
	}

	private boolean getDadosEmpresa() {
		
		empresaModel = new EmpresaModel();
		
		boolean camposOk = validate(new EditText[]{nomeEmpresa, enderecoEmpresa, emailEmpresa});
		
		if (camposOk) {
			
			empresaModel.setNomeEmpresa(nomeEmpresa.getText().toString());
			empresaModel.setEnderecoEmpresa(enderecoEmpresa.getText().toString());
			empresaModel.setEmailEmpresa(emailEmpresa.getText().toString());
			
			return true;
		}else{
			
			campoObrigatorio();
			return false;
			
		}
		
		
	}

	protected void dialogConfirmaDadosEmpresa(EmpresaModel empresa) {

		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setTitle("Inserir a empresa " + empresa.getNomeEmpresa() +" ?");
		alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				EmpresaController.salvaEmpresa(context,empresaModel );

				//retorno do idEmpresa
				//int codCandidato = CandidatoController.getCodCandidato(context);

				finish();
			}
		}).setNegativeButton("Não", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		ListView list = new ListView(context);
		EmpresaAdapter adapter = new EmpresaAdapter(context, empresaModel);
		list.setAdapter(adapter);

		alert.setView(list);
		Dialog dialog = alert.create();
		dialog.show();

	}

	private boolean validate(EditText[] fields) {
		for (int i = 0; i < fields.length; i++) {
			EditText currentField = fields[i];
			String stringAux = currentField.getText().toString()
					.replace(" ", "");

			if ((stringAux.length() <= 0)) {
				return false;
			}
		}
		return true;
	}

	private void campoObrigatorio() {
		Toast.makeText(this, "Todos os campos são obrigatórios!",
				Toast.LENGTH_SHORT).show();
	}


	private void dialogAreaAtuacao() {

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("Title");
		builder.setPositiveButton("OK", null);

		List<AreaAtuacaoModel> areaAtuacaoListAdapter = new ArrayList<AreaAtuacaoModel>();
		areaAtuacaoListAdapter = AreaAtuacaoController.getAreasAtuacao(context);

		ListView list = new ListView(context);
		CheckBoxListAdapter adapter = new CheckBoxListAdapter(context,
				areaAtuacaoListAdapter);
		list.setAdapter(adapter);

		list.setBackgroundColor(Color.WHITE);
		builder.setView(list);
		Dialog dialog = builder.create();

		dialog.show();
	}
}
