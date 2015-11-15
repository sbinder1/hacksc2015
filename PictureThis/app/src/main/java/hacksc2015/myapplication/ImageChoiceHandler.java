package hacksc2015.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Drew on 11/14/2015.
 */
public class ImageChoiceHandler {
    private int random;
    private String adjectives[] = {"red", "orange", "yellow","green", "blue", "purple", "azure"};
    private int key = (int)(Math.random()*adjectives.length);
    //param should just be the word   this
    public ImageChoiceHandler(final AppCompatActivity appCompatActivity, String adj){ //essentially onCreate()


        random = (int)(Math.random()*4);

        String buttons[] = new String[4];

        for(int ii = 0; ii<4; ii++) {
            if(key+1>=adjectives.length) {
                key = 0;
            }

            if(!adjectives[key].equals(adj)) {
                buttons[ii]=adjectives[key];
            }
            else {
                buttons[ii]=adjectives[++key];
            }

            key++;
        }



        Button button1 = (Button) appCompatActivity.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //code for when button is pressed
                if(random == 0) {
                    Snackbar.make(view, "Correct", Snackbar.LENGTH_LONG).show();
                }
                else Snackbar.make(view, "Wrong", Snackbar.LENGTH_LONG).show();

            }
        });

        Button button2 = (Button) appCompatActivity.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //code for when button is pressed
                if(random == 1) {
                    Snackbar.make(view, "Correct", Snackbar.LENGTH_LONG).show();
                }
                else Snackbar.make(view, "Wrong", Snackbar.LENGTH_LONG).show();
            }
        });

        Button button3 = (Button) appCompatActivity.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //code for when button is pressed
                if(random == 2) {
                    Snackbar.make(view, "Correct", Snackbar.LENGTH_LONG).show();
                }
                else Snackbar.make(view, "Wrong", Snackbar.LENGTH_LONG).show();
            }
        });

        Button button4 = (Button) appCompatActivity.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //code for when button is pressed
                if(random == 3) {
                    Snackbar.make(view, "Correct", Snackbar.LENGTH_LONG).show();
                }
                else Snackbar.make(view, "Wrong", Snackbar.LENGTH_LONG).show();
            }
        });

        switch (random){
            case 0: button1.setText(adj);
                button2.setText(buttons[1]);
                button3.setText(buttons[2]);
                button4.setText(buttons[3]);
                break;
            case 1: button2.setText(adj);
                button1.setText(buttons[1]);
                button3.setText(buttons[2]);
                button4.setText(buttons[3]);
                break;
            case 2: button3.setText(adj);
                button2.setText(buttons[1]);
                button1.setText(buttons[2]);
                button4.setText(buttons[3]);
                break;
            case 3: button4.setText(adj);
                button2.setText(buttons[1]);
                button3.setText(buttons[2]);
                button1.setText(buttons[3]);
                break;
        }

    }

}