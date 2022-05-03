package com.cs5500group10.response;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class MarsRoverApiResponse.
 */
public class MarsRoverApiResponse {

    /**
     * The photos.
     */
    List<MarsPhoto> photos = new ArrayList<>();

    /**
     * Gets the photos.
     *
     * @return the photos
     */
    public List<MarsPhoto> getPhotos() {
        return photos;
    }

    /**
     * Sets the photos.
     *
     * @param photos the new photos
     */
    public void setPhotos(List<MarsPhoto> photos) {
        this.photos = photos;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "MarsRoverApiResponse [photos=" + photos + "]";
    }

}
