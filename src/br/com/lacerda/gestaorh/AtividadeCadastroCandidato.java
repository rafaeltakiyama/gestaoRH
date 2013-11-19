package br.com.lacerda.gestaorh;

import br.com.lacerda.gestaorh.adapter.CandidatoAdapter;
import br.com.lacerda.gestaorh.controller.CandidatoController;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AtividadeCadastroCandidato extends Activity{

	private Context context;
	private EditText nomeCandidato;
	private EditText enderecoCandidato;
	private EditText rgCandidato;
	private EditText cpfCandidato;
	private EditText dataNascCandidato;
	private EditText emailCandidato;
	private EditText escolaridadeCandidato;
	private EditText instituicaoEnsinoCandidato;
	private EditText dataConcluCandidato;
	private Button btnSalvar;
	private Button btnCancelar;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_atividade_cadastro_candidato);

		context = this;

		nomeCandidato = (EditText) findViewById(R.cadastroCandidato.nomeEditTxt);
		enderecoCandidato = (EditText) findViewById(R.cadastroCandidato.enderecoEditTxt);
		rgCandidato = (EditText) findViewById(R.cadastroCandidato.rgEditText);
		cpfCandidato = (EditText) findViewById(R.cadastroCandidato.cpfEditText);
		dataNascCandidato = (EditText) findViewById(R.cadastroCandidato.dataNascEditText);
		emailCandidato = (EditText) findViewById(R.cadastroCandidato.emailEditTxt);
		escolaridadeCandidato = (EditText) findViewById(R.cadastroCandidato.escolaridadeEditText);
		instituicaoEnsinoCandidato = (EditText) findViewById(R.cadastroCandidato.instEnsinoEditText);
		dataConcluCandidato = (EditText) findViewById(R.cadastroCandidato.dataConcluEditText);
		
		btnSalvar = (Button) findViewById(R.cadastroCandidato.salvarBtn);
		btnCancelar = (Button) findViewById(R.cadastroCandidato.cancelarBtn);
		
		btnSalvar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(getDadosCandidato()){
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
		
	}

	private Boolean getDadosCandidato() {
		
		candidatoModel = new CandidatoModel();
		
		boolean camposOk = validate(new EditText[] { nomeCandidato, 
				enderecoCandidato,
				rgCandidato,
				cpfCandidato,
				dataNascCandidato,
				emailCandidato,
				escolaridadeCandidato,
				instituicaoEnsinoCandidato,
				dataConcluCandidato });
		
		if (camposOk) {
			nome = nomeCandidato.getText().toString();
			endereco = enderecoCandidato.getText().toString();
			rg = rgCandidato.getText().toString();
			cpf = cpfCandidato.getText().toString();
			dataNasc = dataNascCandidato.getText().toString();
			email = emailCandidato.getText().toString();
			escolaridade = escolaridadeCandidato.getText().toString();
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
			
		}else{
			campoObrigatorio();
			return false;
		}
		
	}
	
	protected void dialogConfirma(CandidatoModel candidato) {

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Inserir o candidato?");
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which)
            {   
            	CandidatoController.salvaCandidato(context, candidatoModel);
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
			String stringAux = currentField.getText().toString().replace(" ", "");
			
			if ((stringAux.length() <= 0 )) {
				return false;
			}
		}
		return true;
	}
	
	private void campoObrigatorio() {
		Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
	}

}
