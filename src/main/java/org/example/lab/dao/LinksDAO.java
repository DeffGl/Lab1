package org.example.lab.dao;

import org.example.lab.models.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LinksDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public LinksDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Link> showAllLinks(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select l from Link l", Link.class).getResultList();
    }
    @Transactional(readOnly = true)
    public Link show (int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Link.class, id);
    }
    @Transactional
    public void editSessionCounter(int id){
        Session session = sessionFactory.getCurrentSession();
        int sessionCounter = session.get(Link.class, id).getSessionCounter();
        Link link = session.get(Link.class, id);
        link.setSessionCounter(++sessionCounter);
        session.save(link);
    }
    @Transactional
    public void save(Link link){
        Session session = sessionFactory.getCurrentSession();
        session.save(link);
        int i = 0;

    }
    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Link.class,id));
    }

}
