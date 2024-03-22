package nick.entities;

import jakarta.persistence.*;

@Entity
@Table(name="magazine")
public class Magazine extends Catalog {
    @Column(name="frequency")
    private frequency frequency;

    @ManyToOne
    @JoinColumn(name = "catalog_isbn")
    private Catalog catalog;

    public Magazine(long isbn, String title, int year_of_publication, int number_page, frequency frequency) {
        super(isbn, title, year_of_publication, number_page);
        this.frequency = frequency;
    }

    public frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(frequency frequency) {
        this.frequency = frequency;
    }
}
