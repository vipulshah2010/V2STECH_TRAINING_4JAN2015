package vipul.com.animations;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
   implements View.OnClickListener{

    private Button btnAlpha,btnRotate,btnTranslate,btnScale,btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlpha = (Button)findViewById(R.id.btnAlpha);
        btnRotate = (Button)findViewById(R.id.btnRotate);
        btnTranslate = (Button)findViewById(R.id.btnTranslate);
        btnScale = (Button)findViewById(R.id.btnScale);
        btnSet = (Button)findViewById(R.id.btnSet);

        btnAlpha.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnTranslate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAlpha:
                playAlphaAnimation();
                break;
            case R.id.btnRotate:
                playRotateAnimation();
                break;
            case R.id.btnTranslate:
                playTranslateAnimation();
                break;
            case R.id.btnScale:
                playScaleAnimation();
                break;
            case R.id.btnSet:
                playSetAnimation();
                break;
        }
    }

    private void playAlphaAnimation()
    {
        Animation alphaAnimation =
                AnimationUtils.
                        loadAnimation(this,
                  R.anim.alpha_animation);

        btnAlpha.startAnimation
                (alphaAnimation);
    }

    private void playRotateAnimation()
    {
        Animation rotateAnimation =
                AnimationUtils.
                        loadAnimation(this,
                                R.anim.rotate_animation);

        btnRotate.startAnimation
                (rotateAnimation);
    }

    private void playTranslateAnimation()
    {
        Animation translateAnimation =
                AnimationUtils.
                        loadAnimation(this,
                                R.anim.translate_animation);

        btnTranslate.startAnimation
                (translateAnimation);
    }


    private void playScaleAnimation()
    {
        Animation scaleAnimation =
                AnimationUtils.
                        loadAnimation(this,
                                R.anim.scale_animation);

        btnScale.startAnimation
                (scaleAnimation);
    }

    private void playSetAnimation()
    {
        Animation setAnimation =
                AnimationUtils.
                        loadAnimation(this,
                                R.anim.set_animation);

        btnSet.startAnimation(setAnimation);
    }


}
