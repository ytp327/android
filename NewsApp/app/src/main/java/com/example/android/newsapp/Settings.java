package com.example.android.newsapp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @Override
    public void onBackPressed() {
        // the setting is changed, so start a new intent
        Intent NewsIntent = new Intent(this, NewsAppActivity.class);
        startActivity(NewsIntent);
    }

    public static class NewsListPreferenceFragment extends PreferenceFragment
            implements Preference.OnPreferenceChangeListener {

        @SuppressLint("ResourceType")
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.layout.setting);

            // display user name preference
            Preference userName = findPreference("user_name");
            preferenceDisplay(userName);
            // display max results preference
            Preference maxResults = findPreference("max_results");
            preferenceDisplay(maxResults);
        }


        private void preferenceDisplay(Preference preference){
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences =
                    PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(),"");
            preference.setSummary(preferenceString);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String stringValue = newValue.toString();
            preference.setSummary(stringValue);
            return true;
        }

    }
}
