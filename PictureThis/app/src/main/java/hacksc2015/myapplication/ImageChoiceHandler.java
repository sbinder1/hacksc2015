package hacksc2015.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Drew on 11/14/2015.
 */
public class ImageChoiceHandler {

    //param should just be the word   this
    public ImageChoiceHandler(final AppCompatActivity appCompatActivity){ //essentially onCreate()


        Button button1 = (Button) appCompatActivity.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //set the image to a new image
                //int the future use an array of images?
                ImageView imageView = (ImageView) appCompatActivity.findViewById(R.id.imageView);
                imageView.setImageResource(R.drawable.giraffe);

                //code for when button is pressed
                Snackbar.make(view, "Correct!", Snackbar.LENGTH_LONG).show();

            }
        });

        Button button2 = (Button) appCompatActivity.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //code for when button is pressed
                Snackbar.make(view, "Wrong!", Snackbar.LENGTH_LONG).show();
            }
        });

        Button button3 = (Button) appCompatActivity.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //code for when button is pressed
                Snackbar.make(view, "Wrong!", Snackbar.LENGTH_LONG).show();
            }
        });

        Button button4 = (Button) appCompatActivity.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //code for when button is pressed
                Snackbar.make(view, "Wrong!", Snackbar.LENGTH_LONG).show();
            }
        });

    }

}
