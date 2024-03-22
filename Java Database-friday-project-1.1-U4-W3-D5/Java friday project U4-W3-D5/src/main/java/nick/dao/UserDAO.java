package nick.dao;

import jakarta.persistence.EntityManager;
import nick.entities.User;
import jakarta.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }
    public User findById(long badgenumber) {
        User user = em.find(User.class, badgenumber);
        return user;
    }

    public void save(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        System.out.println("User saved successfully");
    }

}
