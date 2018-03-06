package com.dailyart.uknownapplication;

import android.animation.ValueAnimator;
import android.media.Image;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText emailEditText;
    private TextInputEditText pwdEditText;
    private ImageView companyLogo;

    private float companyLogoHeight;
    private boolean companyLogoExtended = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyLogo = (ImageView)findViewById(R.id.company_logo);

        emailEditText = (TextInputEditText) findViewById(R.id.email_edit_text);
        pwdEditText = (TextInputEditText) findViewById(R.id.pwd_edit_text);

        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && companyLogoExtended) {
                    shrink();
                }
            }
        });

        pwdEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b && companyLogoExtended) {
                    shrink();
                }
            }
        });
    }


    public void shrink(){
        companyLogoHeight = companyLogo.getHeight();
        ValueAnimator shrinkAnimator = ValueAnimator.ofFloat(companyLogoHeight, 0);
        shrinkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float)valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = companyLogo.getLayoutParams();
                layoutParams.height = (int) value;
                layoutParams.width = (int) value;
                companyLogo.setLayoutParams(layoutParams);
            }
        });

        shrinkAnimator.setDuration(500);
        shrinkAnimator.setTarget(companyLogo);
        shrinkAnimator.start();

        companyLogoExtended = false;
        
    }



}
