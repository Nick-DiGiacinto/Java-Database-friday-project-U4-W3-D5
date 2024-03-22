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
        EntityManager em = emf.createEntityManager();
        System.out.println("Greetings everybody");
        Date date = new Date();
        CatalogDAO daoCatalog = new CatalogDAO(em);
        LoanDAO daoLoan = new LoanDAO(em);
        UserDAO daoUser = new UserDAO(em);
        Faker faker = new Faker();
        Random random = new Random();
        //Utilizzo il faker per testare e provare a creare gli users, i debiti, le riviste ed i libri

        //  *Users*
        for (int i = 0; i < 8; i++) {
            User user = new User(random.nextLong(1, 3000000000L), faker.lordOfTheRings().character(), faker.harryPotter().character(), faker.date().birthday());
            daoUser.save(user);
        }
        //  *loans*
        for (int i = 0; i < 8; i++) {
            Loan loan = new Loan(daoUser.findById(random.nextInt(1, 20)), daoCatalog.findById(random.nextInt(1, 10)), date, date, date);
            daoLoan.save(loan);
        }
        //  *Magazines*
        for (int i = 0; i < 8; i++) {
            Magazine magazine = new Magazine(Long.parseLong(faker.code().isbn13()), faker.book().title(), random.nextInt(1950, 2024), random.nextInt(1, 800), frequency.values()[random.nextInt(0, frequency.values().length)]);
            daoCatalog.save(magazine);
        }
        //  *books*
//            for (int i = 0; i < 8; i++) {
//            Book book = new Book(Long.parseLong(faker.code().isbn13()), faker.book().title(), random.nextInt(1950, 2024), random.nextInt(1, 800), faker.book().author(), faker.book().genre());
//            daoCatalog.save(book);
//        }

        //l'isbn da me utilizzati qui di seguito sono da considerarsi completamente inventati a scopo di prova
        // Per quanto riguarda l'autore ho inserito George R.R. Martin, l'autore della magistrale opera fantasy chiamata "A Song of ice and Fire", più nota al grande pubblico
        // con il titolo televisivo di Game of Thrones.
        daoCatalog.deleteCatalog(978170753);
        System.out.println(daoCatalog.findCatalog(238463312));
        System.out.println(daoCatalog.findCatalogYear(2011));
        System.out.println(daoCatalog.findCatalogAuthor("George R.R.Martin"));

// Questa è un'ipotesi di come potrebbe venire utilizzato uno scanner dalla nostra libreria digitale:
//        while (true) {
//            System.out.println("Welcome in this digital library, choose an option:");
//            System.out.println("1 -- Magazine");
//            System.out.println("2 -- Books");
//            System.out.println("3 - Esc");
//            Scanner scanner = new Scanner(System.in);
//            int selection = scanner.nextInt();
//            switch (selection) {
//                case 1:
//
//                    break;
//                case 2:

//                    break;
//                case 3:
//
//                    break;
//
//            }
//
//
//            System.out.println("1 - Search by ISBN");
//            System.out.println("2 - Add an element");
//            System.out.println("3 - Remove an element");
//            System.out.println("4 - Search by author");
//            System.out.println("5 - Search by year of publication");
//            System.out.println("6 - Search by title");
//            System.out.println("7 - Search all expired loans not returned");
//            System.out.println("8 - Search of loaned element by badge number");
//            System.out.println("9 - Esc");
//
//
//        }

        em.close();
    }
}
