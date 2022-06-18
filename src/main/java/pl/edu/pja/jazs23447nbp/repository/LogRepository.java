package pl.edu.pja.jazs23447nbp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.jazs23447nbp.model.LogEntry;

@Repository
public interface LogRepository extends CrudRepository<LogEntry, Long> {

}
