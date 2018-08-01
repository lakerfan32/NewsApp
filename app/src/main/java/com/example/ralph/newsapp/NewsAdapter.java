package com.example.ralph.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news item
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context     of the app
     * @param newsItems is the list of news items, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> newsItems) {
        super(context, 0, newsItems);
    }

    /**
     * Returns a list item view that displays information about the news item at the given position
     * in the list of news items.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news item at the given position in the list of news items
        News currentNewsItem = getItem(position);

        // Get the news item date string from the News object
        String newsItemDate = currentNewsItem.getNewsDate();

        // Format date string so Date and Time are split
        String[] dateTimeparts = newsItemDate.split("T");
        // newsItemDateDay should just be the date part
        String newsItemDateDay = dateTimeparts[0];

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);

        // Display the date of the current news item in that TextView
        dateView.setText(newsItemDateDay);

        // newsItemTimeDraft will include the time part of the date plus the Z
        String newsItemTimeDraft = dateTimeparts[1];
        String[] timeParts = newsItemTimeDraft.split("Z");
        // newsItemTime trims off the Z part of the date
        String newsItemTime = timeParts[0];

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);

        // Display the time of the current news item in that TextView
        timeView.setText(newsItemTime);

        // Get the news item title string from the News object
        String newsItemTitle = currentNewsItem.getNewsTitle();

        // Find the TextView with view ID news title
        TextView newsTitleTextView = (TextView) listItemView.findViewById(R.id.news_title);
        // Display the title of the current news item in that TextView
        newsTitleTextView.setText(newsItemTitle);

        // Get the news item section string from the News object
        String newsItemSection = currentNewsItem.getNewsSection();
        // Find the TextView with view ID news section
        TextView newsSectionTextView = (TextView) listItemView.findViewById(R.id.news_section);
        // Display the section of the current news item in that TextView
        newsSectionTextView.setText(newsItemSection);

        // Get the news item author string from the News object
        String newsAuthorByline = currentNewsItem.getNewsAuthor();
        // Find the TextView with view ID news author
        TextView newsAuthorTextView = (TextView) listItemView.findViewById(R.id.news_author);

        // Determine if news item has author or not
        if (currentNewsItem.hasAuthor()) {
            // Display the author of the current news item in that TextView
            newsAuthorTextView.setText(newsAuthorByline);
            // make text view visible
            newsAuthorTextView.setVisibility(View.VISIBLE);
        } else {
            // make text view not visible
            newsAuthorTextView.setVisibility(View.GONE);
        }

        // Return the list item view that is now showing the appropriate news data
        return listItemView;
    }
}