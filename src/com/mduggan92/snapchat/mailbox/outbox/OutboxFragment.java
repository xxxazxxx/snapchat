package com.mduggan92.snapchat.mailbox.outbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.mduggan92.snapchat.Data;
import com.mduggan92.snapchat.R;

public class OutboxFragment extends Fragment implements OnItemClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.outbox, container, false);

		ListView list = (ListView) v.findViewById(R.id.outboxlist);

		final OutputSnapArrayAdapter adapter = new OutputSnapArrayAdapter(getActivity(),
				R.id.outboxlist, Data.getOutboxSnaps());
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(this);
		
		return v;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if (arg2 >= Data.NUM_ITEMS){
			Intent myIntent = new Intent(getActivity(), GroupList.class);
			getActivity().startActivity(myIntent);
		}
	}


}
