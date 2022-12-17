package com.example.pomotask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pomotask.ui.login.LoginActivity;
import com.google.android.gms.common.api.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class SignupActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mSignupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mNameEditText = findViewById(R.id.etUsername);
        mEmailEditText = findViewById(R.id.etEmail);
        mPasswordEditText = findViewById(R.id.etPassword);
        mSignupButton = findViewById(R.id.btnSignup);

        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEditText.getText().toString();
                String email = mEmailEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                // Validate the input
                if (name.isEmpty()) {
                    mNameEditText.setError("Name is required");
                    return;
                }
                if (email.isEmpty()) {
                    mEmailEditText.setError("Email is required");
                    return;
                }
                if (password.isEmpty()) {
                    mPasswordEditText.setError("Password is required");
                    return;
                }
                if (password.length() < 8) {
                    mPasswordEditText.setError("Password must be at least 8 characters long");
                    return;
                }

                // Create a JSON object to hold the user's signup information
                JSONObject signupData = new JSONObject();
                try {
                    signupData.put("name", name);
                    signupData.put("email", email);
                    signupData.put("password", password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Send the signup data to the server
//                sendSignupDataToServer(signupData);
            }
        });
    }

//    private void sendSignupDataToServer(JSONObject signupData) {
//        // Set up the request
//        String url = "https://example.com/api/signup";
//        StringRequest request = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Signup was successful
//                        // Navigate to the next activity or display a confirmation message
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // Signup failed
//                        // Display an error message
//                    }
//                }) {
//            @Override
//            public byte[] getBody() {
//                return signupData.toString().getBytes();
//            }
//
//            @Override
//            public Map<String, String> getHeaders() {
//                Map<String, String> headers = new HashMap<>();
//                headers.put("Content-Type", "application/json");
//                return headers;
//            }
//        };
//
//// Add the request to the RequestQueue
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);}
}
