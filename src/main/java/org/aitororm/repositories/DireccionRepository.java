package org.aitororm.repositories;

import org.aitororm.entities.Direccion;
import org.aitororm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class DireccionRepository implements Repository<Direccion> {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s = sf.openSession();
    @Override
    public Direccion create(Direccion direccion) {
        s.getTransaction().begin();
        s.persist(direccion);
        s.getTransaction().commit();
        return direccion;
    }

    @Override
    public Optional<Direccion> read(long id) {
        s.getTransaction().begin();
        Direccion direccion = s.get(Direccion.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(direccion);
    }

    @Override
    public List<Direccion> readAll() {
        s.getTransaction().begin();
        List<Direccion> direccion = s.createSelectionQuery("from Direccion ", Direccion.class).list();
        s.getTransaction().commit();
        return direccion;
    }

    @Override
    public Direccion update(Direccion direccion) {
        s.getTransaction().begin();
        s.merge(direccion);
        s.getTransaction().commit();
        return direccion;
    }

    @Override
    public void delete(Direccion direccion) {
        s.getTransaction().begin();
        s.remove(direccion);
        s.getTransaction().commit();
    }


    public void close() {
        sf.close();
        s.close();
    }
}
