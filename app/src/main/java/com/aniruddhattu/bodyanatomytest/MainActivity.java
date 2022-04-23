package com.aniruddhattu.bodyanatomytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoViewAttacher;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;

public class MainActivity extends AppCompatActivity implements OnClickableAreaClickedListener {
    ImageMap mImageMap;
    ImageView ivFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFront = (ImageView) findViewById(R.id.ivFront);
        // find the image map in the view
        mImageMap = (ImageMap)findViewById(R.id.imBody);
        //mImageMap.setContext(MainActivity.this);
        mImageMap.setImageResource(R.drawable.image_map);

        // add a click handler to react when areas are tapped
        mImageMap.addOnImageMapClickedHandler(new ImageMap.OnImageMapClickedHandler()
        {

            @Override
            public void onImageMapClicked(String name, ImageMap imageMap) {
                Toast.makeText(MainActivity.this,"Clicked", Toast.LENGTH_LONG).show();
                mImageMap.showBubble(name);
                if(name.equalsIgnoreCase("Head")) {
                    ivFront.setImageResource(R.drawable.front_head);
                } else {
                    ivFront.setImageResource(R.drawable.front);
                }
            }

            @Override
            public void onBubbleClicked(int id)
            {
                // react to info bubble for area being tapped
            }
        });
    }

    @Override
    public void onClickableAreaTouched(Object item) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}