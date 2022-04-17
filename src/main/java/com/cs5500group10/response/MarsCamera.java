package com.cs5500group10.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class MarsCamera.
 */
public class MarsCamera {

    /**
     * The MarsCamera's id.
     */
    private Long id;

    /**
     * The MarsCamera's name.
     */
    private String name;

    /**
     * The MarsCamera's rover id.
     */
    @JsonProperty("rover_id")
    private Long roverId;

    /**
     * The MarsCamera's full name.
     */
    @JsonProperty("full_name")
    private String fullName;

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
     * Gets the rover id.
     *
     * @return the rover id
     */
    public Long getRoverId() {
        return roverId;
    }

    /**
     * Sets the rover id.
     *
     * @param roverId the new rover id
     */
    public void setRoverId(Long roverId) {
        this.roverId = roverId;
    }

    /**
     * Gets the full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name.
     *
     * @param fullName the new full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
