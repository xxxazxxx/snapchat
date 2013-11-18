package com.mduggan92.snapchat;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import com.mduggan92.snapchat.contacts.ContactsFragment;
import com.mduggan92.snapchat.mailbox.MailboxFragment;

public class FragmentPager extends FragmentPagerAdapter implements
		OnPageChangeListener {

	private static final String TAG = "FragmentPager";
	static final int PAGE_COUNT = 3;
	public static final int CAMERA = 1;
	public static final int MAILBOX = 0;
	public static final int CONTACTS = 2;
	private Activity a;

	public FragmentPager(FragmentManager fm, Activity a) {
		super(fm);
		this.a = a;
	}

	@Override
	public Fragment getItem(int arg0) {
		MailboxFragment mail = new MailboxFragment();
		switch (arg0) {
		case CAMERA:
			return new CameraFragment();
		case MAILBOX:
			return mail;
		case CONTACTS:
			return new ContactsFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		a.invalidateOptionsMenu();
		Log.d(TAG, "On Page Selected: " + arg0);
		if (arg0 == CAMERA) {
			a.getActionBar().setTitle("Camera");
			a.getActionBar().setBackgroundDrawable(new ColorDrawable(MainActivity.ACTIONBAR_BLACK));
			a.getActionBar().hide();
			a.getActionBar().setDisplayHomeAsUpEnabled(false);
			a.getActionBar().setDisplayHomeAsUpEnabled(true);
		} else if (arg0 == MAILBOX) {
			a.getActionBar().setTitle("Mailbox");// 9065ad
			a.getActionBar().setBackgroundDrawable(new ColorDrawable(MainActivity.ACTIONBAR_GREEN));
			a.getActionBar().show();
			a.getActionBar().setDisplayHomeAsUpEnabled(false);
			a.getActionBar().setDisplayHomeAsUpEnabled(true);
		} else {
			a.getActionBar().setTitle("Contacts");
			a.getActionBar().setBackgroundDrawable(new ColorDrawable(MainActivity.ACTIONBAR_PURPLE));
			a.getActionBar().show();
			a.getActionBar().setDisplayHomeAsUpEnabled(false);
			a.getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

}
