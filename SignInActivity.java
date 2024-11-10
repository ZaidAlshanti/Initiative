package com.app1.one;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);  // Ensure this matches your layout file name

        TextView loginText = findViewById(R.id.loginText);  // Make sure this ID is correct in the layout
        Button signupBtn = findViewById(R.id.signup_btn);   // Ensure this ID is correct too

        // Navigate to MainActivity when "Already have an account? Log in" is clicked
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Define sign-up button behavior if needed
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement sign-up functionality here if needed
            }
        });
    }
}
