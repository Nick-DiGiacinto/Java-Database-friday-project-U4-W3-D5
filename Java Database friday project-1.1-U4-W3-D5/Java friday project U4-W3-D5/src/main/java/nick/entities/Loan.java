package nick.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="loan")
public class Loan {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_badge_number")
    private User user;
    @ManyToOne
    @JoinColumn(name = "catalog_isbn")
    private Catalog catalog;
    @Column(name = "loan_start_date")
    private Date loanstartdate;
    @Column(name = "limit_return_date")
    private Date returndatelimit;
    @Column(name="effective_return_date")
    private Date effectivereturndate;

    public Loan(User user, Catalog catalog, Date loanstartdate, Date returndatelimit, Date effectivereturndate) {
        this.user = user;
        this.catalog = catalog;
        this.loanstartdate = loanstartdate;
        this.returndatelimit = returndatelimit;
        this.effectivereturndate = effectivereturndate;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Date getDatainizioloan() {
        return loanstartdate;
    }

    public void setDatainizioloan(Date loanstartdate) {
        this.loanstartdate = loanstartdate;
    }

    public Date getReturndatelimit() {
        return returndatelimit;
    }

    public void setReturndatelimit(Date returndatelimit) {
        this.returndatelimit = returndatelimit;
    }

    public Date getEffectivereturndate() {
        return effectivereturndate;
    }

    public void setEffectivereturndate(Date effectivereturndate) {
        this.effectivereturndate = effectivereturndate;
    }
}
