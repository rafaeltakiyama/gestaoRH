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

public class AtividadeCadastroCandidato extends Activity {

	private Context context;
	private EditText nomeCandidato;
	private EditText enderecoCandidato;
	private EditText rgCandidato;
	private EditText cpfCandidato;
	private EditText dataNascCandidato;
	private EditText emailCandidato;
	private EditText instituicaoEnsinoCandidato;
	private EditText dataConcluCandidato;
	private Button btnSalvar;
	private Button btnCancelar;
	private Button btnArea;
	private String nome;
	private String endereco;
	private String rg;
	private String cpf;
	private String dataNasc;
	private String email;
	private String escolaridade;
	private String instituicaoEnsino;
	private String dataConclusao;
	private CandidatoModel candidatoModel;
	private Spinner spinnerEscolaridade;
	private static final String SELECIONE = "Selecione...";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_atividade_cadastro_candidato);

		context = this;

		spinnerEscolaridade = (Spinner) findViewById(R.cadastroCandidato.escolaridadeSpinner);
		nomeCandidato = (EditText) findViewById(R.cadastroCandidato.nomeEditTxt);
		enderecoCandidato = (EditText) findViewById(R.cadastroCandidato.enderecoEditTxt);
		rgCandidato = (EditText) findViewById(R.cadastroCandidato.rgEditText);
		cpfCandidato = (EditText) findViewById(R.cadastroCandidato.cpfEditText);
		dataNascCandidato = (EditText) findViewById(R.cadastroCandidato.dataNascEditText);
		emailCandidato = (EditText) findViewById(R.cadastroCandidato.emailEditTxt);
		instituicaoEnsinoCandidato = (EditText) findViewById(R.cadastroCandidato.instEnsinoEditText);
		dataConcluCandidato = (EditText) findViewById(R.cadastroCandidato.dataConcluEditText);

		btnArea = (Button) findViewById(R.cadastroCandidato.areaBtn);
		btnSalvar = (Button) findViewById(R.cadastroCandidato.salvarBtn);
		btnCancelar = (Button) findViewById(R.cadastroCandidato.cancelarBtn);

		btnArea.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showCustomDialog();
			}
		});
		
		
		btnSalvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (getDadosCandidato()) {
					dialogConfirma(candidatoModel);
				}
			}
		});

		btnCancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		setSpinnerEscolaridade();

	}

	private void setSpinnerEscolaridade() {

		Resources res = context.getResources();
		String[] itens = res.getStringArray(R.array.escolaridade);

		ArrayAdapter<String> escolaridadeAdapter = new ArrayAdapter<String>(
				context, android.R.layout.simple_spinner_item, itens);
		escolaridadeAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerEscolaridade.setAdapter(escolaridadeAdapter);
		spinnerEscolaridadeItemSelecionado();
	}

	private void spinnerEscolaridadeItemSelecionado() {
		spinnerEscolaridade
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						escolaridade = parent.getItemAtPosition(position)
								.toString();
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});
	}


	private Boolean getDadosCandidato() {

		candidatoModel = new CandidatoModel();

		boolean camposOk = validate(new EditText[] { nomeCandidato,
				enderecoCandidato, rgCandidato, cpfCandidato,
				dataNascCandidato, emailCandidato, instituicaoEnsinoCandidato,
				dataConcluCandidato });

		if (camposOk && (!(escolaridade.equals(SELECIONE)))) {
			nome = nomeCandidato.getText().toString();
			endereco = enderecoCandidato.getText().toString();
			rg = rgCandidato.getText().toString();
			cpf = cpfCandidato.getText().toString();
			dataNasc = dataNascCandidato.getText().toString();
			email = emailCandidato.getText().toString();
			instituicaoEnsino = instituicaoEnsinoCandidato.getText().toString();
			dataConclusao = dataConcluCandidato.getText().toString();

			candidatoModel.setNome(nome);
			candidatoModel.setEndereco(endereco);
			candidatoModel.setRg(rg);
			candidatoModel.setCpf(cpf);
			candidatoModel.setData_nasc(dataNasc);
			candidatoModel.setEmail(email);
			candidatoModel.setEscolaridade(escolaridade);
			candidatoModel.setInstituicao_ensino(instituicaoEnsino);
			candidatoModel.setData_conclusao(dataConclusao);

			return true;

		} else {
			campoObrigatorio();
			return false;
		}

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
		builder.setTitle("Área de Atuação");
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
