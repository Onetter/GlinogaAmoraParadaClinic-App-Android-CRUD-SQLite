package info.codestart.glinogaprdrecrds;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView s_text;

    private static int splashTimeOut = 5000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);
        logo = (ImageView) findViewById(R.id.s_logo);
        s_text = (TextView) findViewById(R.id.s_text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splashanimation);
        Animation textanimation = AnimationUtils.loadAnimation(this,R.anim.splashtextanimation);
        logo.startAnimation(animation);
        s_text.startAnimation(textanimation);
    }
}
