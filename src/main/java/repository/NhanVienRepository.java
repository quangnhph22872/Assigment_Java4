package repository;


import domain_model.NSX;
import domain_model.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLNhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }



    public void insert(NhanVien x) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.persist(x);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void  update(NhanVien x)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            hSession.merge(x);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }



    public void delete(NhanVien x)
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

    public List<NhanVien> findAll() {
        String hql = "SELECT obj FROM NhanVien obj ";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        return query.getResultList();
    }

    public NhanVien findById(String id){
        return this.hSession.find(NhanVien.class,id);

    }





    public NhanVien login(String Ma, String MatKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv WHERE nv.ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, Ma);
        query.setParameter(2, MatKhau);
        try {
            NhanVien nv = query.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVien findByMa(String ma){
        String hql = "SELECT obj FROM NhanVien obj WHERE obj.ma = ?1 ";
        TypedQuery<NhanVien> query = this.hSession.createQuery(hql, NhanVien.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }

}
