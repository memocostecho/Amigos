package com.amigos;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActionBar().hide();


        Button loginButton = (Button)findViewById(R.id.facebook_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initFacebookLogin();
            }
        });

        ParseUser currentUser = ParseUser.getCurrentUser();
        if ((currentUser != null) && ParseFacebookUtils.isLinked(currentUser)) {
            Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.finishAuthentication(requestCode,resultCode,data);
    }

    private void initFacebookLogin(){
            final  ProgressDialog progressDialog = ProgressDialog.show(
                    LoginActivity.this, "", "Logging in...", true);

            List<String> permissions = Arrays.asList("public_profile","email");

            ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {


                @Override
                public void done(ParseUser user, ParseException err) {

                    if (user == null) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_SHORT).show();

                    } else if (user.isNew()) {
                        progressDialog.dismiss();

                        Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(homeIntent);
                        finish();
                    } else {
                        progressDialog.dismiss();
                        Intent homeIntent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(homeIntent);
                        finish();
                    }
                }
            });

    }


}
