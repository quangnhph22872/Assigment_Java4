package repository;

import domain_model.ChiTietSP;
import domain_model.ChucVu;
import domain_model.KhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChiTietSP;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class  ChiTietSPRepository {
    private Session hSession;

    public ChiTietSPRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChiTietSP x)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(x);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSP x)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(x);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSP x)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(x);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<ChiTietSP> findAll() {
        String hql = "SELECT obj FROM ChiTietSP obj ";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        return query.getResultList();
    }

    public ChiTietSP findById(String id)
    {
        return this.hSession.find(ChiTietSP.class, id);
    }

    public ChiTietSP findByMa(String ma)
    {
        String hql = "SELECT obj FROM ChiTietSP obj WHERE obj.Id = ?1";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
