package nick.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "badge_number")
    private long badgenumber;
    @Column(name="name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name="date_of_birth")
    private Date date_of_birth;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans;

    public User(long badgenumber, String name, String surname, Date date_of_birth) {
        this.badgenumber = badgenumber;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
    }

    public long getBadgenumber() {
        return badgenumber;
    }
    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
