package my.exam.curs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "DICTIONAR_VALUTE")
public class DictionarValute {

    @Id
    private String valuta;
    @JsonIgnore
    @OneToMany(mappedBy = "valuta")
    private Set<CursValutar> cursuriValutare;

    @JsonIgnore
    @OneToMany(mappedBy = "valuta")
    private Set<Numerar> numear;

    public DictionarValute(String valuta) {
        this.valuta = valuta;
    }

    public DictionarValute() {
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Set<CursValutar> getCursuriValutare() {
        return cursuriValutare;
    }

    public void setCursuriValutare(Set<CursValutar> cursuriValutare) {
        this.cursuriValutare = cursuriValutare;
    }

    public Set<Numerar> getNumear() {
        return numear;
    }

    public void setNumear(Set<Numerar> numear) {
        this.numear = numear;
    }
}
