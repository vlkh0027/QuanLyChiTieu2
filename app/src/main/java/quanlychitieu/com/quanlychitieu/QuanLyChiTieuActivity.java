package quanlychitieu.com.quanlychitieu;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import database.ChiTieu;
import database.DatabaseHandler;

/**
 * Created by lmtri on 5/4/2016.
 */
public class QuanLyChiTieuActivity extends AppCompatActivity{
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    LinearLayout layoutContainLyDoChiTieu;
    DatabaseHandler dbHandler;
    TextView txtSoTienThu;
    TextView TongTienChiTieuCuaThang;
    TextView txtTienThu,txtTongTienChiTieu ;
    int chooseMonth = 0;
    int month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlchitieu_layout);
        dbHandler = new DatabaseHandler(getApplication());
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();
        Calendar cal = Calendar.getInstance();
        month = cal.get(Calendar.MONTH) + 1;
        chooseMonth = month;
        txtTienThu = (TextView) findViewById(R.id.txtCurrTienThu);
        txtTienThu.setText("Tiền còn lại: "+preferences.getString("editPreferenceChi"+month,""));

        txtTongTienChiTieu = (TextView) findViewById(R.id.txtTongTienChiTieu);
        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi" + month,""));
        layoutContainLyDoChiTieu = (LinearLayout) findViewById(R.id.layoutContainLyDoChiTieu);

        txtSoTienThu = (TextView) findViewById(R.id.SoTienThu);
        TongTienChiTieuCuaThang = (TextView) findViewById(R.id.txtTongTienChiTieuCuaThang);

        Button btnItem = (Button) findViewById(R.id.btnAdd);
        btnItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplication(),"Hello World",Toast.LENGTH_SHORT).show();
                Intent intentAddChiTieu = new Intent(QuanLyChiTieuActivity.this, SelecttionThuChi.class);
                startActivity(intentAddChiTieu);
            }
        });
        // sua tien chi tieu
        final EditText edtSoTienChi = (EditText)findViewById(R.id.edtSoTienChi);
        txtTienThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentQLThuChi = new Intent(QuanLyChiTieuActivity.this, ThuChiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("month",chooseMonth);
                intentQLThuChi.putExtras(bundle);
                startActivity(intentQLThuChi);
            }
        });
        //xem chi tiet thang chi tieu
        final TextView txtChooseMonthChiTieu = (TextView) findViewById(R.id.txtChooseMonthChiTieu);
        txtChooseMonthChiTieu.setText("Tháng "+month);
        txtChooseMonthChiTieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentAddKhoanChi = new Intent(AddChiTieuActivity.this,SelecttionChiActivity.class);
