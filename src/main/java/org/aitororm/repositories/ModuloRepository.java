package org.aitororm.repositories;

import org.aitororm.entities.Modulo;
import org.aitororm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ModuloRepository implements Repository<Modulo> {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s = sf.openSession();
    @Override
    public Modulo create(Modulo modulo) {
        s.getTransaction().begin();
        s.persist(modulo);
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public Optional<Modulo> read(long id) {
        s.getTransaction().begin();
        Modulo modulo = s.get(Modulo.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(modulo);
    }

    @Override
    public List<Modulo> readAll() {
        s.getTransaction().begin();
        List<Modulo> modulo = s.createSelectionQuery("from Modulo ", Modulo.class).list();
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public Modulo update(Modulo modulo) {
        s.getTransaction().begin();
        s.merge(modulo);
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public void delete(Modulo modulo) {
        s.getTransaction().begin();
        s.remove(modulo);
        s.getTransaction().commit();
    }

    public void close() {
        sf.close();
        s.close();
    }
}
