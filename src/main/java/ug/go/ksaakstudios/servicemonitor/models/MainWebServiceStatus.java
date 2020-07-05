package ug.go.ksaakstudios.servicemonitor.models;

import java.time.LocalDateTime;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class MainWebServiceStatus {

	@Id
	@GeneratedValue
	private Long id;
	private LocalDateTime timestamp = LocalDateTime.now();
	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public MainWebServiceStatus withStatus(boolean status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return "MainWebServiceStatus [id=" + id + ", timestamp=" + timestamp + ", status=" + status + "]";
	}

}
