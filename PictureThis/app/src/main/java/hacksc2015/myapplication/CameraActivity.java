package hacksc2015.myapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class CameraActivity extends AppCompatActivity {

    public String adjectives[] = {"red", "orange", "yellow","green", "blue", "purple", "azure"};
    private static String logtag = "CameraApp";
    private static int takePicture = 1;
    private Uri imageUri;
    public int key = (int)(Math.random()*adjectives.length);
    public Bitmap scaled;
    private Button cameraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cameraButton = (Button)findViewById(R.id.button_camera);
        cameraButton.setText(adjectives[key]);
        cameraButton.setOnClickListener(cameraListener);


    }
    private View.OnClickListener nextListener = new View.OnClickListener(){
        public void onClick(View v){
            Intent intent = new Intent("MAIN");
            startActivity(intent);
        }
    };
    private View.OnClickListener cameraListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            takePhoto(v);
        }
    };
    private void takePhoto(View v){
       // Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "picture.jpg");
        imageUri = Uri.fromFile(photo);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, takePicture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);

        if(resultCode == Activity.RESULT_OK){
            Uri selectedImage = imageUri;
            getContentResolver().notifyChange(selectedImage, null);

            ImageView imageView = (ImageView)findViewById(R.id.image_camera);
            ContentResolver cr = getContentResolver();
            Bitmap bitmap;



            try{
                bitmap = MediaStore.Images.Media.getBitmap(cr, selectedImage);
                scaled = Bitmap.createScaledBitmap(bitmap, 4096, 2500, false);
                imageView.setRotation(90);
                imageView.setImageBitmap(scaled);
                Toast.makeText(CameraActivity.this, selectedImage.toString(), Toast.LENGTH_LONG).show();
                cameraButton.setText("Main");
                cameraButton.setOnClickListener(nextListener);
            }catch(Exception e){
                Log.e(logtag, e.toString());
            }
        }
    }
    public Bitmap getBitmap (){
        return scaled;

    }

}
