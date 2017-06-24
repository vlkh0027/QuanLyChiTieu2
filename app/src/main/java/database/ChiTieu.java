package database;

/**
 * Created by Mouse on 5/7/2016.
 */
public class ChiTieu {
    int _ID;
    String _NAME;
    String _MONEY;
    String _DATE;
    String _DESC;
    int _THU;
    // Empty constructor
    public ChiTieu(){

    }
    // constructor
    public ChiTieu(int _ID, String _NAME, String _MONEY,String _DATE, String _DESC,int _THU){
        this._ID = _ID;
        this._NAME = _NAME;
        this._MONEY = _MONEY;
        this._DATE = _DATE;
        this._DESC = _DESC;
        this._THU = _THU;
    }

    public ChiTieu(String _NAME, String _MONEY,String _DATE, String _DESC, int _THU){
        this._NAME = _NAME;
        this._MONEY = _MONEY;
        this._DATE = _DATE;
        this._DESC = _DESC;
        this._THU = _THU;
    }

    public String get_DESC() {
        return _DESC;
    }

    public void set_DESC(String _DESC) {
        this._DESC = _DESC;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String get_NAME() {
        return _NAME;
    }

    public void set_NAME(String _NAME) {
        this._NAME = _NAME;
    }

    public String get_MONEY() {
        return _MONEY;
    }

    public void set_MONEY(String _MONEY) {
        this._MONEY = _MONEY;
    }

    public String get_DATE() {
        return _DATE;
    }

    public void set_DATE(String _DATE) {
        this._DATE = _DATE;
    }

    public int get_THU() {
        return _THU;
    }

    public void set_THU(int _THU) {
        this._THU = _THU;
    }
}
