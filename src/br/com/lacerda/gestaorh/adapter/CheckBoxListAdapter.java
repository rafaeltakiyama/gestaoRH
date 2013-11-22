package br.com.lacerda.gestaorh.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import br.com.lacerda.gestaorh.R;
import br.com.lacerda.gestaorh.model.AreaAtuacaoModel;

public class CheckBoxListAdapter extends BaseAdapter {

	private Context context;
	private List<AreaAtuacaoModel> areaList;

	public CheckBoxListAdapter(Context context,
			List<AreaAtuacaoModel> partidaList) {

		this.context = context;
		this.areaList = partidaList;

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
	public View getView(int position, View convertView, ViewGroup parent) {

		AreaAtuacaoModel areaModel = areaList.get(position);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.layout_item_checkbox, null);

		LinearLayout ll = (LinearLayout) view
				.findViewById(R.itemCheckBox.linear);
		CheckBox[] cb = new CheckBox[areaList.size()];
		int i = 0;

		cb[i] = new CheckBox(context);
		ll.addView(cb[i]);
		cb[i].setText(areaModel.getNomeArea());
		cb[i].setId(i);
		i++;

		return view;
	}

}
