package repository;

import domain_model.NSX;
import domain_model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLNSX;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NsxRepository {
    private Session hSession;

    public NsxRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(NSX nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(NSX nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(NSX nsx)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(nsx);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<NSX> findAll() {
        String hql = "SELECT obj FROM NSX obj ";
        TypedQuery<NSX> query = this.hSession.createQuery(hql, NSX.class);
        return query.getResultList();
    }

    public NSX findById(UUID id) {
        return this.hSession.find(NSX.class, id);
    }


    public NSX findByMa(String ma)
    {
        String hql = "SELECT obj FROM NSX obj WHERE obj.Ma = ?1";
        TypedQuery<NSX> query = this.hSession.createQuery(hql, NSX.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
