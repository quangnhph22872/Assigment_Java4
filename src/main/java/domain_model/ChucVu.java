package domain_model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString

@Entity
@Table(name="ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name="Ma")
    private String Ma;

    @Column(name="Ten")
    private  String Ten;

    @OneToMany(
            mappedBy = "cv",
            fetch = FetchType.LAZY
    )
    private List<NhanVien> listNv;

    public ChucVu() {
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

    public List<NhanVien> getListNv() {
        return listNv;
    }

    public void setListNv(List<NhanVien> listNv) {
        this.listNv = listNv;
    }
}
