package my.exam.curs.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "NUMERAR")
public class Numerar {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "angajat_id")
    private Angajat angajat;

    @ManyToOne
    @JoinColumn(name = "valuta_id")
    private DictionarValute valuta;

    private double suma;
    private LocalDateTime dataOperatiunii;

    public Angajat getAngajat() {
        return angajat;
    }

    public void setAngajat(Angajat angajat) {
        this.angajat = angajat;
    }

    public DictionarValute getValuta() {
        return valuta;
    }

    public void setValuta(DictionarValute valuta) {
        this.valuta = valuta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public LocalDateTime getDataOperatiunii() {
        return dataOperatiunii;
    }

    public void setDataOperatiunii(LocalDateTime dataOperatiunii) {
        this.dataOperatiunii = dataOperatiunii;
    }
}
