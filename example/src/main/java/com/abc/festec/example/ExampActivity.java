package com.abc.festec.example;

import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.abc.latte.activitys.ProxyActivity;
import com.abc.latte.delegate.LetteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

public class ExampActivity extends AppCompatActivity {

  /*  @Override
    public LetteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }*/



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.e("setContentView", "setContentView: ");
        setContentView(R.layout.activity_main);
    }
}
