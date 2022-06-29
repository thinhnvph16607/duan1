package com.bai.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import com.bai.duan1.adapter.TruyenTranhAdapter;
import com.bai.duan1.object.TruyenTranh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();
        truyenTranhArrayList.add(new TruyenTranh("Bắt Đầu Từ Cửu Đầu Điểu","Chapter 108","https://truyencapnhat.com/cdn/truyencapnhat/20210626/doc-truyen-tranh-bat-dau-tu-cuu-dau-dieu.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Quyển sổ báo thù","Chapter 61","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-quyen-so-bao-thu.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tu Tiên Giả Đại Chiến Siêu Năng Lực","Chapter 192","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-tu-tien-gia-dai-chien-sieu-nang-luc.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Vua Đảo Hải Tặc - One Piece","Chapter 1053","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-dao-hai-tac.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tây Du","Chapter 287","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-tay-du.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Ám Hành Ngự Sử","Chapter 156","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-am-hanh-ngu-su.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Anh Hùng Rác Rưởi","Chapter 115","https://truyencapnhat.com/cdn/truyencapnhat/20220109/doc-truyen-tranh-anh-hung-rac-ruoi.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Thú Thụ Bất Thân","Chapter 138","https://truyencapnhat.com/cdn/truyencapnhat/20210516/doc-truyen-tranh-thu-thu-bat-than.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Tôi Thăng Cấp Trong Lúc Ngủ","Chapter 33","https://truyencapnhat.com/cdn/truyencapnhat/20220320/doc-truyen-tranh-toi-thang-cap-trong-luc-ngu.jpg"));

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

}