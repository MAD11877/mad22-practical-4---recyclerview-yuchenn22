package com.example.app;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private User user1 = new User("Yuchen", "Boy", 1, true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = findViewById(R.id.displayname);
        username.setText(user1.name);
        TextView description = findViewById(R.id.displaydescription);
        description.setText(user1.description);
        Button followButton = findViewById(R.id.follow);
        Intent receivingEnd = getIntent();
        int message = receivingEnd.getIntExtra("value",1);
        username.setText(user1.name+ " " + message);
        if (user1.followed){
            followButton.setText("Unfollow");
        }
        followButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Pressed!");
                if (user1.followed){
                    followButton.setText("Follow");
                    user1.followed = false;
                    Toast.makeText(getApplicationContext(),"Unfollowed", Toast.LENGTH_SHORT).show();

                }
                else {
                    followButton.setText("Unfollow");
                    user1.followed = true;
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT)
                            .show();
                }
            }
    });
    }
}
