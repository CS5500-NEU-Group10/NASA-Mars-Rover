package com.cs5500group10.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class MarsRover.
 */
public class MarsRover {
	
	/** The MarsRover's id. */
	private Long id;
	
	/** The MarsRover's name. */
	private String name;
	
	/** The MarsRover's landing date. */
	@JsonProperty("landing_date")
	private String landingDate;
	
	/** The MarsRover's launch date. */
	@JsonProperty("launch_date")
	private String launchDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the landing date.
	 *
	 * @return the landing date
	 */
	public String getLandingDate() {
		return landingDate;
	}

	/**
	 * Sets the landing date.
	 *
	 * @param landingDate the new landing date
	 */
	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}

	/**
	 * Gets the launch date.
	 *
	 * @return the launch date
	 */
	public String getLaunchDate() {
		return launchDate;
	}

	/**
	 * Sets the launch date.
	 *
	 * @param launchDate the new launch date
	 */
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "MarsRover [id=" + id + ", name=" + name + ", landingDate=" + landingDate + "]";
	}
}
