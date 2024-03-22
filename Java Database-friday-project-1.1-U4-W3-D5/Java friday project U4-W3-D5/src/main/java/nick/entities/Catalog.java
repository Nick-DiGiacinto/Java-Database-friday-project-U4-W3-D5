package nick.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalog")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Catalog {
    @Id
    private long isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "year_of_publication")
    private int year_of_publication;
    @Column(name = "page_number")
    private int page_number;
    @OneToOne(mappedBy = "loaned_element")
    private Loan loan;

    public Catalog(long isbn, String title, int year_of_publication, int page_number) {
        this.isbn = isbn;
        this.title = title;
        this.year_of_publication = year_of_publication;
        this.page_number = page_number;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", year_of_publication=" + year_of_publication +
                ", page_number=" + page_number +
                ", loan=" + loan +
                '}';
    }
}