//                startActivity(intentAddKhoanChi);
                final Dialog dialog = new Dialog(QuanLyChiTieuActivity.this);
                dialog.setContentView(R.layout.show_month);
                //xem thang 1
                LinearLayout xemThang1 = (LinearLayout)dialog.findViewById(R.id.xemThang1);
                xemThang1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =1;
                        chooseMonth = 1;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("1/1/" + currYear).getTime();
                        Long endTime = new Date("1/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi1",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi1",""));
                        txtChooseMonthChiTieu.setText("Tháng 1");
                        dialog.dismiss();
                    }
                });
                // xem thang 2
                LinearLayout xemThang2 = (LinearLayout)dialog.findViewById(R.id.xemThang2);
                xemThang2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =2;
                        chooseMonth = 2;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 28;
                        Long startTime = new Date("2/1/" + currYear).getTime();
                        Long endTime = new Date("2/28" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi2",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi2",""));
                        txtChooseMonthChiTieu.setText("Tháng 2");
                        dialog.dismiss();
                    }
                });
                // xem thang 3
                LinearLayout xemThang3 = (LinearLayout)dialog.findViewById(R.id.xemThang3);
                xemThang3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =3;
                        chooseMonth = 3;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("3/1/" + currYear).getTime();
                        Long endTime = new Date("3/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi3",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi3",""));
                        txtChooseMonthChiTieu.setText("Tháng 3");
                        dialog.dismiss();
                    }
                });
                //xem thang 4
                LinearLayout xemThang4 = (LinearLayout)dialog.findViewById(R.id.xemThang4);
                xemThang4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =4;
                        chooseMonth = 4;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 30;
                        Long startTime = new Date("4/1/" + currYear).getTime();
                        Long endTime = new Date("4/30" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi4",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi4",""));
                        txtChooseMonthChiTieu.setText("Tháng 4");
                        dialog.dismiss();
                    }
                });
                //xem thang 5
                LinearLayout xemThang5 = (LinearLayout)dialog.findViewById(R.id.xemThang5);
                xemThang5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =5;
                        chooseMonth = 5;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("5/1/" + currYear).getTime();
                        Long endTime = new Date("5/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi5",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi5",""));
                        txtChooseMonthChiTieu.setText("Tháng 5");
                        dialog.dismiss();
                    }
                });
                //xem thang 6
                LinearLayout xemThang6 = (LinearLayout)dialog.findViewById(R.id.xemThang6);
                xemThang6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =6;
                        chooseMonth = 6;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 30;
                        Long startTime = new Date("6/1/" + currYear).getTime();
                        Long endTime = new Date("6/30" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi6",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi6",""));
                        txtChooseMonthChiTieu.setText("Tháng 6");
                        dialog.dismiss();
                    }
                });
                //xem thang 7
                LinearLayout xemThang7 = (LinearLayout)dialog.findViewById(R.id.xemThang7);
                xemThang7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =7;
                        chooseMonth = 7;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("7/1/" + currYear).getTime();
                        Long endTime = new Date("7/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi7",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi7",""));
                        txtChooseMonthChiTieu.setText("Tháng 7");
                        dialog.dismiss();
                    }
                });
                //xem thang 8
                LinearLayout xemThang8 = (LinearLayout)dialog.findViewById(R.id.xemThang8);
                xemThang8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =8;
                        chooseMonth = 8;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("8/1/" + currYear).getTime();
                        Long endTime = new Date("8/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi8",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi8",""));
                        txtChooseMonthChiTieu.setText("Tháng 8");
                        dialog.dismiss();
                    }
                });
                //xem thang 9
                LinearLayout xemThang9 = (LinearLayout)dialog.findViewById(R.id.xemThang9);
                xemThang9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =9;
                        chooseMonth = 9;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 30;
                        Long startTime = new Date("9/1/" + currYear).getTime();
                        Long endTime = new Date("9/30" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi9",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi9",""));
                        txtChooseMonthChiTieu.setText("Tháng 9");
                        dialog.dismiss();
                    }
                });
                //xem thang 10
                LinearLayout xemThang10 = (LinearLayout)dialog.findViewById(R.id.xemThang10);
                xemThang10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =10;
                        chooseMonth = 10;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("10/1/" + currYear).getTime();
                        Long endTime = new Date("10/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi10",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi10",""));
                        txtChooseMonthChiTieu.setText("Tháng 10");
                        dialog.dismiss();
                    }
                });
                //xem thang 11
                LinearLayout xemThang11 = (LinearLayout)dialog.findViewById(R.id.xemThang11);
                xemThang11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =11;
                        chooseMonth = 11;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 30;
                        Long startTime = new Date("11/1/" + currYear).getTime();
                        Long endTime = new Date("11/30" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi11",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi11",""));
                        txtChooseMonthChiTieu.setText("Tháng 11");
                        dialog.dismiss();
                    }
                });
                //xem thang 12
                LinearLayout xemThang12 = (LinearLayout)dialog.findViewById(R.id.xemThang12);
                xemThang12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        month =12;
                        chooseMonth = 12;
                        Calendar calendar = Calendar.getInstance();
                        int currYear = calendar.get(Calendar.YEAR);
                        int lastDate = 31;
                        Long startTime = new Date("12/1/" + currYear).getTime();
                        Long endTime = new Date("12/31" +"/" + currYear).getTime();
                        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
                        addChiTieuToView(chiTieuList);
                        //txtTienThu.setText("Tiền còn lại : "+preferences.getString("editPreferenceChi12",""));
                        txtTongTienChiTieu.setText(preferences.getString("editPreferenceChi12",""));
                        txtChooseMonthChiTieu.setText("Tháng 12");
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
        int currMonth = calendar.get(Calendar.MONTH) + 1;
        int currYear = calendar.get(Calendar.YEAR);
        int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Long startTime = new Date(currMonth + "/1/" + currYear).getTime();
        Long endTime = new Date(currMonth + "/"+ lastDate +"/" + currYear).getTime();
        List<ChiTieu> chiTieuList = dbHandler.getAllChiTieu(String.valueOf(startTime),String.valueOf(endTime));
        addChiTieuToView(chiTieuList);

    }

    private void addChiTieuToView(List<ChiTieu> chiTieuList){
        layoutContainLyDoChiTieu.removeAllViews();

        //Toast.makeText(getApplication(),chiTieuList.size() + "",Toast.LENGTH_SHORT).show();
        if(chiTieuList != null) {
            String dateSqlLite = "";
            String strNgayChiTieu ="0";
            int tongTienTrongNgay = 0;
            int tongTienChiTrongThang =0;
            int tongTienTrongThang = 0;
            int tongTienThu =0;
            int tongTienTatCa = 0;
            int tongTienConLai = 0;
            TextView txtTongTienChiTieuTrongNgay = null;
            for (int i = 0; i < chiTieuList.size(); i++) {
                if(dateSqlLite.equalsIgnoreCase(chiTieuList.get(i).get_DATE())){
                    if(txtTongTienChiTieuTrongNgay != null) {
                        if(chiTieuList.get(i).get_THU() == 1){
                            txtTongTienChiTieuTrongNgay.setText((tongTienTrongNgay + Integer.parseInt(chiTieuList.get(i).get_MONEY())) + "");
                            tongTienTrongNgay = tongTienTrongNgay + Integer.parseInt(chiTieuList.get(i).get_MONEY());
                        }else{
                            txtTongTienChiTieuTrongNgay.setText((tongTienTrongNgay - Integer.parseInt(chiTieuList.get(i).get_MONEY())) + "");
                            tongTienTrongNgay = tongTienTrongNgay - Integer.parseInt(chiTieuList.get(i).get_MONEY());
                        }


                    }

                    View view = LayoutInflater.from(this).inflate(R.layout.chitieu_item, null);
                    TextView txtLyDoChiTieu = (TextView) view.findViewById(R.id.txtLyDoChiTieu);
                    TextView txtChuThichChiTieu = (TextView) view.findViewById(R.id.txtChuThichChiTieu);
                    TextView txtSoTienChiTieu = (TextView) view.findViewById(R.id.txtSoTienChiTieu);
                    TextView txtDateChiTieu = (TextView) view.findViewById(R.id.txtDateChiTieu);
                    ImageView imgViewKQLuaChon = (ImageView) view.findViewById(R.id.imgViewKQLuaChon);

                    txtLyDoChiTieu.setText(chiTieuList.get(i).get_NAME());
                    txtSoTienChiTieu.setText(chiTieuList.get(i).get_MONEY());
                    // txtDateChiTieu.setText(chiTieuList.get(i).get_DATE());
                    txtChuThichChiTieu.setText(chiTieuList.get(i).get_DESC());
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.an_uong))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.an_uong));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.du_lich))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.du_lich));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.mua_sam))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.shoppping));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.di_lai))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.di_lai));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.nguoi_yeu))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.nguoi_yeu));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.giai_tri))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.giai_tri));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.hoc_tap))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.giao_duc));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.suc_khoe))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.suc_khoe));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.khac))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.khac));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.tien_thuong))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.tien_thuong));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.ban_do))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.ban_do));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.thu_khac))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.thu_khac));
                    }
                    layoutContainLyDoChiTieu.addView(view, 1);
                }else{
                    dateSqlLite = chiTieuList.get(i).get_DATE();
                    View headerView = LayoutInflater.from(this).inflate(R.layout.header_chitieu, null);
                    TextView txtNgayChiTieu = (TextView) headerView.findViewById(R.id.txtNgayChiTieu);
                    TextView txtThuChiTieu = (TextView) headerView.findViewById(R.id.txtThuChiTieu);
                    TextView txtThangNamChiTieu = (TextView) headerView.findViewById(R.id.txtThangNamChiTieu);
                    txtTongTienChiTieuTrongNgay = (TextView) headerView.findViewById(R.id.txtTongTienChiTieuTrongNgay);
                    tongTienTrongNgay = 0;
                    if(chiTieuList.get(i).get_THU() == 1){
                        txtTongTienChiTieuTrongNgay.setText((tongTienTrongNgay + Integer.parseInt(chiTieuList.get(i).get_MONEY())) + "");
                        tongTienTrongNgay = tongTienTrongNgay + Integer.parseInt(chiTieuList.get(i).get_MONEY());
                    }else{
                        txtTongTienChiTieuTrongNgay.setText((tongTienTrongNgay - Integer.parseInt(chiTieuList.get(i).get_MONEY())) + "");
                        tongTienTrongNgay = tongTienTrongNgay - Integer.parseInt(chiTieuList.get(i).get_MONEY());
                    }
                    Long dateChiTieu = Long.parseLong(chiTieuList.get(i).get_DATE());
                    Date dateChiTieuConvert = new Date(dateChiTieu);
                    SimpleDateFormat formatter = new SimpleDateFormat("EEEE d MM-yyyy");
                    String dateString = formatter.format(dateChiTieuConvert);
                    String[] arrDateChiTieu = dateString.split(" ");
                    txtThangNamChiTieu.setText(arrDateChiTieu[3]);
                    String thu = arrDateChiTieu[0]+" "+arrDateChiTieu[1];
                    txtThuChiTieu.setText(thu);
                    txtNgayChiTieu.setText(arrDateChiTieu[2]);
                    strNgayChiTieu = txtNgayChiTieu.getText().toString();
                    //Toast.makeText(getApplication(),dateChiTieuConvert.getYear()+"",Toast.LENGTH_LONG).show();
                    layoutContainLyDoChiTieu.addView(headerView, 0);
                    txtTongTienChiTieuTrongNgay.setText(chiTieuList.get(i).get_MONEY());
                    View view = LayoutInflater.from(this).inflate(R.layout.chitieu_item, null);
                    TextView txtLyDoChiTieu = (TextView) view.findViewById(R.id.txtLyDoChiTieu);
                    TextView txtChuThichChiTieu = (TextView) view.findViewById(R.id.txtChuThichChiTieu);
                    TextView txtSoTienChiTieu = (TextView) view.findViewById(R.id.txtSoTienChiTieu);
                    TextView txtDateChiTieu = (TextView) view.findViewById(R.id.txtDateChiTieu);
                    ImageView imgViewKQLuaChon = (ImageView) view.findViewById(R.id.imgViewKQLuaChon);

                    txtLyDoChiTieu.setText(chiTieuList.get(i).get_NAME());
                    txtSoTienChiTieu.setText(chiTieuList.get(i).get_MONEY());
                    // txtDateChiTieu.setText(chiTieuList.get(i).get_DATE());
                    txtChuThichChiTieu.setText(chiTieuList.get(i).get_DESC());
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.an_uong))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.an_uong));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.du_lich))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.du_lich));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.mua_sam))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.shoppping));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.di_lai))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.di_lai));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.nguoi_yeu))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.nguoi_yeu));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.giai_tri))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.giai_tri));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.hoc_tap))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.giao_duc));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.suc_khoe))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.suc_khoe));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.khac))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.khac));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.tien_thuong))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.tien_thuong));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.ban_do))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.ban_do));
                    }
                    if (chiTieuList.get(i).get_NAME().equalsIgnoreCase(getResources().getString(R.string.thu_khac))) {
                        imgViewKQLuaChon.setImageDrawable(getResources().getDrawable(R.drawable.thu_khac));
                    }
                    layoutContainLyDoChiTieu.addView(view, 1);
                }
                if(chiTieuList.get(i).get_THU() == 0) {
                    TongTienChiTieuCuaThang.setText("- "+(tongTienChiTrongThang + Integer.parseInt(chiTieuList.get(i).get_MONEY())) + "");
                    //tongTienTatCa = tongTienTatCa + Integer.parseInt(chiTieuList.get(i).get_MONEY());
                    tongTienChiTrongThang = tongTienChiTrongThang + Integer.parseInt(chiTieuList.get(i).get_MONEY());
                }
                if(chiTieuList.get(i).get_THU() == 1){

                    tongTienThu = tongTienThu + Integer.parseInt(chiTieuList.get(i).get_MONEY());
                }
            }

            int TienBanDau = Integer.parseInt(preferences.getString("editPreferenceChi"+month,""));
            if(TienBanDau == 0)
            {
                tongTienConLai = 0;
            }else {
                tongTienConLai = TienBanDau - tongTienChiTrongThang + tongTienThu;
            }

            int mydate = Integer.parseInt(strNgayChiTieu.toString());
            if(mydate < 15){
                if(tongTienConLai < (TienBanDau/2)){
                    Toast.makeText(getApplication(),getResources().getString(R.string.nhac_nho),Toast.LENGTH_LONG).show();
                }
            }
            //Toast.makeText(getApplication(),mydate+"",Toast.LENGTH_LONG).show();
            String tienconlai =  "" + tongTienConLai;
            editor.commit();
            txtSoTienThu.setText("+ "+tongTienThu);
            txtTienThu.setText("Tiền còn lại : "+tienconlai);

        }
    }
}
