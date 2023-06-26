package view_model;

public class QLNSX {
    private String Ma;
    private String Ten;

    public QLNSX() {
    }

    public QLNSX(String ma, String ten) {
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
