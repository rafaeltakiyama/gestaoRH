package br.com.lacerda.gestaorh.adapter;

import java.util.ArrayList;
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
	private List<CheckBox> cb = new ArrayList<CheckBox>();
	private int i = 0;

	public CheckBoxListAdapter(Context context,
			List<AreaAtuacaoModel> areaList) {

		this.context = context;
		this.areaList = areaList;

	}

	@Override
	public int getCount() {
		return areaList.size();
	}

	@Override
	public AreaAtuacaoModel getItem(int position) {
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

		LinearLayout ll = (LinearLayout) view.findViewById(R.itemCheckBox.linear);
		CheckBox check =  new CheckBox(context);
		check.setId(i);
		cb.add(check);
		ll.addView(cb.get(position));
		cb.get(position).setText(areaModel.getNomeArea());
		
		cb.get(position).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Boolean ckBoxIsChecked = cb.get(position).isChecked();
				Toast.makeText(context, ckBoxIsChecked.toString(),
						Toast.LENGTH_SHORT).show();
			}
		});
		i++;
		
		return view;
	}

}
