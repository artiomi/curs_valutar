package my.exam.curs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "ANGAJAT")
public class Angajat {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank
    private String nume;
    @NotBlank
    private String prenume;
    @JsonIgnore
    @OneToMany(mappedBy = "angajat")
    private Set<Numerar> operatiuni;

    public Angajat(long id) {
        this.id = id;
    }

    public Angajat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Set<Numerar> getOperatiuni() {
        return operatiuni;
    }

    public void setOperatiuni(Set<Numerar> operatiuni) {
        this.operatiuni = operatiuni;
    }


}
