package view_model;

import java.math.BigDecimal;

public class QLChiTietSP {
    private String Ma;
    private String IdSP;
    private String IdNsx;
    private String IdMauSac;
    private String IdDongSP;
    private String NamBH;
    private String MoTa;
    private int SoLuongTon;
    private double GiaNhap;
    private double GiaBan;

    public QLChiTietSP() {
    }

    public QLChiTietSP(String Ma, String idSP, String idNsx, String idMauSac, String idDongSP, String namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.Ma = Ma;
        IdSP = idSP;
        IdNsx = idNsx;
        IdMauSac = idMauSac;
        IdDongSP = idDongSP;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
    }

    public String getMMa() {
        return Ma;
    }

    public void setMMa(String MMa) {
        this.Ma = MMa;
    }

    public String getIdSP() {
        return IdSP;
    }

    public void setIdSP(String idSP) {
        IdSP = idSP;
    }

    public String getIdNsx() {
        return IdNsx;
    }

    public void setIdNsx(String idNsx) {
        IdNsx = idNsx;
    }

    public String getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        IdMauSac = idMauSac;
    }

    public String getIdDongSP() {
        return IdDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        IdDongSP = idDongSP;
    }

    public String getNamBH() {
        return NamBH;
    }

    public void setNamBH(String namBH) {
        NamBH = namBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        GiaNhap = giaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double giaBan) {
        GiaBan = giaBan;
    }
}
