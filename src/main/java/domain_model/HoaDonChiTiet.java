package domain_model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @Column(name="IdHoaDon")
    private String IdHoaDon;

    @Column(name="IdChiTietSP")
    private String IdChiTietSP;

    @Column(name="SoLuong")
    private Integer SoLuong;

    @Column(name="DonGia")
    private BigDecimal DonGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String idHoaDon, String idChiTietSP, Integer soLuong, BigDecimal donGia) {
        IdHoaDon = idHoaDon;
        IdChiTietSP = idChiTietSP;
        SoLuong = soLuong;
        DonGia = donGia;
    }

    public String getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        IdHoaDon = idHoaDon;
    }

    public String getIdChiTietSP() {
        return IdChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        IdChiTietSP = idChiTietSP;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer soLuong) {
        SoLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return DonGia;
    }

    public void setDonGia(BigDecimal donGia) {
        DonGia = donGia;
    }
}
