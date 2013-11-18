package com.mduggan92.snapchat.settings;

import com.mduggan92.snapchat.R;
import com.mduggan92.snapchat.R.xml;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.settings);
		getActivity().getActionBar().setHomeButtonEnabled(true);

    }

}

