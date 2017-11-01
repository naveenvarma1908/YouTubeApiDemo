package nis.com.youtubeapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Naveen Varma on 1/11/2017.
 */


public class MainActivity extends YouTubeBaseActivity{


    //Global Declaration of widgets.

    YouTubePlayerView youTubePlayerView;
    Button button;

    //YouTube Player Listener
    YouTubePlayer.OnInitializedListener onInitializedListen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Connected layout to the class is activity_main in res->Layout
        setContentView(R.layout.activity_main);

        //Connecting Button & YouTubePlayerView Widget with its view ID
        button = (Button)findViewById(R.id.bn);

        youTubePlayerView = (YouTubePlayerView)findViewById(R.id.YoutubeplayerView);


        //Event Handling for YouTubePlayer

        onInitializedListen = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //Selected Video to be played in YOUTUBE PLAYER VIEW
                youTubePlayer.loadVideo("EAr-iL2iCYQ");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Initilizing API KEY of your GMAIL and LISTENER.

                youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListen);
            }
        });

    }
}
