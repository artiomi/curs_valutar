package my.exam.curs.controlers;

import my.exam.curs.beans.SchimbRequestBean;
import my.exam.curs.models.CursValutar;
import my.exam.curs.models.Numerar;
import my.exam.curs.models.SchimbValutar;
import my.exam.curs.repositories.CursValutarRepository;
import my.exam.curs.repositories.NumerarRepoitory;
import my.exam.curs.services.SchimbOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/schimb")
public class SchimbValutarController {

    private final CursValutarRepository cursValutarRepository;
    private final SchimbOperationService schimbOperationService;
    private final NumerarRepoitory numerarRepoitory;

    public SchimbValutarController(CursValutarRepository cursValutarRepository, SchimbOperationService schimbOperationService, NumerarRepoitory numerarRepoitory) {
        this.cursValutarRepository = cursValutarRepository;
        this.schimbOperationService = schimbOperationService;
        this.numerarRepoitory = numerarRepoitory;
    }

    @PostMapping("/add_curs")
    @ResponseStatus(HttpStatus.CREATED)
    public CursValutar create(@RequestBody CursValutar curs) {
        return cursValutarRepository.save(curs);
    }

    @GetMapping("/{valuta}")
    public CursValutar getByValuta(@PathVariable String valuta) {
        return cursValutarRepository.findByValutaAndDataCurs(valuta.toUpperCase(), LocalDate.now());
    }

    @PostMapping("/register_exchange")
    @ResponseStatus(HttpStatus.CREATED)
    public SchimbValutar addExchangeEntry(@RequestBody SchimbRequestBean request) {
        return schimbOperationService.registerExchangeOperation(request);
    }

    @PutMapping("/update_amount/{id}/")
    public Numerar updateAmount(@RequestBody Numerar numerar, @PathVariable long id) {
        Numerar existingNumerar = null;
        Optional<Numerar> existingNumerarOption = numerarRepoitory.findById(id);
        if (existingNumerarOption.isPresent()) {
            existingNumerar = existingNumerarOption.get();
            existingNumerar.setSuma(numerar.getSuma());
            numerarRepoitory.save(existingNumerar);
        }
        return existingNumerar;
    }
}
