package nick.entities;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book extends Catalog {
    @Column(name="author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @ManyToOne
    @JoinColumn(name="catalog_isbn")
    private Catalog catalog;

    public Book(long isbn, String title, int year_of_publishing, int page_number, String author, String genre, Catalog catalog) {
        super(isbn, title, year_of_publishing, page_number);
        this.author = author;
        this.genre = genre;
        this.catalog = catalog;
    }
    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + getTitle() +
                '}';
    }

}
