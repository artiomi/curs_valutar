package my.exam.curs.repositories;

import my.exam.curs.models.Numerar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumerarRepoitory extends JpaRepository<Numerar, Long> {
}
