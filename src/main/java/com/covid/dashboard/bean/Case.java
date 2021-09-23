package com.covid.dashboard.bean;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonProperty;

@RedisHash("covid_dash")
public class Case {

	@JsonProperty(value = "FIPS")
	private String fips;
	@JsonProperty(value = "Admin2")
    private String admin2;
	@JsonProperty(value = "Province_State")
    private String provinceState;
	@JsonProperty(value = "Country_Region")
    private String countryRegion;
	@JsonProperty(value = "Last_Update")
    private String lastUpdate;
	@JsonProperty(value = "Lat")
    private String lat;
	@JsonProperty(value = "Long_")
    private String longitude;
	@JsonProperty(value = "Confirmed")
    private long confirmed;
	@JsonProperty(value = "Deaths")
    private long deaths;
	@JsonProperty(value = "Recovered")
    private long recovered;
	@JsonProperty(value = "Active")
    private long active;
	@JsonProperty(value = "Combined_Key")
    private String combinedKey;
	@JsonProperty(value = "Incident_Rate")
    private float incidentRate;
	@JsonProperty(value = "Case_Fatality_Ratio")
    private float fatalityRatio;
	public String getFips() {
		return fips;
	}
	public void setFips(String fips) {
		this.fips = fips;
	}
	public String getAdmin2() {
		return admin2;
	}
	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}
	public String getProvinceState() {
		return provinceState;
	}
	public void setProvinceState(String provinceState) {
		this.provinceState = provinceState;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Long getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}
	public Long getDeaths() {
		return deaths;
	}
	public void setDeaths(Long deaths) {
		this.deaths = deaths;
	}
	public Long getRecovered() {
		return recovered;
	}
	public void setRecovered(Long recovered) {
		this.recovered = recovered;
	}
	public Long getActive() {
		return active;
	}
	public String getCombinedKey() {
		return combinedKey;
	}
	public void setCombinedKey(String combinedKey) {
		this.combinedKey = combinedKey;
	}
	public float getIncidentRate() {
		return incidentRate;
	}
	public void setIncidentRate(float incidentRate) {
		this.incidentRate = incidentRate;
	}
	public float getFatalityRatio() {
		return fatalityRatio;
	}
	public void setFatalityRatio(float fatalityRatio) {
		this.fatalityRatio = fatalityRatio;
	}
	public void setConfirmed(long confirmed) {
		this.confirmed = confirmed;
	}
	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}
	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}
	public void setActive(long active) {
		this.active = active;
	}
    
}
