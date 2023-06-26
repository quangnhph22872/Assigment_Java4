package view_model;

public class QLSanPham {
    private String Ma;
    private String Ten;

    public QLSanPham() {
    }

    public QLSanPham(String ma, String ten) {
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
