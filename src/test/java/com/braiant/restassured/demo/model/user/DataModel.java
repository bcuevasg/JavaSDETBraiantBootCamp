package com.braiant.restassured.demo.model.user;

import com.braiant.baseapi.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataModel extends BaseModel {
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String last_name;
    private String avatar;
}
