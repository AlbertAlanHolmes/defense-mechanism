package com.example.fanghudun1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Shujuku extends SQLiteOpenHelper {

	private static final String DBNAME = "ONE";
	private static final int VERSION = 1;
	private static final String TBNAME = "TWO";

	private Context context = null;

	public Shujuku(Context context) {

		super(context, DBNAME, null, VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql = "create table " + TBNAME + "("
				+ "id Integer primary key autoincrement,"
				+ "name varchar(40) not null," + "telephone varchar(30)" + ")";
		db.execSQL(sql);
		Toast.makeText(context, "onCreate������", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Toast.makeText(context, "onupgrade������", Toast.LENGTH_LONG).show();

	}

	public void insert(Blacklist use) {

		SQLiteDatabase db = getWritableDatabase();

		ContentValues cv = new ContentValues();

		cv.put("Name", use.getName());
		cv.put("telephone", use.getTelephone()+"");

		db.insert(TBNAME, null, cv);
		Toast.makeText(context, "insert������", Toast.LENGTH_LONG).show();

	}

	public List<Blacklist> searchUsers() {
		List<Blacklist> users = null;
		SQLiteDatabase db = getWritableDatabase();

		Cursor c = db.query(TBNAME, null, null, null, null, null, null);
		// db.rawQuery("select id,name,salary from " + TBNAME, null);
		if (c != null) {
			users = new ArrayList<Blacklist>();

			while (c.moveToNext()) {
				Blacklist u = new Blacklist();
				u.setId(c.getInt(0));
				u.setName(c.getString(1));
				u.setTelephone(c.getString(2));
				users.add(u);
			}

		}

		db.close();

		return users;
	}
	
	public void delect(int position){
		SQLiteDatabase db=getWritableDatabase();
		db.delete(TBNAME, "id=?", new String[]{""+position});
		db.close();
	}

	public String[] serchNumber(){
		SQLiteDatabase db = getWritableDatabase();
		List<String> telephones=new ArrayList<String>();
		Cursor c = db.query(TBNAME, new String[]{"telephone"}, null, null, null, null, null);
		if (c != null) {
			while (c.moveToNext()) {
				telephones.add(c.getString(0));
			}
		}
		//String[] telephones_arr=(String[])telephones.toArray(typeof("String"));
		String[] telephones_arr= new String[telephones.size()];
		for(int i=0;i<telephones.size();i++){
			telephones_arr[i]=telephones.get(i);
		}
		return telephones_arr;
	}
}
