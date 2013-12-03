package br.com.lacerda.gestaorh.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;
import br.com.lacerda.gestaorh.R;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;

public class CheckBoxListAdapter extends BaseAdapter {

	private Context context;
	private List<AreaAtuacaoModel> areaList;
	private Boolean[] checked;

	public CheckBoxListAdapter(Context context,
			List<AreaAtuacaoModel> partidaList) {

		this.context = context;
		this.areaList = partidaList;
		
		checked = new Boolean[areaList.size()];

	}

	@Override
	public int getCount() {
		return areaList.size();
	}

	@Override
	public Object getItem(int position) {
		return areaList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		AreaAtuacaoModel areaModel = areaList.get(position);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.layout_item_checkbox, null);

		LinearLayout ll = (LinearLayout) view
				.findViewById(R.itemCheckBox.linear);
		final CheckBox[] cb = new CheckBox[areaList.size()];

		cb[position] = new CheckBox(context);
		ll.addView(cb[position]);
		cb[position].setText(areaModel.getNomeArea());
		cb[position].setId(position);
		
		cb[position].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Boolean cbIsChecked = cb[position].isChecked();
				
				if(cbIsChecked){
					
					checked[position] = cbIsChecked;
					
				}else{
					
					checked[position] = cbIsChecked;
					
				}
				
				
				Toast.makeText(context, String.valueOf(cbIsChecked) + " " + position,Toast.LENGTH_SHORT).show();
			}
		});

		return view;
	}

}
