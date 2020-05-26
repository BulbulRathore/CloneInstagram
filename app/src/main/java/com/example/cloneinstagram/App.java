package com.example.cloneinstagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FL8GtgPFZUychzewLTfMkl1Rgz46A0HrVAPaiuPA")
                // if defined
                .clientKey("dHhxBkHM5QZu20Rcnm3vRWdofNuOlYzi2xIwwfV0")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
