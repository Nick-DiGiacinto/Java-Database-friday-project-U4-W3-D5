package nick.dao;

import jakarta.persistence.EntityManager;
import nick.entities.Catalog;
import jakarta.persistence.EntityTransaction;

public class CatalogDAO {
    private final EntityManager em;

    public CatalogDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalog catalog) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(catalog);
        tx.commit();
        System.out.println("The element has been saved in the catalog");
    }

    public Catalog findById(long isbn) {
        Catalog catalog = em.find(Catalog.class, isbn);
        return catalog;
    }
}