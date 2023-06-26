package view_model;

public class QLDongSP {
    private String Ma;
    private String Ten;

    public QLDongSP() {
    }

    public QLDongSP(String ma, String ten) {
        this.Ma = ma;
        this.Ten = ten;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        this.Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        this.Ten = ten;
    }
}
