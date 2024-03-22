package nick.dao;

import jakarta.persistence.EntityManager;
import nick.entities.Loan;
import jakarta.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }
    public Loan findById(long id) {
        Loan loan = em.find(Loan.class, id);
        return loan;
    }

    public void save(Loan loan) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(loan);
        tx.commit();
        System.out.println("Loan saved successfully");
    }

}
