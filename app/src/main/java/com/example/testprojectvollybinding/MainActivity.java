package com.example.testprojectvollybinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.testprojectvollybinding.databinding.ActivityMainBinding;
import com.example.testprojectvollybinding.presenters.Presenter;
import com.example.testprojectvollybinding.remote.data.DataManager;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager = new DataManager(this);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void getJsonData() {
                showData("hi");
               dataManager.setVolleyRequest();

            }
        });
    }
    void showData(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        Log.i("hh",msg);
    }
}
