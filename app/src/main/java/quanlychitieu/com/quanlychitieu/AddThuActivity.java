package quanlychitieu.com.quanlychitieu;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import database.ChiTieu;
import database.DatabaseHandler;

/**
 * Created by Mouse on 5/9/2016.
 */
public class AddThuActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor1;
    ImageView imgViewLuaChonThu;
    TextView txtLuaChonThu, txtCategoryLuaChonThu, txtDateThu;
    Button btnOKLuaChonThu;
    EditText edtSoTienThu, edtGhiChuThu;
    DatabaseHandler db;
    Long seconds = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thu_moniter);
        db = new DatabaseHandler(getApplication());
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // editor1 = preferences.edit();
        imgViewLuaChonThu = (ImageView) findViewById(R.id.imgViewLuaChonThu);
        txtLuaChonThu = (TextView) findViewById(R.id.txtLuaChonThu);
        txtCategoryLuaChonThu = (TextView) findViewById(R.id.txtCategoryLuaChonThu);
        edtSoTienThu = (EditText) findViewById(R.id.edtSoTienThu);
        edtGhiChuThu = (EditText) findViewById(R.id.edtGhiChuThu);
        txtDateThu = (TextView) findViewById(R.id.txtDateThu);
        LinearLayout layoutThuMoniter = (LinearLayout) findViewById(R.id.SelectionThu);
        layoutThuMoniter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                final Dialog dialog = new Dialog(AddThuActivity.this);
                dialog.setContentView(R.layout.thu_item);
                //show lua chon
                LinearLayout tt = (LinearLayout) dialog.findViewById(R.id.TT);
                tt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imgViewLuaChonThu.setImageDrawable(getResources().getDrawable(R.drawable.tien_thuong));
                        txtLuaChonThu.setText(getResources().getString(R.string.tien_thuong));
                        txtCategoryLuaChonThu.setText("1");
                        dialog.dismiss();
                    }
                });
                //ban do
                LinearLayout bd = (LinearLayout) dialog.findViewById(R.id.BD);
                bd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imgViewLuaChonThu.setImageDrawable(getResources().getDrawable(R.drawable.ban_do));
                        txtLuaChonThu.setText(getResources().getString(R.string.ban_do));
                        txtCategoryLuaChonThu.setText("2");
                        dialog.dismiss();
                    }
                });
                //thu khac
                LinearLayout thukhac = (LinearLayout) dialog.findViewById(R.id.ThuKhac);
                thukhac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        imgViewLuaChonThu.setImageDrawable(getResources().getDrawable(R.drawable.thu_khac));
                        txtLuaChonThu.setText(getResources().getString(R.string.thu_khac));
                        txtCategoryLuaChonThu.setText("3");
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        LinearLayout layoutDateThu = (LinearLayout) findViewById(R.id.layoutDateThu);
        layoutDateThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogDateThu = new Dialog(AddThuActivity.this);
                dialogDateThu.setContentView(R.layout.date_chitieu);
                Button btnAddDateThu = (Button) dialogDateThu.findViewById(R.id.btnAddDate);
                final DatePicker datePickerChiTieu = (DatePicker) dialogDateThu.findViewById(R.id.datePickerChiTieu);

                btnAddDateThu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Date date = new Date((datePickerChiTieu.getMonth() + 1) + "/" + datePickerChiTieu.getDayOfMonth() + "/" + datePickerChiTieu.getYear());
                        seconds = date.getTime();
                        //Toast.makeText(getApplication(),seconds + "", Toast.LENGTH_SHORT).show();
                        txtDateThu.setText(datePickerChiTieu.getDayOfMonth() + "-" + (datePickerChiTieu.getMonth() + 1) + "-" + datePickerChiTieu.getYear());
                        dialogDateThu.dismiss();
                    }
                });
                dialogDateThu.show();
            }
        });
        btnOKLuaChonThu = (Button) findViewById(R.id.btnOKLuaChonThu);
        btnOKLuaChonThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long idInsertThu = 0;
                String strLuaChonThu = txtLuaChonThu.getText().toString();
                String strSoTienThu = edtSoTienThu.getText().toString();
                String strDateThu = txtDateThu.getText().toString();
                if(strLuaChonThu.equalsIgnoreCase(getResources().getString(R.string.chon)) || (strSoTienThu.equalsIgnoreCase("")) || strDateThu.equalsIgnoreCase(getResources().getString(R.string.chon_ngay))) {
                    if (strLuaChonThu.equalsIgnoreCase(getResources().getString(R.string.chon))) {
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_chon_muc_thu), Toast.LENGTH_SHORT).show();
                    } else if (strSoTienThu.equalsIgnoreCase("")) {
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_nhap_tien), Toast.LENGTH_SHORT).show();
                    }
                    else if (strDateThu.equalsIgnoreCase(getResources().getString(R.string.chon_ngay))) {
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_chon_ngay_thu), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    if (txtCategoryLuaChonThu.getText().equals("1")) {
                        ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.tien_thuong), edtSoTienThu.getText().toString(), String.valueOf(seconds), edtGhiChuThu.getText().toString(), 1);
                         db.addChiTieu(chiTieu);
                        Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                        Intent intentQLThuChi = new Intent(AddThuActivity.this, QuanLyChiTieuActivity.class);
                        startActivity(intentQLThuChi);

                        //Toast.makeText(getApplication(),"" + idInsertThu, Toast.LENGTH_SHORT).show();
                    } else if (txtCategoryLuaChonThu.getText().equals("2")) {
                        ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.tien_thuong), edtSoTienThu.getText().toString(), String.valueOf(seconds), edtGhiChuThu.getText().toString(), 1);
                         db.addChiTieu(chiTieu);
                        Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                        Intent intentQLThuChi = new Intent(AddThuActivity.this, QuanLyChiTieuActivity.class);
                        startActivity(intentQLThuChi);

                    } else if (txtCategoryLuaChonThu.getText().equals("3")) {
                        ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.tien_thuong), edtSoTienThu.getText().toString(), String.valueOf(seconds), edtGhiChuThu.getText().toString(), 1);
                      db.addChiTieu(chiTieu);
                        Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                        Intent intentQLThuChi = new Intent(AddThuActivity.this, QuanLyChiTieuActivity.class);
                        startActivity(intentQLThuChi);
                    }
                }

            }
        });
    }
}

