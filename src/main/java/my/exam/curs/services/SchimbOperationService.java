package my.exam.curs.services;

import my.exam.curs.beans.SchimbRequestBean;
import my.exam.curs.models.CursValutar;
import my.exam.curs.models.SchimbValutar;
import my.exam.curs.repositories.CursValutarRepository;
import my.exam.curs.repositories.SchimbValutarRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class SchimbOperationService {

    private final SchimbValutarRepository schimbValueRepository;

    private final CursValutarRepository cursValutarRepository;

    public SchimbOperationService(SchimbValutarRepository schimbValueRepository, CursValutarRepository cursValutarRepository) {
        this.schimbValueRepository = schimbValueRepository;
        this.cursValutarRepository = cursValutarRepository;
    }

    public SchimbValutar registerExchangeOperation(SchimbRequestBean schimbBean) {
        CursValutar cursValutar = cursValutarRepository.findByValutaAndCursAndDataCurs(schimbBean.getCodValuta(), schimbBean.getCursSchimb(), schimbBean.getDataCurs());
        if (cursValutar == null) {
            throw new ValidationException(String.format("Curs pentru valuta %s cu rata de schimb %f si data %s nu a fost gasit.", schimbBean.getCodValuta(), schimbBean.getCursSchimb(), schimbBean.getDataCurs()));
        }
        validateSumaElibirata(schimbBean, cursValutar);
        SchimbValutar schimb = schimbValueRepository.save(new SchimbValutar(cursValutar, schimbBean.getSumaPrimita(), schimbBean.getSumaElibirata()));
        return schimb;
    }

    private void validateSumaElibirata(SchimbRequestBean schimbBean, CursValutar cursValutar) {
        double sumaElibirata = schimbBean.getSumaElibirata();
        int sumaPrimita = schimbBean.getSumaPrimita();

        double sumaCalculata = Math.round(sumaPrimita * cursValutar.getCurs() / (double) cursValutar.getRata());
        if (sumaCalculata != sumaElibirata) {
            throw new ValidationException(String.format("Suma schimbata este incorecta pentru curs: %f si rata: %d", cursValutar.getCurs(), cursValutar.getRata()));
        }
    }
}
