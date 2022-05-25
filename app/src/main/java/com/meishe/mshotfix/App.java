package com.meishe.mshotfix;

import android.app.Application;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.meishe.libpatch.MSFix;

import java.io.File;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MSFix.install(this,new File("/sdcard/patch.jar"));

        //dalvik.system.PathClassLoader
        ClassLoader mainActivityClassLoad = MainActivity.class.getClassLoader();
        //dalvik.system.PathClassLoader
        ClassLoader appCompatActivityClassLoader = AppCompatActivity.class.getClassLoader();
       // java.lang.BootClassLoader
        ClassLoader applicationClassLoader = Application.class.getClassLoader();
        //dalvik.system.PathClassLoader
        ClassLoader classLoader = getClassLoader();

        Log.d("lpf","mainActivityClassLoad="+mainActivityClassLoad);
        Log.d("lpf","appCompatActivityClassLoader="+appCompatActivityClassLoader);
        Log.d("lpf","applicationClassLoader="+applicationClassLoader);
        Log.d("lpf","classLoader="+classLoader);
    }
}
