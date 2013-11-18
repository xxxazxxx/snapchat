package com.mduggan92.snapchat.mailbox.drafts;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.mduggan92.snapchat.Data;
import com.mduggan92.snapchat.R;
import com.mduggan92.snapchat.mailbox.SingleSnap;


public class DraftSnapArrayAdapter extends ArrayAdapter<SingleSnap>{
	
	public DraftSnapArrayAdapter(Context context, int textview, List<SingleSnap> snaps) {
		super(context, textview, snaps);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.draftsnap, null);
		}
		
		SingleSnap current = Data.getDraftSnap(position);
		TextView name = (TextView) convertView.findViewById(R.id.draft_recipients);
		TextView status = (TextView) convertView.findViewById(R.id.draft_status);
		TextView action = (TextView) convertView.findViewById(R.id.draft_action);
		ImageView image = (ImageView) convertView.findViewById(R.id.draft_snaptype);
		//set data
		name.setText(current.username);
		status.setText(current.timestamp);
		action.setText(current.action);
		
		if (current.type == SingleSnap.PICTURE)
			image.setImageResource(R.drawable.camera_unopened);
		else if (current.type == SingleSnap.VIDEO)
			image.setImageResource(R.drawable.video_unopened);

		image.setLayoutParams(new LayoutParams(72, 72));
		image.setPadding(6, 6, 6, 6);
		

		return convertView;
	}

}
