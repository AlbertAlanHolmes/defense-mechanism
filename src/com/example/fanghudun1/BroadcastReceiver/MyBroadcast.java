package com.example.fanghudun1.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.example.fanghudun1.Shujuku;
import com.example.fanghudun1.telephonelanjie;

public class MyBroadcast extends BroadcastReceiver{
	MyBroadcast mb;
	String[] telephones;
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		//if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
			//Log.i("1111111111", "22222222222");
			Bundle bundle=intent.getExtras();
			if(bundle!=null){
				Object[] pdus=(Object[])bundle.get("pdus");
				SmsMessage[] messages=new SmsMessage[pdus.length-1];
				for (int i = 0; i < pdus.length; i++) {
					byte[] pdu = (byte[]) pdus[i];
					messages[i] = SmsMessage.createFromPdu(pdu);
				}
				//for (SmsMessage message : messages) {
					String sender = messages[0].getOriginatingAddress();
					telephones=telephonelanjie.telephones;
					for(String telephone:telephones){
						Log.i("2222222222222", telephone);
						if(telephone.equals(sender)){
							abortBroadcast();
							Toast.makeText(context, "À¹½Ø", Toast.LENGTH_LONG).show();
						}
					}
				//}
			//}
		}
	}


}
