package ug.go.ksaakstudios.servicemonitor.scheduledTasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ug.go.ksaakstudios.servicemonitor.models.MainWebServiceStatus;
import ug.go.ksaakstudios.servicemonitor.models.SecondaryWebServiceStatus;
import ug.go.ksaakstudios.servicemonitor.pojos.ServiceResponse;
import ug.go.ksaakstudios.servicemonitor.repositories.MainWebServiceStatusRepository;
import ug.go.ksaakstudios.servicemonitor.repositories.SecondaryWebServiceStatusRepository;

@Component
public class ServiceHealthTask {

	@Autowired
	MainWebServiceStatusRepository repository;

	@Autowired
	SecondaryWebServiceStatusRepository repositorySecondary;

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(ServiceHealthTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Scheduled(cron = "0 */30 * * * *")
	public void recordWebServiceOneActivity() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		boolean status = false;

		// ServiceResponse response = restTemplate.getForObject(
		// "https://serviceURL",
		// ServiceResponse.class);

		ResponseEntity<ServiceResponse> serviceResponse = restTemplate.getForEntity(
				"https://serviceURL",
				ServiceResponse.class);
		if (serviceResponse.getStatusCode().equals(HttpStatus.OK) && serviceResponse.getBody().getAppVersn() != null) {
			status = true;
		}
		// repository.save(new MainWebServiceStatus().withStatus(response.getAppVersn() != null));
		repository.save(new MainWebServiceStatus().withStatus(status));
		log.info(serviceResponse.getBody().toString());
	}

	@Scheduled(cron = "0 */30 * * * *")
	public void recordWebServiceTwoActivity() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		boolean status = false;

		ResponseEntity<String> serviceResponse = restTemplate.getForEntity(
				"https://serviceURL",
				String.class);
		if (serviceResponse.getStatusCode().equals(HttpStatus.OK)) {
			status = true;
		}
		repositorySecondary.save(new SecondaryWebServiceStatus().withStatus(status));
		// log.info(serviceResponse.getBody().toString()); Don't log the HTML
	}

}
