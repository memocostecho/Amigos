package com.amigos;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by leonelmendez on 27/09/14.
 */
public class AmigosApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(getApplicationContext(),getString(R.string.parse_app_id),getString(R.string.parse_client_key));
        ParseFacebookUtils.initialize(getString(R.string.facebook_id));
    }
}
