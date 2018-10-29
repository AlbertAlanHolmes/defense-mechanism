package com.example.fanghudun1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(Button)findViewById(R.id.dianhua);
    }

    public void lanjie(View v){
    	Intent intent=new Intent(this,telephonelanjie.class);
    	//String value=lv.getText().toString();
    	//intent.putExtra("name", value);
    	
    	startActivityForResult(intent, 10);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
