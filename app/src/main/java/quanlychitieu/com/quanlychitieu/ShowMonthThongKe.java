package quanlychitieu.com.quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Mouse on 5/13/2016.
 */
public class ShowMonthThongKe extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_monththongke);
        LinearLayout xemThongKe1 = (LinearLayout) findViewById(R.id.xemThongKe1);
        xemThongKe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intThongKe = new Intent(ShowMonthThongKe.this,ShowThongKeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("loai",1);
                intThongKe.putExtras(bundle);
                startActivity(intThongKe);
            }
        });

        LinearLayout xemThongKe2 = (LinearLayout) findViewById(R.id.xemThongKe2);
        xemThongKe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intThongKe = new Intent(ShowMonthThongKe.this,ShowThongKeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("loai",2);
                intThongKe.putExtras(bundle);
                startActivity(intThongKe);
            }
        });


        LinearLayout xemThongKe3 = (LinearLayout) findViewById(R.id.xemThongKe3);
        xemThongKe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intThongKe = new Intent(ShowMonthThongKe.this,ShowThongKeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("loai",3);
                intThongKe.putExtras(bundle);
                startActivity(intThongKe);
            }
        });

        LinearLayout xemThongKe4 = (LinearLayout) findViewById(R.id.xemThongKe4);
        xemThongKe4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intThongKe = new Intent(ShowMonthThongKe.this,ShowThongKeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("loai",4);
                intThongKe.putExtras(bundle);
                startActivity(intThongKe);
            }
        });
    }
}
