package quanlychitieu.com.quanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Mouse on 5/6/2016.
 */
public class SelecttionChiActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        LinearLayout layoutAU = (LinearLayout) findViewById(R.id.AU);
        layoutAU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddMoniter = new Intent(SelecttionChiActivity.this,AddChiTieuActivity.class);
                startActivity(intentAddMoniter);
            }
        });
    }
}
