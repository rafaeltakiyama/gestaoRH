package br.com.lacerda.gestaorh;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.lacerda.gestaorh.adapter.CandidatoAdapter;
import br.com.lacerda.gestaorh.adapter.CheckBoxListAdapter;
import br.com.lacerda.gestaorh.controller.AreaAtuacaoController;
import br.com.lacerda.gestaorh.controller.CandidatoController;
import br.com.lacerda.gestaorh.controller.EmpresaController;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;

public class AtividadeCadastroEmpresa extends Activity {

	private Context context;
	private EditText nomeEmpresa;
	private EditText enderecoEmpresa;
	private EditText emailEmpresa;
	private Button btnSalvar;
	private Button btnCancelar;
	private Button btnAreaEmpresa;
	
	private String nome;
	private String endereco;
	private String email;
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
				showCustomDialog();
			}
		});
		
		
		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (getDadosEmpresa()) {
					dialogEmpresa(empresaModel);
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
	
	
	


	private Boolean getDadosEmpresa() {

		empresaModel = new EmpresaModel();
		
		boolean camposOk = validate(new EditText[] {nomeEmpresa, enderecoEmpresa, emailEmpresa});
		
		if (camposOk) {
			
			nome = nomeEmpresa.getText().toString();
			endereco = enderecoEmpresa.getText().toString();
			email = emailEmpresa.getText().toString();
			
			empresaModel.setNomeEmpresa(nome);
			empresaModel.setEnderecoEmpresa(endereco);
			empresaModel.setEmailEmpresa(email);
			
			return true;
			
		}else{
			
			campoObrigatorio();
			return false;
			
		}
		
	}

	protected void dialogEmpresa(EmpresaModel empresa) {

		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setTitle("Inserir empresa?");
		alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			//	CandidatoController.salvaCandidato(context, candidatoModel);

				EmpresaController.salvaEmpresa(context, empresaModel);
				
				
				//buscar o id da empresa que foi inserida
				//int codCandidato = CandidatoController.getCodCandidato(context);

				finish();
			}
		}).setNegativeButton("Não", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		ListView list = new ListView(context);
		
		//criar uma empresaAdapter
	//	CandidatoAdapter adapter = new CandidatoAdapter(context, candidatoModel);
		//list.setAdapter(adapter);

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


	private void showCustomDialog() {

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
