package com.foxdevelop.daniel.buttonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Create the variables to reference the "Views/Widgets" that we made in the layout

    private EditText userInput;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //We are now setting the variables for the views created above
        //by finding the views ID (by calling the Resource class)

        userInput = findViewById(R.id.userInput);
        Button button = findViewById(R.id.button);
        Button clearButton = findViewById(R.id.clearButton);
        textView = findViewById(R.id.textView);
        textView.setText("");
        textView.setMovementMethod(new ScrollingMovementMethod());

        //Creating the event handler "OnClickListener" which will listen for
        //when the button is clicked. We are also setting within the event handler,
        //what we would like to do in the program, when the button is clicked.
        //In this case it is taking the input from the userInput variable (edit text view)
        //and appending it to the textView widget.

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString();
                result = result + "\n";
                textView.append(result);
                Log.i("info","Message was shown.");
            }
        };

        View.OnClickListener clearButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput.setText("");
                textView.setText("");
            }
        };
            button.setOnClickListener(ourOnClickListener);
            clearButton.setOnClickListener(clearButtonListener);

    }

}
