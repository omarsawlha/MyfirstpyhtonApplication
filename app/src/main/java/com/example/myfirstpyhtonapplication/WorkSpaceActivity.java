package com.example.myfirstpyhtonapplication;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class WorkSpaceActivity extends AppCompatActivity {

    private EditText editText;
    private TextToSpeech textToSpeech;
    private SeekBar mSeekBarPitch;
    private SeekBar  mSeekBarSpeed;
    private Button mButtonSpeak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //to hide header
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.workspace);
        mButtonSpeak= findViewById(R.id.button_speak);
        editText = findViewById(R.id.editText);

        // to initialize and set make the engine speak in english
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                textToSpeech.setLanguage(Locale.getDefault());
                textToSpeech.setSpeechRate((float)0.5);
            }
        });
        editText= findViewById(R.id.editText);
        mSeekBarPitch=findViewById(R.id.seek_bar_pitch);
        mSeekBarSpeed=findViewById(R.id.seek_bar_speed);
        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();

            }
        });

    }
    // function to speak when press the speak button
    private  void speak(){
        String text = editText.getText().toString();
        float pitch = (float) mSeekBarPitch.getProgress() / 50 ;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) mSeekBarSpeed.getProgress() / 50 ;
        if (speed < 0.1) speed = 0.1f;
        textToSpeech.setPitch(pitch);
        textToSpeech.setSpeechRate(speed);
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }

    // to make the engine stop and shutdown when it finish process
    @Override
    protected void onDestroy() {
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
    // make a request api with device when we write the text inside editText as a string value and send it to the TTS
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void TextTospeechButton(View view){
        textToSpeech.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH,null , null);
    }

}