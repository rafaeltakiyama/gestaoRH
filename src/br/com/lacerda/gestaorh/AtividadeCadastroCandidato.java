package br.com.lacerda.gestaorh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class AtividadeCadastroCandidato extends Activity {

	private Context context;
	private EditText nomeCandidato;
	private EditText enderecoCandidato;
	private EditText rgCandidato;
	private EditText cpfCandidato;
	private EditText dataNascCandidato;
	private EditText emailCandidato;
	private EditText escolaridadeCandidato;
	private EditText dataConcluCandidato;

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
		dataConcluCandidato = (EditText) findViewById(R.cadastroCandidato.dataConcluEditText);

		getDadosCandidato();
		
	}

	private void getDadosCandidato() {
		
		boolean camposOk = validate(new EditText[] { nomeCandidato, enderecoCandidato,
				rgCandidato, cpfCandidato, dataNascCandidato, emailCandidato, escolaridadeCandidato, dataConcluCandidato });
		
		if (camposOk) {
			nomeCandidato.getText().toString();
			enderecoCandidato.getText().toString();
			rgCandidato.getText().toString();
			cpfCandidato.getText().toString();
			dataNascCandidato.getText().toString();
			emailCandidato.getText().toString();
			escolaridadeCandidato.getText().toString();
			dataConcluCandidato.getText().toString();
			
		}else{
			campoObrigatorio();
		}
		
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
