package com.example.mattlauer.omgandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by mattlauer on 2014-10-08.
 */
public class DetailActivity extends Activity {
    private static final String IMAGE_URL_BASE = "http://covers.openlibrary.org/b/id/"; // 13
    String mImageURL; // 13


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tell the activity which XML layout is right
        setContentView(R.layout.activity_detail);

        // Enable the "Up" button for more navigation options
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Access the imageview from XML
        ImageView imageView = (ImageView) findViewById(R.id.img_cover);
        TextView titleTextView = (TextView) findViewById(R.id.text_detail_title);
        TextView authorTextView = (TextView) findViewById(R.id.text_detail_author);

        // 13. unpack the coverID from its trip inside your Intent
        String coverID = this.getIntent().getExtras().getString("coverID");
        String titleID = this.getIntent().getExtras().getString("titleID");
        String authorID = this.getIntent().getExtras().getString("authorID");

        // See if there is a valid coverID
        if (coverID.length() > 0) {

            // Use the ID to construct an image URL
            mImageURL = IMAGE_URL_BASE + coverID + "-L.jpg";

            // Use Picasso to load the image
            Picasso.with(this).load(mImageURL).placeholder(R.drawable.img_books_loading).into(imageView);
        }

        // See if there is a valid titleID
        if (titleID.length() > 0) {
            titleTextView.setText(titleID);
        }

        // See if there is a valid authorID
        if (authorID.length() > 0) {
            authorTextView.setText(authorID);
        }
    }
}
