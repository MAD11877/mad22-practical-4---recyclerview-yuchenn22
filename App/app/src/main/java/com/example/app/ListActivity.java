package com.example.app;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Attributes;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView imageviewbutton = findViewById(R.id.LogoLayout);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        Random rand = new Random();
        int int_random = rand.nextInt(10);
        ArrayList<String> name=new ArrayList<>();
        ArrayList<String> description=new ArrayList<>();
        for(int i=0;i<20;i++){
            Random random = new Random();
            int intRandom = random.nextInt();
            Random random2 = new Random();
            int intRandom2=random2.nextInt();
            name.add("Name"+intRandom);
            description.add("Description"+intRandom2);
        }
        RecyclerView rv = findViewById(R.id.RecyclerView);
        ListActivityAdapter adapter =  new ListActivityAdapter(name,description,ListActivity.this);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
        imageviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Pressed!");

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("View", new
                        DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent activityName = new Intent(ListActivity.this,MainActivity.class);
                                Random rand = new Random();
                                int randomint = rand.nextInt(100000);
                                activityName.putExtra("value", randomint);
                                startActivity(activityName);
                            }
                        });
                builder.setNegativeButton("Close", new
                        DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                            }
                        });
                AlertDialog dialog
                        = builder.create();
                dialog.show();
            }
        });
    }
}