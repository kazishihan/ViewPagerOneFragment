package com.kazishihan.viewpagerprac;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view1 =inflater.inflate(R.layout.fragment_blank, container, false);

        TextView click = view1.findViewById(R.id.withoutFrame_editableText);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s ="";

            }
        });


//        try {
//            FileOutputStream output = new FileOutputStream(Environment.getExternalStorageDirectory() + "/file.png");
//            viewToBitmap(view).compress(Bitmap.CompressFormat.PNG, 100, output);
//            output.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        return view1;
    }

    public static void saveFrameLayout(FrameLayout frameLayout, String path) {
       // frameLayout.setDrawingCacheEnabled(true);
      //  frameLayout.buildDrawingCache();
        Bitmap cache = frameLayout.getDrawingCache();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            cache.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            frameLayout.destroyDrawingCache();
        }
    }


}
