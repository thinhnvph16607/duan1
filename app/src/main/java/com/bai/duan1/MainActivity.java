package com.bai.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.bai.duan1.adapter.TruyenTranhAdapter;
import com.bai.duan1.api.ApiLayTruyen;
import com.bai.duan1.interfaces.LayTruyenVe;
import com.bai.duan1.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {
GridView gdvDSTruyen;
TruyenTranhAdapter adapter;
ArrayList<TruyenTranh> truyenTranhArrayList;
EditText edtTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();


        adapter = new TruyenTranhAdapter(this, 0 , truyenTranhArrayList);
    }
    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString();
                adapter.sortTruyen(s);

            }
        });
    }

    @Override
    public void batDau() {
        Toast.makeText(this,"Đang Lấy Về",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            truyenTranhArrayList.clear();
            JSONArray arr = new JSONArray(data);
            for (int i=0;i<arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                truyenTranhArrayList.add( new TruyenTranh(o));
            }
            adapter = new TruyenTranhAdapter(this, 0 , truyenTranhArrayList);
            gdvDSTruyen.setAdapter(adapter);
        }catch (JSONException e){

        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this,"Lỗi Kết Nối",Toast.LENGTH_SHORT).show();
    }

    public void updata(View view) {
        new ApiLayTruyen(this).execute();
    }
}