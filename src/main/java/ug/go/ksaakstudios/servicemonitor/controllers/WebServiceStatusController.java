package ug.go.ksaakstudios.servicemonitor.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ug.go.ksaakstudios.servicemonitor.models.MainWebServiceStatus;
import ug.go.ksaakstudios.servicemonitor.models.SecondaryWebServiceStatus;
import ug.go.ksaakstudios.servicemonitor.models.WebServiceStatus;
import ug.go.ksaakstudios.servicemonitor.repositories.MainWebServiceStatusRepository;
import ug.go.ksaakstudios.servicemonitor.repositories.SecondaryWebServiceStatusRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WebServiceStatusController {
	private static final Logger log = LoggerFactory.getLogger(WebServiceStatusController.class);

	@Autowired
	private MainWebServiceStatusRepository repository;

	@Autowired
	SecondaryWebServiceStatusRepository repositorySecondary;

	// public StatusController(MainWebServiceStatusRepository repository) {
	// this.repository = repository;
	// }

	@GetMapping("/webServiceOneActivityToday")
	public List<MainWebServiceStatus> getWebServiceOneActivityToday() {
		log.info("Lookup service one statuses by date...");
		List<MainWebServiceStatus> statuses = new ArrayList<>();
		repository.findAllByDate(LocalDate.now()).forEach(statuses::add);
		statuses.stream().forEach(status -> log.info("\t" + status.toString()));
		log.info("Done Done");
		return statuses;
	}

	@GetMapping("/webServiceTwoActivityToday")
	public List<SecondaryWebServiceStatus> webServiceTwoActivityToday() {
		log.info("Lookup service two statuses by date...");
		List<SecondaryWebServiceStatus> statuses = new ArrayList<>();
		repositorySecondary.findAllByDate(LocalDate.now()).forEach(statuses::add);
		statuses.stream().forEach(status -> log.info("\t" + status.toString()));
		log.info("Done Done");
		return statuses;
	}

	@GetMapping("/webServiceStatusToday")
	public WebServiceStatus webServiceStatusToday() {

		log.info("Lookup service one statuses by date...");
		List<MainWebServiceStatus> statusesWS1 = new ArrayList<>();
		repository.findAllByDate(LocalDate.now()).forEach(statusesWS1::add);
		log.info("Done Done service one");

		log.info("Lookup service two statuses by date...");
		List<SecondaryWebServiceStatus> statusesWS2 = new ArrayList<>();
		repositorySecondary.findAllByDate(LocalDate.now()).forEach(statusesWS2::add);
		log.info("Done Done service two");

		return new WebServiceStatus().withMainWebServiceStatuses(statusesWS1)
				.withSecondaryWebServiceStatuses(statusesWS2);
	}

}
