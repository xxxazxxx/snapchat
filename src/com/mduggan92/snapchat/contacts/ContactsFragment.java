package com.mduggan92.snapchat.contacts;


import com.mduggan92.snapchat.Data;
import com.mduggan92.snapchat.R;
import com.mduggan92.snapchat.R.id;
import com.mduggan92.snapchat.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class ContactsFragment extends Fragment implements OnItemClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.contacts, container,false);
		
		ListView list = (ListView) view.findViewById(R.id.contactlist);
		
		ContactArrayAdapter adapter = new ContactArrayAdapter(getActivity(), R.id.contactlist, Data.getUsers());
		list.setAdapter(adapter);
		//list.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if(Data.getUser(arg2).isGroup) {
		}
	}



}
