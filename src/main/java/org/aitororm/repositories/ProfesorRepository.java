package org.aitororm.repositories;

import org.aitororm.entities.Profesor;
import org.aitororm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ProfesorRepository implements Repository<Profesor>{

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s = sf.openSession();
    @Override
    public Profesor create(Profesor profesor) {
        s.getTransaction().begin();
        s.persist(profesor);
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public Optional<Profesor> read(long id) {
        s.getTransaction().begin();
        Profesor profesor = s.get(Profesor.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(profesor);
    }

    @Override
    public List<Profesor> readAll() {
        s.getTransaction().begin();
        List<Profesor> profesor = s.createSelectionQuery("from Profesor ", Profesor.class).list();
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public Profesor update(Profesor profesor) {
        s.getTransaction().begin();
        s.merge(profesor);
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public void delete(Profesor profesor) {
        s.getTransaction().begin();
        s.remove(profesor);
        s.getTransaction().commit();
    }


    public void close() {
        sf.close();
        s.close();
    }
}
