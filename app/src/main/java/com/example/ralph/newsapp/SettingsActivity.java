package com.example.ralph.newsapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * This is used to contain a PreferenceFragment
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class NewsPreferenceFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener    {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            Preference numberNewsItems = findPreference(getString(R.string.number_news_items_key));
            bindPreferenceSummaryToValue(numberNewsItems);

            Log.i("Settings Activity", "number of news items =  " + numberNewsItems);

            Preference date = findPreference(getString(R.string.settings_from_date_key));
            bindPreferenceSummaryToValue(date);

            Preference toDate = findPreference(getString(R.string.settings_to_date_key));
            bindPreferenceSummaryToValue(toDate);

        }

        // This method will be called when the user has changed a Preference
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            // This code takes care of updating the displayed preference summary
            // after it has been changed
            String stringValue = value.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;
        }

        // Helper method to help with binding the value that's in SharedPreferences
        // to update the preference summary when the settings activity is launched
        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences =
                    PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceString);
        }
    }
}