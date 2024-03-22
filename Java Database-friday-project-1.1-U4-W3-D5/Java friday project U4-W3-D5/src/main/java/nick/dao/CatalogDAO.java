package nick.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import nick.entities.Catalog;

import java.util.List;

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

    public Catalog findById(int id) {
        Catalog catalog = em.find(Catalog.class, id);
        return catalog;
    }

    public List<Catalog> findCatalogAuthor(String author) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query findQueryAuthor = em.createQuery("SELECT d FROM Book d WHERE d.author = :author");
        findQueryAuthor.setParameter("author", author);
        List<Catalog> results = findQueryAuthor.getResultList();
        transaction.commit();
        System.out.println("Elements searched: " + results.size());
        return results;
    }

    public List<Catalog> findCatalogYear(int YEAR) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query findQueryYear = em.createQuery("SELECT c FROM Catalog c WHERE c.year_of_publication = :YEAR");
        findQueryYear.setParameter("YEAR", YEAR);
        List<Catalog> results = findQueryYear.getResultList();
        transaction.commit();
        System.out.println("Elements searched: " + results.size());
        return results;
    }

    public List<Catalog> findCatalog(long ISBN) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Query findQuery = em.createQuery("SELECT b FROM Catalog b WHERE b.isbn = :ISBN");
            findQuery.setParameter("ISBN", ISBN);
            List<Catalog> results = findQuery.getResultList();
            System.out.println("Elements searched: " + results.size());
            return results;
    }
    public void deleteCatalog(long ISBN) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query deleteQuery = em.createQuery("DELETE FROM Catalog a WHERE a.isbn = :ISBN");
        deleteQuery.setParameter("ISBN", ISBN);
        long deletedElements = deleteQuery.executeUpdate();
        transaction.commit();
        System.out.println("Elements canceled: " + deletedElements);
    }
}