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
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;
import br.com.lacerda.gestaorh.model.CandidatoModel;

public class AtividadeCadastroEmpresa extends Activity {

	private Context context;
	private EditText enderecoEmpresa;
	private EditText emailEmpresa;
	private Button btnSalvar;
	private Button btnCancelar;
	private Button btnAreaEmpresa;
	
	private String nome;
	private String endereco;
	private String email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_atividade_cadastro_empresa);

		context = this;

		enderecoEmpresa = (EditText) findViewById(R.cadastroCandidato.enderecoEditTxt);
		emailEmpresa = (EditText) findViewById(R.cadastroCandidato.emailEditTxt);

		btnAreaEmpresa = (Button) findViewById(R.cadastroCandidato.areaBtn);
		btnSalvar = (Button) findViewById(R.cadastroCandidato.salvarBtn);
		btnCancelar = (Button) findViewById(R.cadastroCandidato.cancelarBtn);

		btnAreaEmpresa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showCustomDialog();
			}
		});
		
		
		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				if (getDadosCandidato()) {
//					dialogConfirma(candidatoModel);
//				}
			}
		});

		btnCancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}


	protected void dialogConfirma(CandidatoModel candidato) {

		AlertDialog.Builder alert = new AlertDialog.Builder(context);
		alert.setTitle("Inserir o candidato?");
		alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				CandidatoController.salvaCandidato(context, candidatoModel);

				int codCandidato = CandidatoController.getCodCandidato(context);

				finish();
			}
		}).setNegativeButton("Não", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		ListView list = new ListView(context);
		CandidatoAdapter adapter = new CandidatoAdapter(context, candidatoModel);
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
