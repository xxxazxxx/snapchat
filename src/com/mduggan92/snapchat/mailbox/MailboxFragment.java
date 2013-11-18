package com.mduggan92.snapchat.mailbox;

import com.mduggan92.snapchat.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;

import com.mduggan92.snapchat.MainActivity;
import com.mduggan92.snapchat.mailbox.drafts.DraftFragment;
import com.mduggan92.snapchat.mailbox.inbox.InboxFragment;
import com.mduggan92.snapchat.mailbox.outbox.OutboxFragment;

public class MailboxFragment extends Fragment {

	FragmentTabHost host;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mailbox, container, false);
		host = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		host.setup(getActivity(), getChildFragmentManager(),
				R.id.realtabcontent);
		host.addTab(host.newTabSpec("inbox").setIndicator("Inbox"),
				InboxFragment.class, null);
		host.addTab(host.newTabSpec("outbox").setIndicator("Outbox"),
				OutboxFragment.class, null);
		host.addTab(host.newTabSpec("drafts").setIndicator("Drafts"),
				DraftFragment.class, null);
		
		host.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				 for(int i=0;i<host.getTabWidget().getChildCount();i++)
					{
						host.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor(MainActivity.DARK_GREEN_STRING));
					}

					host.getTabWidget().getChildAt(host.getCurrentTab()).setBackgroundColor(Color.parseColor(MainActivity.MAILBOX_GREEN));			}
		});
		host.setCurrentTab(1);
		host.setCurrentTab(0);
			
		return view;
	}

}
