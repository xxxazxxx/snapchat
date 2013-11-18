package com.mduggan92.snapchat;

import com.mduggan92.snapchat.settings.SettingsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends FragmentActivity {

	public final static int ACTIONBAR_GREEN = 0xFF4EA787;
	public final static int ACTIONBAR_PURPLE = 0xFF8C67AA;
	public static final int ACTIONBAR_BLUE = 0xFF4E6FA6;
	public final static int ACTIONBAR_BLACK = 0x00000000;
	public final static int MAILBOX_DARK_GREEN = 0;
	public final static String MAILBOX_GREEN = "#4ea787";
	public final static String DARK_GREEN_STRING = "#306854";

	static ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		pager = (ViewPager) findViewById(R.id.pager);
		FragmentManager fm = getSupportFragmentManager();
		FragmentPager pagerAdapter = new FragmentPager(fm, this);
		pager.setAdapter(pagerAdapter);
		pager.setCurrentItem(1);
		pager.setOnPageChangeListener(pagerAdapter);
		getActionBar().hide();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (pager.getCurrentItem() != FragmentPager.CAMERA)
			cameraClick(null);
		else
			super.onBackPressed();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			cameraClick(null);
			return true;
		case R.id.action_settings:
			Intent myIntent = new Intent(this, SettingsActivity.class);
			startActivity(myIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		MenuInflater inflater = getMenuInflater();
		if (pager.getCurrentItem() == FragmentPager.CAMERA) {
			inflater.inflate(R.menu.main, menu);
		} else if (pager.getCurrentItem() == FragmentPager.MAILBOX) {
			inflater.inflate(R.menu.maiboxmenu, menu);
		} else {
			inflater.inflate(R.menu.contactsmenu, menu);
		}
		return super.onCreateOptionsMenu(menu);
	}

	public void cameraClick(View v) {
		pager.setCurrentItem(FragmentPager.CAMERA);
	}

	public void mailboxClick(View v) {
		pager.setCurrentItem(FragmentPager.MAILBOX);
	}

	public void contactClick(View v) {
		pager.setCurrentItem(FragmentPager.CONTACTS);
	}

}
