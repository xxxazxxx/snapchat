package com.mduggan92.snapchat.mailbox.outbox;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.mduggan92.snapchat.Data;
import com.mduggan92.snapchat.MainActivity;
import com.mduggan92.snapchat.R;
import com.mduggan92.snapchat.settings.SettingsActivity;

public class GroupList extends Activity {

	final static String TAG = "GroupList";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grouplist);
		ListView list = (ListView) findViewById(R.id.grouplistview);

		final OutputSnapArrayAdapter adapter = new OutputSnapArrayAdapter(this,
				R.id.grouplistview, Data.getListSnaps());
		list.setAdapter(adapter);
		getActionBar().setBackgroundDrawable(
				new ColorDrawable(MainActivity.ACTIONBAR_GREEN));
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setTitle("Ski Team");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.groupmenu, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		case R.id.action_settings:
			Intent myIntent = new Intent(this, SettingsActivity.class);
			startActivity(myIntent);
			return true;

		}

		return super.onOptionsItemSelected(item);
	}

}
