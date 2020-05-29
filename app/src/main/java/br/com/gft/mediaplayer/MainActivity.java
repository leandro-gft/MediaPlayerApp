package br.com.gft.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.chromatica);

    }

    public void executarSom(View view){
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void pausarSom(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void pararSom(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.chromatica);
        }
    }
}
