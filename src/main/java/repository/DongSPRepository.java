package repository;


import domain_model.DongSP;
import domain_model.KhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.*;
import utils.HibernateUtil;
import view_model.QLDongSP;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    private Session hSession;

    public DongSPRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(DongSP sp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }

    }

    public void update(DongSP sp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(DongSP sp)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(sp);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<DongSP> findAll() {
        String hql = "SELECT obj FROM DongSP obj ";
        TypedQuery<DongSP> query = this.hSession.createQuery(hql, DongSP.class);
        return query.getResultList();
    }

    public DongSP findById(UUID id) {
        return this.hSession.find(DongSP.class, id);
    }

    public DongSP findByMa(String ma)
    {
        String hql = "SELECT obj FROM DongSP obj WHERE obj.Ma = ?1";
        TypedQuery<DongSP> query = this.hSession.createQuery(hql, DongSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
