package domain_model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name="CuaHang")
public class CuaHang {
//    @Id
//    @Column(name="Id")
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID Id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private String Ten;

    @Column(name="DiaChi")
    private String DiaChi;

    @Column(name="ThanhPho")
    private String ThanhPho;

    @Column(name="QuocGia")
    private String QuocGia;

    @OneToMany(mappedBy = "cuaHang",fetch = FetchType.EAGER)
    private List<NhanVien> listNV;


    public CuaHang() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String thanhPho) {
        ThanhPho = thanhPho;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public List<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(List<NhanVien> listNV) {
        this.listNV = listNV;
    }
}
