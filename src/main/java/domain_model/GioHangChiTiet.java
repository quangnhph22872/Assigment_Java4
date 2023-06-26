package domain_model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="GioHangChiTiet")
public class GioHangChiTiet {
    @Id
    @Column(name="Id")
    private String IdGioHang;

    @Column(name="IdChiTietSP")
    private String IdChiTietSP;

    @Column(name="SoLuong")
    private Integer SoLong;

    @Column(name="DonGia")
    private BigDecimal DonGia;

    @Column(name="DonGiaKhiGiam")
    private BigDecimal DonGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(String idGioHang, String idChiTietSP, Integer soLong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        IdGioHang = idGioHang;
        IdChiTietSP = idChiTietSP;
        SoLong = soLong;
        DonGia = donGia;
        DonGiaKhiGiam = donGiaKhiGiam;
    }

    public String getIdGioHang() {
        return IdGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        IdGioHang = idGioHang;
    }

    public String getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        IdChiTietSP = idChiTietSP;
    }

    public Integer getSoLong() {
        return SoLong;
    }

    public void setSoLong(Integer soLong) {
        SoLong = soLong;
    }

    public BigDecimal getDonGia() {
        return DonGia;
    }

    public void setDonGia(BigDecimal donGia) {
        DonGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return DonGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        DonGiaKhiGiam = donGiaKhiGiam;
    }
}
