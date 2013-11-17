package br.com.lacerda.gestaorh.banco;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class BancoDados extends SQLiteOpenHelper{ //nao � publica... so quem esta no mesmo pacote enxerga- (BancoHelper) 
	
	//so vamos trabalhar com um Banco
	public static final String BANCO_NOME = "gestaorh";
	public static final String TAG = "BancoDados";
	

	public BancoDados(Context context, int version) {
		super(context, BANCO_NOME, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		InputStream is = getClass().getResourceAsStream("banco.sql");//acessa os dados bits
		InputStreamReader isr = new InputStreamReader(is);//Leitor de stream - para n�o trabalhar com bit
		BufferedReader bf = new BufferedReader(isr);//otimiza a leitura - memoria - tenta impedir que estoure a memoria
		
		String line;
		
		try {
			StringBuilder command = new StringBuilder();
			
			while ((line = bf.readLine()) != null) {
				command.append(line);
				
				if(line.endsWith(";")){
					db.execSQL(command.toString());
					command = new StringBuilder();
				}
				
			}
		} catch (Exception e) {
			Log.e(TAG, "Erro criado banco de dados", e);
		}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		InputStream is = null;
		
		if(oldVersion == 1){
			is = getClass().getResourceAsStream("banco_upgrade.sql");//acessa os dados bits
			
		}
		
		InputStreamReader isr = new InputStreamReader(is);//Leitor de stream - para n�o trabalhar com bit
		BufferedReader bf = new BufferedReader(isr);//otimiza a leitura - memoria - tenta impedir que estoure a memoria
		
		String line;
		
		try {
			StringBuilder command = new StringBuilder();
			
			while ((line = bf.readLine()) != null) {
				command.append(line);
				
				if(line.endsWith(";")){
					db.execSQL(command.toString());
					command = new StringBuilder();
				}
				
			}
		} catch (Exception e) {
			Log.e(TAG, "Erro criado banco de dados", e);
		}
	}
	
}
