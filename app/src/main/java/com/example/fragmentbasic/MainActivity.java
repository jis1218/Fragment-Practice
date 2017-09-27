package com.example.fragmentbasic;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import layout.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.CallBack{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();



        // fragment Managaer



    }

    public void initFragment(){
        FragmentManager manager = getSupportFragmentManager();
        // 2. transaction 처리자
        manager.beginTransaction(); //프래그먼트를 시작하기 위한 transaction을 시작
        FragmentTransaction transaction = manager.beginTransaction();
        // 3. 액티비티 레이아웃에 프래그먼트 부착
        Log.d("Activity", "===============before add()");
        transaction.add(R.id.container, new ListFragment());
        Log.d("Activity", "===============after add()");
        // 4. 커밋해서 완료
        transaction.commit();
    }
    @Override
    public void goDetail(){
        FragmentManager manager = getSupportFragmentManager();
        // 2. transaction 처리자
        manager.beginTransaction(); //프래그먼트를 시작하기 위한 transaction을 시작
        FragmentTransaction transaction = manager.beginTransaction();
        // 3. 액티비티 레이아웃에 프래그먼트 부착
        Log.d("Activity", "===============before add()");
        transaction.add(R.id.container, new DetailFragment());
        Log.d("Activity", "===============after add()");
        // 4. 커밋해서 완료
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity", "===============onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity", "===============onResume()");
    }
}
