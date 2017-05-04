package com.example.prabhusivanandam.volleystring;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    String URL="http://10.1.19.187/img_final.jpg";
    TextView tv;
    Button btn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        img=(ImageView)findViewById(R.id.im);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                ImageRequest request=new ImageRequest(URL, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        img.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_CENTER, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
                queue.add(request);
            }
        });
    }
}
