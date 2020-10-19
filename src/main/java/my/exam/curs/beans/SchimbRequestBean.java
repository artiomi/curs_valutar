package my.exam.curs.beans;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class SchimbRequestBean {
    @NotBlank
    private String codValuta;
    private double cursSchimb;
    private int sumaPrimita;
    private double sumaElibirata;
    private LocalDate dataCurs = LocalDate.now();

    public LocalDate getDataCurs() {
        return dataCurs;
    }

    public void setDataCurs(LocalDate dataCurs) {
        this.dataCurs = dataCurs;
    }

    public String getCodValuta() {
        return codValuta;
    }

    public void setCodValuta(String codValuta) {
        this.codValuta = codValuta.toUpperCase();
    }

    public double getCursSchimb() {
        return cursSchimb;
    }

    public void setCursSchimb(double cursSchimb) {
        this.cursSchimb = cursSchimb;
    }

    public int getSumaPrimita() {
        return sumaPrimita;
    }

    public void setSumaPrimita(int sumaPrimita) {
        this.sumaPrimita = sumaPrimita;
    }

    public double getSumaElibirata() {
        return sumaElibirata;
    }

    public void setSumaElibirata(double sumaElibirata) {
        this.sumaElibirata = sumaElibirata;
    }
}
