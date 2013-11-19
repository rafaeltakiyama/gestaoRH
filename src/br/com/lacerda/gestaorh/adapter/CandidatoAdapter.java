package br.com.lacerda.gestaorh.adapter;
import br.com.lacerda.gestaorh.R;
import br.com.lacerda.gestaorh.R.itemCand;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CandidatoAdapter extends BaseAdapter{
	
	private Context context;
	private CandidatoModel candidato;
	
	public CandidatoAdapter(Context context, CandidatoModel candidato) {
		super();
		this.context = context;
		this.candidato = candidato;
	}

	@Override
	public int getCount() {
		return 1;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater)
	            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View view = inflater.inflate(R.layout.layout_dialog_confirma_dados_candidato, null);
	        
	        TextView nome = (TextView) view.findViewById(R.itemCand.nome);
	        nome.setText(candidato.getNome());
	        
	        TextView endereco = (TextView) view.findViewById(R.itemCand.endereco);
	        endereco.setText(candidato.getEndereco());
	        
	        TextView rg = (TextView) view.findViewById(R.itemCand.rg);
	        rg.setText(candidato.getRg());
	        
	        TextView cpf = (TextView) view.findViewById(R.itemCand.cpf);
	        cpf.setText(candidato.getCpf());
	        
	        TextView dataNas = (TextView) view.findViewById(R.itemCand.dataNasc);
	        dataNas.setText(candidato.getData_nasc());
	        
	        TextView email = (TextView) view.findViewById(R.itemCand.email);
	        email.setText(candidato.getEmail());
	        
	        TextView escolaridade = (TextView) view.findViewById(R.itemCand.escolaridade);
	        escolaridade.setText(candidato.getEscolaridade());
	        
	        TextView inst = (TextView) view.findViewById(R.itemCand.instEnsino);
	        inst.setText(candidato.getInstituicao_ensino());
	        
	        TextView dataConcl = (TextView) view.findViewById(R.itemCand.dataConclu);
	        dataConcl.setText(candidato.getData_conclusao());
	        
	        //area atuação
//	        TextView area = (TextView) view.findViewById(R.itemCand.nome);
//	        area.setText(candidato.getNome());
	        
		return view;
	}

}
