package com.Utis;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "spetsialnosti", uniqueConstraints = @UniqueConstraint(columnNames = "Nazvanie"))
public class Spetsialnosti {
    private List<Gruppyi> gruppyi;
    private Integer kodSpets;
    private String nazvanie;
    private Date dateFormir;
    private Date statusDate;

    public Spetsialnosti() {
    }

    public Spetsialnosti(Integer kodSpets, String nazvanie, List<Gruppyi> gruppyi) {
        this.kodSpets = kodSpets;
        this.nazvanie = nazvanie;
        this.gruppyi = gruppyi;
    }

    public Spetsialnosti(Integer kodSpets, String name, Date statusDate, List<Gruppyi> gruppyi) {
        this.kodSpets = kodSpets;
        this.nazvanie = name;
        this.statusDate = statusDate;
        this.gruppyi = gruppyi;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "KodSpets", unique = true, nullable = false)
    public Integer getKodSpets() {
        return this.kodSpets;
    }

    public void setKodSpets(Integer kodSpets) {
        this.kodSpets = kodSpets;
    }

    @Column(name = "Nazvanie", unique = true, nullable = false, length = 70)
    public String getNazvanie() {
        return this.nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DataFormir", length = 10)
    public Date getDateFormir() {
        return dateFormir;
    }

    public void setDateFormir(Date dateFormir) {
        this.dateFormir = dateFormir;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    public Date getStatusDate() {
        return this.statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "spetsialnosti")
    public List<Gruppyi> getGruppyi() {
        return this.gruppyi;
    }

    public void setGruppyi(List<Gruppyi> gruppyi) {
        this.gruppyi = gruppyi;
    }
}
