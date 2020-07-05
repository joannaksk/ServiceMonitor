package ug.go.ksaakstudios.servicemonitor.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "appVersn" })
public class ServiceResponse {

	@JsonProperty("appVersn")
	private List<AppVersn> appVersn = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("appVersn")
	public List<AppVersn> getAppVersn() {
		return appVersn;
	}

	@JsonProperty("appVersn")
	public void setAppVersn(List<AppVersn> appVersn) {
		this.appVersn = appVersn;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return " { appVersn : " + appVersn + " } ";
	}

}