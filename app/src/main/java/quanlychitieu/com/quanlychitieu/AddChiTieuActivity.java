package quanlychitieu.com.quanlychitieu;


import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import database.ChiTieu;
import database.DatabaseHandler;

/**
 * Created by Mouse on 5/4/2016.
 */
public class AddChiTieuActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView imgViewLuaChon;
    TextView txtLuaChon,txtCategoryLuaChon,txtDateChiTieu;
    Button btnOKLuaChon;
    EditText edtSoTienChi,edtGhiChu;
    DatabaseHandler db;
    Long seconds = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_moniter);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        db = new DatabaseHandler(getApplication());
        editor = preferences.edit();
        imgViewLuaChon = (ImageView) findViewById(R.id.imgViewLuaChon);
        txtLuaChon = (TextView) findViewById(R.id.txtLuaChon);
        txtCategoryLuaChon = (TextView)findViewById(R.id.txtCategoryLuaChon);
        edtSoTienChi = (EditText) findViewById(R.id.edtSoTienChi);
        edtGhiChu = (EditText) findViewById(R.id.edtGhiChu);

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int thang = c.get(Calendar.MONTH)+1;
        int nam = c.get(Calendar.YEAR);

        txtDateChiTieu = (TextView)findViewById(R.id.txtDateChiTieu);
        txtDateChiTieu.setText(thang+"/"+day+"/"+nam+"");
        //edtDate =
       // TextView txtThem = (TextView) findViewById(R.id.txtThemKhoanChi);
        LinearLayout layoutAddMoniter = (LinearLayout) findViewById(R.id.Selection);
        layoutAddMoniter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                Intent intentAddKhoanChi = new Intent(AddChiTieuActivity.this,SelecttionChiActivity.class);
