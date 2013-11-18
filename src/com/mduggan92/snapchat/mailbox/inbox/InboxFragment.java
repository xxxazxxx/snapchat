package com.mduggan92.snapchat.mailbox.inbox;

import com.mduggan92.snapchat.Data;
import com.mduggan92.snapchat.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class InboxFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.inbox, container, false);

		ListView list = (ListView) v.findViewById(R.id.inboxlist);

		final InputSnapArrayAdapter adapter = new InputSnapArrayAdapter(
				getActivity(), R.id.inboxlist, Data.getInboxSnaps());
		list.setAdapter(adapter);

		return v;
	}

}
