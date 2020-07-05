package ug.go.ksaakstudios.servicemonitor.models;

import java.util.List;

public class WebServiceStatus {

	private List<MainWebServiceStatus> mainWebServiceStatuses;

	private List<SecondaryWebServiceStatus> secondaryWebServiceStatuses;

	public List<MainWebServiceStatus> getMainWebServiceStatuses() {
		return mainWebServiceStatuses;
	}

	public void setMainWebServiceStatuses(List<MainWebServiceStatus> mainWebServiceStatuses) {
		this.mainWebServiceStatuses = mainWebServiceStatuses;
	}

	public WebServiceStatus withMainWebServiceStatuses(List<MainWebServiceStatus> mainWebServiceStatuses) {
		this.mainWebServiceStatuses = mainWebServiceStatuses;
		return this;
	}

	public List<SecondaryWebServiceStatus> getSecondaryWebServiceStatuses() {
		return secondaryWebServiceStatuses;
	}

	public void setSecondaryWebServiceStatuses(List<SecondaryWebServiceStatus> secondaryWebServiceStatuses) {
		this.secondaryWebServiceStatuses = secondaryWebServiceStatuses;
	}

	public WebServiceStatus withSecondaryWebServiceStatuses(List<SecondaryWebServiceStatus> secondaryWebServiceStatuses) {
		this.secondaryWebServiceStatuses = secondaryWebServiceStatuses;
		return this;
	}

}
