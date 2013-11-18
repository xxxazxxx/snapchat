package com.mduggan92.snapchat.mailbox.outbox;

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


public class OutputSnapArrayAdapter extends ArrayAdapter<SingleSnap> {

	public OutputSnapArrayAdapter(Context context, int textview,
			List<SingleSnap> snaps) {
		super(context, textview, snaps);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.outputsnap, null);
		}

		SingleSnap current = Data.getOutboxSnap(position);
		TextView name = (TextView) convertView.findViewById(R.id.output_username);
		TextView status = (TextView) convertView.findViewById(R.id.output_status);
		ImageView image = (ImageView) convertView.findViewById(R.id.output_snaptype);
		// ImageView

		// set data
		name.setText(current.username);
		status.setText(current.timestamp);
		
		if (current.type == SingleSnap.PICTURE
				&& current.status == SingleSnap.RECEIVED)
			image.setImageResource(R.drawable.camera_unopened);
		else if (current.type == SingleSnap.VIDEO
				&& current.status == SingleSnap.RECEIVED)
			image.setImageResource(R.drawable.video_unopened);
		else if (current.type == SingleSnap.PICTURE
				&& current.status == SingleSnap.OPENED)
			image.setImageResource(R.drawable.video_opened);
		else
			image.setImageResource(R.drawable.picture_opened);
		
		image.setLayoutParams(new LayoutParams(72, 72));
		image.setPadding(6, 6, 6, 6);
		
		
		return convertView;
	}

}
