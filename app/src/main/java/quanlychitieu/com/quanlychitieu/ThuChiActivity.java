package quanlychitieu.com.quanlychitieu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by lmtri on 5/4/2016.
 */
public class ThuChiActivity extends AppCompatActivity{
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.thuchi_layout);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        Button btnContinueChi = (Button)findViewById(R.id.btnContinueChi);
        final EditText edtSoTienChi = (EditText)findViewById(R.id.edtSoTienChi);
        TextView txtNhapTienChiTrongThang = (TextView)findViewById(R.id.txtNhapTienChiTrongThang);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        if(bundle == null){
            Calendar cal = Calendar.getInstance();
            int month = cal.get(Calendar.MONTH) + 1;

            txtNhapTienChiTrongThang.setText(getResources().getString(R.string.nhapTienChiTrongThang) + " " + month + " :");
            btnContinueChi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textInEdt = edtSoTienChi.getText().toString();
                    if(textInEdt.equalsIgnoreCase("")){
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_nhap_tien_chi), Toast.LENGTH_SHORT).show();
                    }else{
                        Calendar cal = Calendar.getInstance();
                        int month = cal.get(Calendar.MONTH) + 1;
                        editor.putString("editPreferenceChi" +month, textInEdt);
                        editor.commit();
                        Intent intentQLThuChi = new Intent(ThuChiActivity.this, QuanLyChiTieuActivity.class);
                        startActivity(intentQLThuChi);

                    }
                }
            });
        }else{
            txtNhapTienChiTrongThang.setText(getResources().getString(R.string.nhapTienChiTrongThang) + " " + bundle.getInt("month") + " :");
            btnContinueChi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textInEdt = edtSoTienChi.getText().toString();
                    if(textInEdt.equalsIgnoreCase("")){
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_nhap_tien_chi), Toast.LENGTH_SHORT).show();
                    }else{
                        Calendar cal = Calendar.getInstance();
                        int month = bundle.getInt("month");
                        editor.putString("editPreferenceChi" +month, textInEdt);
                        editor.commit();
                        Intent intentQLThuChi = new Intent(ThuChiActivity.this, QuanLyChiTieuActivity.class);
                        startActivity(intentQLThuChi);

                    }
                }
            });
        }

    }
}
