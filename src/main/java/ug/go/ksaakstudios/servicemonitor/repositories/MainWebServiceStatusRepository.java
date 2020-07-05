package ug.go.ksaakstudios.servicemonitor.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import ug.go.ksaakstudios.servicemonitor.models.MainWebServiceStatus;

public interface MainWebServiceStatusRepository extends Neo4jRepository<MainWebServiceStatus, Long> {

	// default Iterable<MainWebServiceStatus> findAllByDate(LocalDate date) {
	// return findAllByTimestamp(date.atStartOfDay(),
	// date.plusDays(1).atStartOfDay());
	// }

	// @Query("MATCH (status:MainWebServiceStatus) WHERE
	// date(dateTime(status.timestamp)) = date($0) ORDER BY timestamp DESC RETURN
	// status LIMIT 25")
	@Query("MATCH (status:MainWebServiceStatus) WHERE date(dateTime(status.timestamp)) = date($0) WITH status ORDER BY status.timestamp DESC LIMIT 25 WITH status ORDER BY status.timestamp RETURN status")
	Iterable<MainWebServiceStatus> findAllByDate(LocalDate date);

	Iterable<MainWebServiceStatus> findAllByTimestamp(LocalDateTime from, LocalDateTime to);

}
