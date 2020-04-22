package com.example.portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyOptionmenuTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_optionmenu); //res 메뉴폴더 참고 ,style.xml 에서 액션바 설정가능

        //ActionBar abar = getSupportActionBar();
        //abar.hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curid = item.getItemId();
        switch (curid) {
            case R.id.menu_refresh:
                Toast.makeText(this,"새로고침 메뉴 클릭됨.",Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_search :
                Toast.makeText(this, "검색 메뉴 클릭됨.",Toast.LENGTH_LONG).show();
                break;
            case  R.id.menu_settings :
                Toast.makeText(this, "설정 메뉴 클릭",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
