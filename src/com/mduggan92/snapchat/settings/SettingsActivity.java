package com.mduggan92.snapchat.settings;

import com.mduggan92.snapchat.MainActivity;
import com.mduggan92.snapchat.R;
import com.mduggan92.snapchat.R.style;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuItem;

public class SettingsActivity extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setTitle("Settings");
		getActionBar().setBackgroundDrawable(
				new ColorDrawable(MainActivity.ACTIONBAR_BLUE));
		invalidateOptionsMenu();
		
		
		setTheme(R.style.settings_theme);
		findViewById(android.R.id.content).setBackgroundColor(0xFFFFFFFF);
		getFragmentManager().beginTransaction()
        .replace(android.R.id.content, new SettingsFragment())
        .commit();		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
