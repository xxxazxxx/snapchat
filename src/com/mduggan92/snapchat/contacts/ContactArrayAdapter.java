package com.mduggan92.snapchat.contacts;

import java.util.List;

import com.mduggan92.snapchat.R;
import com.mduggan92.snapchat.User;
import com.mduggan92.snapchat.R.id;
import com.mduggan92.snapchat.R.layout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactArrayAdapter extends ArrayAdapter<User> {

	private static final String TAG = "Array Adapter";
	List<User> users;
	LayoutInflater inflater = null;

	public ContactArrayAdapter(Context context, int resource, List<User> user) {
		super(context, resource, user);
		this.users = user;
		inflater = (LayoutInflater) getContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		User user = users.get(position);
		if (user.isSection) {
			convertView = inflater.inflate(R.layout.section, null);
			Log.d(TAG, "User: " + user.name + " " + convertView);

			TextView name = (TextView) convertView
					.findViewById(R.id.contact_sectionheader);
			name.setText(user.name);
		} else {
			convertView = inflater.inflate(R.layout.contact, null);
			TextView name = (TextView) convertView
					.findViewById(R.id.contact_name);
			TextView username = (TextView) convertView
					.findViewById(R.id.contact_username);
			name.setText(user.name);
			username.setText(user.username);
		}

		return convertView;
	}

}
