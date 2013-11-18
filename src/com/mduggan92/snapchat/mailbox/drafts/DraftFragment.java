package com.mduggan92.snapchat.mailbox.drafts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mduggan92.snapchat.Data;
import com.mduggan92.snapchat.R;


public class DraftFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.draftbox, container, false);

		ListView list = (ListView) v.findViewById(R.id.draftlist);
		final DraftSnapArrayAdapter adapter = new DraftSnapArrayAdapter(
				getActivity(), R.id.draftlist, Data.getDraftSnaps());
		list.setAdapter(adapter);
		return v;
	}

}
