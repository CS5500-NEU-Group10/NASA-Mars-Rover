package com.cs5500group10.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class MarsPhoto.
 */
public class MarsPhoto {

    /**
     * The MarsPhoto's id.
     */
    private Long id;

    /**
     * The MarsPhoto's sol.
     */
    private Integer sol;

    /**
     * The MarsPhoto's camera.
     */
    private MarsCamera camera;

    /**
     * The MarsPhoto's img src.
     */
    @JsonProperty("img_src")
    private String imgSrc;

    /**
     * The earth date.
     */
    @JsonProperty("earth_date")
    private String earthDate;

    /**
     * The Mars rover.
     */
    private MarsRover rover;

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
     * Gets the sol.
     *
     * @return the sol
     */
    public Integer getSol() {
        return sol;
    }

    /**
     * Sets the sol.
     *
     * @param sol the new sol
     */
    public void setSol(Integer sol) {
        this.sol = sol;
    }

    /**
     * Gets the camera.
     *
     * @return the camera
     */
    public MarsCamera getCamera() {
        return camera;
    }

    /**
     * Sets the camera.
     *
     * @param camera the new camera
     */
    public void setCamera(MarsCamera camera) {
        this.camera = camera;
    }

    /**
     * Gets the img src.
     *
     * @return the img src
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * Sets the img src.
     *
     * @param imgSrc the new img src
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }


    /**
     * Gets the earth date.
     *
     * @return the earth date
     */
    public String getEarthDate() {
        return earthDate;
    }

    /**
     * Sets the earth date.
     *
     * @param earthDate the new earth date
     */
    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    /**
     * Gets the rover.
     *
     * @return the rover
     */
    public MarsRover getRover() {
        return rover;
    }

    /**
     * Sets the rover.
     *
     * @param rover the new rover
     */
    public void setRover(MarsRover rover) {
        this.rover = rover;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "MarsPhoto [id=" + id + ", sol=" + sol + ", camera=" + camera + ", imgSrc=" + imgSrc + "]";
    }
}
