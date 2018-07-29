package com.example.ralph.newsapp;


/**
 * An {@link News} object contains information related to a single news item.
 */
public class News {

    /**
     * title of the news item
     */
    private String mNewsTitle;

    /**
     * section of the news item
     */
    private String mNewsSection;

    /**
     *  author of the news item
     * */
    private String mNewsAuthor;

    private boolean mHasAuthor;

    /**
     * Time of the news item
     */
    private String mNewsDate;

    /**
     * Website URL of the news item
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param newsTitle   is the title of the news item
     * @param newsSection is the section of the news item
     * @param newsDate    is the date when the news item was published
     * @param url         is the website URL to find more details about the news item
     */
    public News(String newsTitle, String newsSection, String newsDate, String url) {
        mNewsTitle = newsTitle;
        mNewsSection = newsSection;
        mNewsDate = newsDate;
        mUrl = url;

    }

    /**
     * Constructs a new {@link News} object.
     *
     * @param newsTitle   is the title of the news item
     * @param newsSection is the section of the news item
     *                    @param newsAuthor is the author of the news item
     * @param newsDate    is the date when the news item was published
     * @param url         is the website URL to find more details about the news item
     */
    public News(String newsTitle, String newsSection, String newsDate, String url, String newsAuthor) {
        mNewsTitle = newsTitle;
        mNewsSection = newsSection;
        mNewsDate = newsDate;
        mUrl = url;
        mNewsAuthor = newsAuthor;
    }

    /**
     * Returns the title of the news item.
     */
    public String getNewsTitle() {
        return mNewsTitle;
    }

    /**
     * Returns the section of the news item
     */
    public String getNewsSection() { return mNewsSection; }

    /**
     *  Returns the author of the news item.
     * */

    public String getNewsAuthor() { return mNewsAuthor; }

    /**
     *  Returns whether or not there is an author.
     */
    public boolean hasAuthor() { return mNewsAuthor != null; }

    /**
     * Returns the date of the news item.
     */
    public String getNewsDate() {
        return mNewsDate;
    }

    /**
     * Returns the website URL to find more information about the news item.
     */
    public String getUrl() {
        return mUrl;
    }

}