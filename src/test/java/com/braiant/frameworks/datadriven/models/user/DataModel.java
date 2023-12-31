package com.braiant.frameworks.datadriven.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.braiant.baseapi.BaseModel;
import lombok.Data;

@Data
public class DataModel extends BaseModel {
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String avatar;
}
