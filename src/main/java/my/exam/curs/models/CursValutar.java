package my.exam.curs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "CURS_VALUTAR", uniqueConstraints = {@UniqueConstraint(name = "curs_valuta_data", columnNames = {"valuta_id", "dataCurs"})})
public class CursValutar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "valuta_id")
    private DictionarValute valuta;

    private int rata = 1;

    private double curs;

    @JsonIgnore
    @OneToMany(mappedBy = "curs")
    private Set<SchimbValutar> schimburiValutare;

    private LocalDate dataCurs = LocalDate.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DictionarValute getValuta() {
        return valuta;
    }

    public void setValuta(DictionarValute valuta) {
        this.valuta = valuta;
    }

    public int getRata() {
        return rata;
    }

    public void setRata(int rata) {
        this.rata = rata;
    }

    public double getCurs() {
        return curs;
    }

    public void setCurs(double curs) {
        this.curs = curs;
    }


    public Set<SchimbValutar> getSchimburiValutare() {
        return schimburiValutare;
    }

    public void setSchimburiValutare(Set<SchimbValutar> schimburiValutare) {
        this.schimburiValutare = schimburiValutare;
    }

    public LocalDate getDataCurs() {
        return dataCurs;
    }

    public void setDataCurs(LocalDate dataCurs) {
        this.dataCurs = dataCurs;
    }
}
