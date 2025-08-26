package com.example.LocationDetailsBackend.Dtos;

import java.util.Arrays;

public class NearByLocationsDto {
    private Element[] elements;

    public NearByLocationsDto(Element[] elements) {
        this.elements = elements;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "NearByLocationsDto{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
