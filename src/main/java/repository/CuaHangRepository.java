package repository;


import domain_model.CuaHang;
import domain_model.SanPham;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLCuaHang;
import view_model.QLKhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hSession;


    public CuaHangRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(CuaHang ch)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(CuaHang ch)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(CuaHang ch)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ch);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<CuaHang> findAll() {
        String hql = "SELECT obj FROM CuaHang obj ";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql, CuaHang.class);
        return query.getResultList();
    }

    public CuaHang findById(UUID id) {
        return this.hSession.find(CuaHang.class, id);
    }

    public CuaHang findByMa(String ma)
    {
        String hql = "SELECT obj FROM CuaHang obj WHERE obj.Ma = ?1";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql, CuaHang.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
    public CuaHang getName(String ten) {
        CuaHang cuaHang = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang WHERE ten=:ten", CuaHang.class);
            query.setParameter("ten", ten);
            cuaHang = (CuaHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }
}
