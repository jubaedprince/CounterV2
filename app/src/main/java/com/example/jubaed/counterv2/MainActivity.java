package com.example.jubaed.counterv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedPreferences;
    TextView outputView;
    Button incrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = (Button) findViewById(R.id.incrementButton);
        outputView = (TextView) findViewById(R.id.outputView);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String v= sharedPreferences.getString("value", "0");
        outputView.setText(v);
    }

    public void increment(View view){
        String v = Integer.parseInt(outputView.getText().toString())+1+"";
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value", v);
        editor.commit();
        outputView.setText(v);
    }
}
