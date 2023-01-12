package org.aitororm.repositories;

import org.aitororm.entities.Alumno;
import org.aitororm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class AlumnoRepository implements Repository<Alumno> {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s = sf.openSession();
    @Override
    public Alumno create(Alumno alumno) {
        s.getTransaction().begin();
        s.persist(alumno);
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public Optional<Alumno> read(long id) {
        s.getTransaction().begin();
        Alumno alumno = s.get(Alumno.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(alumno);
    }

    @Override
    public List<Alumno> readAll() {
        s.getTransaction().begin();
        List<Alumno> alumno = s.createSelectionQuery("from Alumno ", Alumno.class).list();
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public Alumno update(Alumno alumno) {
        s.getTransaction().begin();
        s.merge(alumno);
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public void delete(Alumno alumno) {
        s.getTransaction().begin();
        s.remove(alumno);
        s.getTransaction().commit();
    }


    public void close() {
        sf.close();
        s.close();
    }
}