//                startActivity(intentAddKhoanChi);
                final Dialog dialog = new Dialog(AddChiTieuActivity.this);
                dialog.setContentView(R.layout.add_item);
                LinearLayout au = (LinearLayout)dialog.findViewById(R.id.AU);
                au.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.an_uong));
                        txtLuaChon.setText(getResources().getString(R.string.an_uong));
                        txtCategoryLuaChon.setText("1");
                        dialog.dismiss();
                    }
                });
                LinearLayout dl1 = (LinearLayout)dialog.findViewById(R.id.DL1);
                dl1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.du_lich));
                        txtLuaChon.setText(getResources().getString(R.string.du_lich));
                        txtCategoryLuaChon.setText("2");
                        dialog.dismiss();
                    }
                });
                LinearLayout ms = (LinearLayout)dialog.findViewById(R.id.MS);
                ms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.shoppping));
                        txtLuaChon.setText(getResources().getString(R.string.mua_sam));
                        txtCategoryLuaChon.setText("3");
                        dialog.dismiss();
                    }
                });
                LinearLayout dl2 = (LinearLayout)dialog.findViewById(R.id.DL2);
                dl2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.di_lai));
                        txtLuaChon.setText(getResources().getString(R.string.di_lai));
                        txtCategoryLuaChon.setText("4");
                        dialog.dismiss();
                    }
                });
                LinearLayout ny = (LinearLayout)dialog.findViewById(R.id.NY);
                ny.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.nguoi_yeu));
                        txtLuaChon.setText(getResources().getString(R.string.nguoi_yeu));
                        txtCategoryLuaChon.setText("5");
                        dialog.dismiss();
                    }
                });
                LinearLayout gt = (LinearLayout)dialog.findViewById(R.id.GT);
                gt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.giai_tri));
                        txtLuaChon.setText(getResources().getString(R.string.giai_tri));
                        txtCategoryLuaChon.setText("6");
                        dialog.dismiss();
                    }
                });
                LinearLayout ht = (LinearLayout)dialog.findViewById(R.id.HT);
                ht.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.giao_duc));
                        txtLuaChon.setText(getResources().getString(R.string.hoc_tap));
                        txtCategoryLuaChon.setText("7");
                        dialog.dismiss();
                    }
                });
                LinearLayout sk = (LinearLayout)dialog.findViewById(R.id.SK);
                sk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.suc_khoe));
                        txtLuaChon.setText(getResources().getString(R.string.suc_khoe));
                        txtCategoryLuaChon.setText("8");
                        dialog.dismiss();
                    }
                });
                LinearLayout khac = (LinearLayout)dialog.findViewById(R.id.ChiTieuKhac);
                khac.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        imgViewLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.khac));
                        txtLuaChon.setText(getResources().getString(R.string.khac));
                        txtCategoryLuaChon.setText("9");
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        // chon ngay


        LinearLayout layoutDate = (LinearLayout)findViewById(R.id.layoutDateChiTieu);
        layoutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogDate = new Dialog(AddChiTieuActivity.this);
                dialogDate.setContentView(R.layout.date_chitieu);
                Button btnAddDate = (Button)dialogDate.findViewById(R.id.btnAddDate);
                final DatePicker datePickerChiTieu = (DatePicker)dialogDate.findViewById(R.id.datePickerChiTieu);

                btnAddDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Date date = new Date((datePickerChiTieu.getMonth() + 1) + "/" +datePickerChiTieu.getDayOfMonth() + "/" +  datePickerChiTieu.getYear());
                        seconds = date.getTime();
                        //Toast.makeText(getApplication(),seconds + "", Toast.LENGTH_SHORT).show();
                        txtDateChiTieu.setText(datePickerChiTieu.getDayOfMonth() + "-" + (datePickerChiTieu.getMonth() + 1) + "-" + datePickerChiTieu.getYear());
                        dialogDate.dismiss();
                    }
                });
                dialogDate.show();
            }
        });

        btnOKLuaChon = (Button) findViewById(R.id.btnOKLuaChon);
        btnOKLuaChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //long idInsert = 0;
                String strLuaChon = txtLuaChon.getText().toString();
                String strSoTien = edtSoTienChi.getText().toString();
                String strDateChi = txtDateChiTieu.getText().toString();

                if(strLuaChon.equalsIgnoreCase(getResources().getString(R.string.chon)) || (strSoTien.equalsIgnoreCase("")) || strDateChi.equalsIgnoreCase(getResources().getString(R.string.chon_ngay))) {
                    if (strLuaChon.equalsIgnoreCase(getResources().getString(R.string.chon))) {
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_chon_muc_chi), Toast.LENGTH_SHORT).show();
                    } else if (strSoTien.equalsIgnoreCase("")) {
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_nhap_tien), Toast.LENGTH_SHORT).show();
                    }
                    else if (strDateChi.equalsIgnoreCase(getResources().getString(R.string.chon_ngay))) {
                        Toast.makeText(getApplication(), getResources().getString(R.string.chua_chon_ngay), Toast.LENGTH_SHORT).show();
                    }


                }
                else {
                        if (txtCategoryLuaChon.getText().equals("1")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.an_uong), edtSoTienChi.getText().toString(),txtDateChiTieu.getText().toString(), edtGhiChu.getText().toString(), 0);
                             db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);


                        } else if (txtCategoryLuaChon.getText().equals("2")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.du_lich), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("3")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.mua_sam), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("4")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.di_lai), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("5")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.nguoi_yeu), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("6")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.giai_tri), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("7")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.hoc_tap), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("8")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.suc_khoe), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        } else if (txtCategoryLuaChon.getText().equals("9")) {
                            ChiTieu chiTieu = new ChiTieu(getResources().getString(R.string.khac), edtSoTienChi.getText().toString(), String.valueOf(seconds), edtGhiChu.getText().toString(), 0);
                            db.addChiTieu(chiTieu);
                            Toast.makeText(getApplication(),getResources().getString(R.string.them_thanh_cong), Toast.LENGTH_SHORT).show();
                            Intent intentQLThuChi = new Intent(AddChiTieuActivity.this, QuanLyChiTieuActivity.class);
                            startActivity(intentQLThuChi);
                        }
                    }
            }
        });



    }
}
