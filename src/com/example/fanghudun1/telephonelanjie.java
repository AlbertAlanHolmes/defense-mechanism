package com.example.fanghudun1;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import com.example.fanghudun1.BroadcastReceiver.MyBroadcast;


public class telephonelanjie extends Activity implements OnClickListener {

	private EditText telephone;
	private EditText Name;
	private EditText id;
	private ListView lvUsers;
	int position=0;

	private  Shujuku ren=null;
	 private BlacklistAdapter adapter;
	 MyBroadcast mb;
	 
	 public static String[] telephones;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dianhua);
		
		
			Name=(EditText)findViewById(R.id.Name);
			telephone=(EditText)findViewById(R.id.telephone);
			lvUsers=(ListView)findViewById(R.id.lvUsers);
			id=(EditText)findViewById(R.id.etid);
			
			 adapter = new BlacklistAdapter(this);
		        lvUsers.setAdapter(adapter);
			
			ren=new Shujuku(this);
			
			lvUsers.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					position=arg2;
				}
				
			});
			
			mb= new MyBroadcast();
			IntentFilter filter=new IntentFilter("MyReceiver_Action");
			registerReceiver(mb, filter);
			telephones=ren.serchNumber();
		
	}
	
	

	public void insert(View v){
		Blacklist use=new Blacklist();
		use.setName(Name.getText().toString());
		use.setTelephone(telephone.getText().toString());//int ת��Ϊstring����
		ren.insert(use);
		telephones=ren.serchNumber();
	}
	
	public void delete(View v){
		position= Integer.parseInt(id.getText().toString());
		ren.delect(position);
		adapter.flush();
	}
	
	public void showUsers(View v){
		List<Blacklist> users = ren.searchUsers();
    	adapter.clear();
    	adapter.addUser(users);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		unregisterReceiver(mb);
		super.onDestroy();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
	
}
