package quanlychitieu.com.quanlychitieu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mouse on 5/9/2016.
 */
public class SelecttionThuChi extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luachon_thuchi);
        //chi
        TextView gotoChi = (TextView) findViewById(R.id.BamDeChi);
        gotoChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intChi = new Intent(SelecttionThuChi.this,AddChiTieuActivity.class);
                startActivity(intChi);
            }
        });
        // thu
        TextView gotoThu = (TextView) findViewById(R.id.BamDeThu);
        gotoThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intThu = new Intent(SelecttionThuChi.this,AddThuActivity.class);
                startActivity(intThu);
            }
        });
        //xem thong ke
        TextView gotoThongKe = (TextView) findViewById(R.id.BamDeXemThongKe);
        gotoThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intXemThangThongKe = new Intent(SelecttionThuChi.this,ShowMonthThongKe.class);
                startActivity(intXemThangThongKe);
            }
        });
    }
}
