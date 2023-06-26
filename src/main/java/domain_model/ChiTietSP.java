package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
public class ChiTietSP {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String Id;

    @ManyToOne()
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id"
    )
    private SanPham sp;

    @ManyToOne()
    @JoinColumn(
            name = "IdNsx",
            referencedColumnName = "Id"
    )
    private NSX nsx;

    @ManyToOne()
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id"
    )
    private MauSac ms;

    @ManyToOne()
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id"
    )
    private DongSP dsp;

    @Column(name="NamBH")
    private String NamBH;
    @Column(name="MoTa")
    private String MoTa;
    @Column(name="SoLuongTon")
    private String SoLuongTon;
    @Column(name="GiaNhap")
    private String GiaNhap;
    @Column(name="GiaBan")
    private String GiaBan;


    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham sp, NSX nsx, MauSac ms, DongSP dsp, String namBH, String moTa, String soLuongTon, String giaNhap, String giaBan) {
        Id = id;
        this.sp = sp;
        this.nsx = nsx;
        this.ms = ms;
        this.dsp = dsp;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
    }

    public String getId() {
        return Id;
    }

    public void setId(String     id) {
        Id = id;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public DongSP getDsp() {
        return dsp;
    }

    public void setDsp(DongSP dsp) {
        this.dsp = dsp;
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

    public String getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(String soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        GiaNhap = giaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String giaBan) {
        GiaBan = giaBan;
    }
}
