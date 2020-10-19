package my.exam.curs.repositories;

import my.exam.curs.models.CursValutar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface CursValutarRepository extends JpaRepository<CursValutar, Long> {
    @Query("FROM CursValutar c where c.valuta.id = :valutaId and c.dataCurs = :dataCurs")
    CursValutar findByValutaAndDataCurs(@Param("valutaId") String valuta, @Param("dataCurs") LocalDate dataCurs);

    @Query("FROM CursValutar c where c.valuta.id = :valutaId and c.curs = :curs and c.dataCurs = :dataCurs")
    CursValutar findByValutaAndCursAndDataCurs(@Param("valutaId") String valuta, @Param("curs") double curs,  @Param("dataCurs") LocalDate dataCurs);
}
