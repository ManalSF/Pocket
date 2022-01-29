package com.preethampm.bankingapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        EditText cinS = (EditText) findViewById(R.id.cin);
        EditText passwordS = (EditText) findViewById(R.id.password);

        progressDialog = new ProgressDialog(this);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(cinS.getText().toString())) {
                    cinS.setError("CIN is required");
                }
                if (TextUtils.isEmpty(passwordS.getText().toString())) {
                    passwordS.setError("Password is required");
                } else {
                    progressDialog.setMessage("login in progress");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    /*if (cinS.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                        //correct
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }*/
                    progressDialog.dismiss();

                }
                postDataUsingVolley(cinS.getText().toString(), passwordS.getText().toString());
            }
        });
    }
    private void postDataUsingVolley(final String cin, final String password) {
        // url to post our data
        String url = "http://localhost:9003/clients/auth";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                cin.setText("");
                password.setText("");

                // on below line we are displaying a success toast message.
                Toast.makeText(LoginActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                try {
                    // on below line we are passing our response
                    // to json object to extract data from it.
                    JSONObject respObj = new JSONObject(response);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(LoginActivity.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("CIN", cin);
                params.put("Password", password);

                // at last we are
                // returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }
}

