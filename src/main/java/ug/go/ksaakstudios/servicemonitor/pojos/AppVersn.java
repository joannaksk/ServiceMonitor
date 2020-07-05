package ug.go.ksaakstudios.servicemonitor.pojos;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "verName", "verCode" })
public class AppVersn {

	@JsonProperty("verName")
	private String verName;
	@JsonProperty("verCode")
	private String verCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("verName")
	public String getVerName() {
		return verName;
	}

	@JsonProperty("verName")
	public void setVerName(String verName) {
		this.verName = verName;
	}

	@JsonProperty("verCode")
	public String getVerCode() {
		return verCode;
	}

	@JsonProperty("verCode")
	public void setVerCode(String verCode) {
		this.verCode = verCode;
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
		return " { verName : " + verName + ", verCode : " + verCode + " } ";
	}
}