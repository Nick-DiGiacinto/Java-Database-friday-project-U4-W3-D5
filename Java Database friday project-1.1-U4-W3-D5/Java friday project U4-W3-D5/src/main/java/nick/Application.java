package nick;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.Random;
import nick.dao.CatalogDAO;
import nick.dao.LoanDAO;
import nick.dao.UserDAO;
import nick.entities.*;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-database");
    public static void main(String[] args) {
        System.out.println("Loading...");
        EntityManager em = emf.createEntityManager();
        System.out.println("Greetings everybody");
        Date date = new Date();
        CatalogDAO daoCatalog = new CatalogDAO(em);
        UserDAO daoUser = new UserDAO(em);
        LoanDAO daoLoan = new LoanDAO(em);
        Faker faker = new Faker();
        Random random = new Random();
        //Utilizzo il faker per creare gli users, i debiti, le riviste ed i libri

        //  *Users*
        for (int i = 0; i < 10; i++) {
            User user = new User(random.nextLong(1, 300000000L), faker.lordOfTheRings().character(), faker.harryPotter().character(), faker.date().birthday());
            daoUser.save(user);
        }
        //  *loans*
        for (int i = 0; i < 10; i++) {
            Loan loan = new Loan(daoUser.findById(random.nextInt(1, 20)), daoCatalog.findById(random.nextInt(1, 10)), date, date, date);
            daoLoan.save(loan);
        }
        //  *Magazines*
        for (int i = 0; i < 10; i++) {
            Magazine magazine = new Magazine(Long.parseLong(faker.code().isbn13()), faker.book().title(), random.nextInt(1950, 2024), random.nextInt(1, 800), frequency.values()[random.nextInt(0, frequency.values().length)]);
            daoCatalog.save(magazine);
        }
        //  *books*
        for (int i = 0; i < 10; i++) {
            Book book = new Book(Long.parseLong(faker.code().isbn13()), faker.book().title(), random.nextInt(1990, 2024), random.nextInt(1, 800), faker.book().author(), faker.book().genre());
            daoCatalog.save(book);
        }

        em.close();
    }
}
