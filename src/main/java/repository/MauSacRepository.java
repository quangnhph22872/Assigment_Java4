package repository;

import domain_model.MauSac;
import domain_model.SanPham;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    private Session hSession;

    public MauSacRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(MauSac ms)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ms);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<MauSac> findAll() {
        String hql = "SELECT obj FROM MauSac obj ";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();
    }

    public MauSac findById(UUID id) {
        return this.hSession.find(MauSac.class, id);
    }

    public MauSac findByMa(String ma)
    {
        String hql = "SELECT obj FROM MauSac obj WHERE obj.Ma = ?1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
}
