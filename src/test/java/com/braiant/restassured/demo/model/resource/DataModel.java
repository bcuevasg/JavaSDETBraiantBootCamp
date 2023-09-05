package com.braiant.restassured.demo.model.resource;

import com.braiant.baseapi.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataModel extends BaseModel {
    private int id;
    private String name;
    private int year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;
}
