package com.example.fanghudun1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlacklistAdapter extends BaseAdapter {

	 private Context context = null;
	    private List<Blacklist> blackList = null;
		
	    public BlacklistAdapter(Context context) {
			this.context = context;
			blackList = new ArrayList<Blacklist>();
		}

		@Override
		public int getCount() {
			
			return blackList.size();
		}

		@Override
		public Object getItem(int position) {
			
			return blackList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View contentView, ViewGroup group) {
			//�ҵ�Ҫ��ʾ������
			Blacklist user = blackList.get(position);
			
			if(contentView == null){
				contentView = LayoutInflater.from(context).inflate(R.layout.two_list, null);
			}
			
			TextView Id = (TextView) contentView.findViewById(R.id.userid);
			TextView Name = (TextView) contentView.findViewById(R.id.username);
			TextView telephone = (TextView) contentView.findViewById(R.id.usertelephone);
			
			Id.setText(user.getId()+"");
			Name.setText(user.getName());
			telephone.setText(user.getTelephone()+"");
			
			return contentView;
		}
		
		public void addUser(Collection<Blacklist> c){
			blackList.addAll(c);
			notifyDataSetChanged();
		}
		
		public void addUser(Blacklist user){
			blackList.add(user);
			notifyDataSetChanged();
		}
		
		public void clear(){
			blackList.clear();
			notifyDataSetChanged();
		}
		
		public void delete(int position){
			blackList.remove(position);
			notifyDataSetChanged();
		}
		
		public void flush(){
			notifyDataSetChanged();
		}

}
