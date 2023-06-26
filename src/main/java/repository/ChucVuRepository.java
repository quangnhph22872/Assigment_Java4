package repository;

import domain_model.ChucVu;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.*;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hSession;



    public ChucVuRepository(){this.hSession = HibernateUtil.getFACTORY().openSession(); }

    public void insert(ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try  {
            transaction.begin();
            this.hSession.persist(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChucVu cv)
    {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(cv);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public List<ChucVu> findAll() {
        String hql = "SELECT obj FROM ChucVu obj ";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        return query.getResultList();
    }

    public ChucVu findById(UUID id) {
        return this.hSession.find(ChucVu.class, id);
    }

    public ChucVu getName(String ten) {
        ChucVu cv = new ChucVu();
        try  {
            Query query = hSession.createQuery("FROM ChucVu WHERE ten=:ten", ChucVu.class);
            query.setParameter("ten", ten);
            cv = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cv;
    }

    public ChucVu findByMa(String ma)
    {
        String hql = "SELECT obj FROM ChucVu obj WHERE obj.Ma = ?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql, ChucVu.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }


}
