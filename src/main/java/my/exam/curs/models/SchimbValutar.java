package my.exam.curs.models;

import javax.persistence.*;

@Entity
@Table(name = "SCHIMB_VALUTAR")
public class SchimbValutar {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "curs_id")
    private CursValutar curs;

    private int sumaPrimita;

    private double sumaElibirate;

    public SchimbValutar(CursValutar curs, int sumaPrimita, double sumaElibirate) {
        this.curs = curs;
        this.sumaPrimita = sumaPrimita;
        this.sumaElibirate = sumaElibirate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CursValutar getCurs() {
        return curs;
    }

    public void setCurs(CursValutar curs) {
        this.curs = curs;
    }

    public int getSumaPrimita() {
        return sumaPrimita;
    }

    public void setSumaPrimita(int sumaPrimita) {
        this.sumaPrimita = sumaPrimita;
    }

    public double getSumaElibirate() {
        return sumaElibirate;
    }

    public void setSumaElibirate(double sumaElibirate) {
        this.sumaElibirate = sumaElibirate;
    }


}
