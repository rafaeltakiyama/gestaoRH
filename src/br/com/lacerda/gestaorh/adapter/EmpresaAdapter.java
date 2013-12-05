package br.com.lacerda.gestaorh.adapter;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.lacerda.gestaorh.R;
import br.com.lacerda.gestaorh.model.CandidatoModel;
import br.com.lacerda.gestaorh.model.EmpresaModel;


public class EmpresaAdapter extends BaseAdapter{
	
	private Context context;
	private EmpresaModel empresa;
	
	public EmpresaAdapter(Context context, EmpresaModel empresa) {
		super();
		this.context = context;
		this.empresa = empresa;
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
	        View view = inflater.inflate(R.layout.layout_dialog_confirma_dados_empresa, null);
	        
	        String title;
	        
	        title = "<b>Nome: </b>";
	        TextView nome = (TextView) view.findViewById(R.itemEmpresa.nometxt);
	        nome.setText(Html.fromHtml(title + empresa.getNomeEmpresa()));

	        title = "<b>Endereço: </b>";
	        TextView end = (TextView) view.findViewById(R.itemEmpresa.enderecotxt);
	        end.setText(Html.fromHtml(title + empresa.getEnderecoEmpresa()));
	        
	        title = "<b>E-mail: </b>";
	        TextView email = (TextView) view.findViewById(R.itemEmpresa.emailTxt);
	        email.setText(Html.fromHtml(title + empresa.getEmailEmpresa()));
	        
	        //area atuação
	        
		return view;
	}

}
