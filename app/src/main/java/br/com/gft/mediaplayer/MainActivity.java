package br.com.gft.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.chromatica);
        inicializarSeekbar();
    }

    private void inicializarSeekbar(){
        seekVolume = findViewById(R.id.seekBar);

        //configura o audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);  //recupera serviço de audio

        //recupera valores de volume máximo e atual
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //configura os valores maximos para seekbar
        seekVolume.setMax(volumeMaximo);

        //configura o progresso atual do seekbar
        seekVolume.setProgress(volumeAtual);

        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
