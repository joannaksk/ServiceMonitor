package ug.go.ksaakstudios.servicemonitor.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import ug.go.ksaakstudios.servicemonitor.models.SecondaryWebServiceStatus;

public interface SecondaryWebServiceStatusRepository extends Neo4jRepository<SecondaryWebServiceStatus, Long> {

	@Query("MATCH (status:SecondaryWebServiceStatus) WHERE date(dateTime(status.timestamp)) = date($0) WITH status ORDER BY status.timestamp DESC LIMIT 25 WITH status ORDER BY status.timestamp RETURN status")
	Iterable<SecondaryWebServiceStatus> findAllByDate(LocalDate date);

	Iterable<SecondaryWebServiceStatus> findAllByTimestamp(LocalDateTime from, LocalDateTime to);

}
