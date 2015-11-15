package hacksc2015.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URI;

public class GuessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        String stringUri = intent.getExtras().getString()
        Uri imageUri = Uri.parse(intent.getExtras().getString("uri"));
        imageView.setImageURI(imageUri);



        //put in image choice handler
        ImageChoiceHandler imageChoiceHandler = new ImageChoiceHandler(this);

    }


}
