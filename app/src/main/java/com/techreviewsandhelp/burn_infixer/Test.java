package com.techreviewsandhelp.burn_infixer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Craig Bennett II on 6/15/2017.
 */

public class Test extends Activity {
    int counter = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burn_test);

        //Bright
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = 1.0f; // 0.0 - 1.0
        getWindow().setAttributes(lp);

        //ID
        final FrameLayout layout = (FrameLayout)findViewById(R.id.burnout);
        final Context c = this;
        final TextView textView = (TextView)findViewById(R.id.testtext);

        //Text button. This hides the text if the user taps that
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(TextView.GONE);
              }
            }
         );

        //Layout button
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (counter) {
                    case 0: {
                        //hide the text
                        textView.setVisibility(TextView.GONE);
                        //change color on tap
                        layout.setBackgroundColor(getResources().getColor(R.color.clearRed));
                        Toast.makeText(Test.this, "Look for green or blue pixels. Then tap the screen.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        layout.setBackgroundColor(getResources().getColor(R.color.clearGreen));
                        Toast.makeText(Test.this, "Look for red or blue pixels. Then tap the screen.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2: {
                        layout.setBackgroundColor(getResources().getColor(R.color.clearBlue));
                        Toast.makeText(Test.this, "Look for green or red pixels. Then tap the screen.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 3: {
                        layout.setBackgroundColor(getResources().getColor(android.R.color.white));
                        finish();
                        break;
                    }
                    case 4:{
                        textView.setVisibility(TextView.VISIBLE);
                        finish();
                        break;
                    }
                }
                counter++;
            }
        });

    }
    //Back Button
    final Context c = this;
    @Override
    public void onBackPressed() {
        startActivity(new Intent(c, MainActivity.class));
        finish();
    }

}
