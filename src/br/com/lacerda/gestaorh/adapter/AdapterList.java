package br.com.lacerda.gestaorh.adapter;

import java.util.ArrayList;

import br.com.lacerda.gestaorh.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterList extends ArrayAdapter<String>{
	
	private Context context;
	private int textViewResourceId;
	private ArrayList<String> stringArray;

	public AdapterList(Context context, int textViewResourceId, ArrayList<String> stringArray) {
		super(context, textViewResourceId);
		
		this.context = context;
		this.stringArray = stringArray;
		this.textViewResourceId = textViewResourceId;
	}

	@Override
	public int getCount() {
		return stringArray.size();
	}

	@Override
	public String getItem(int position) {
		return stringArray.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		LayoutInflater inflater = (LayoutInflater)
	            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View view = inflater.inflate(textViewResourceId, null);

		TextView text = (TextView) view.findViewById(R.itemLista.item);
		text.setText(stringArray.get(position));

		return view;
	}

	
}
