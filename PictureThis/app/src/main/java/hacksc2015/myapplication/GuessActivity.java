package hacksc2015.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class GuessActivity extends AppCompatActivity {

    // Set your Image URL into a string
    String URL = "http://picturethis.blob.core.windows.net:80/todoitemimages/d27aa9a4-dc46-4417-83f3-05d7f411fb34";
    ImageView image;
    Bitmap bmap;
    Bitmap scaled;
    Button button;
    ProgressDialog mProgressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        image = imageView;
        String urlFromIntent = getIntent().getExtras().getString("uri");
//        URL = urlFromIntent;
        //URL = "http://picturethis.blob.core.windows.net:80/todoitemimages/5dbfed87-24c6-43c6-a100-7b44bc161313";




        URL = getIntent().getExtras().getString("uri");



// Execute DownloadImage AsyncTask
        new DownloadImage().execute(URL);



        //put in image choice handler
        ImageChoiceHandler imageChoiceHandler = new ImageChoiceHandler(this, getIntent().getExtras().getString("adj"));

    }

    public void setImgView(Bitmap bm){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(bm);
    }

    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }


    // DownloadImage AsyncTask
    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(GuessActivity.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Download Image Tutorial");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {
                // Download Image from URL
                InputStream input = new java.net.URL(imageURL).openStream();
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            // Set the bitmap into ImageView
//            image.setImageBitmap(result);

            //set bmap
            bmap = result;
            scaled = Bitmap.createScaledBitmap(bmap, 1500, 1000, false);
            image.setRotation(90);
            image.setImageBitmap(scaled);
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }


}
