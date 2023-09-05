package com.braiant.restassured.demo.model.resource;

import com.braiant.baseapi.BaseModel;
import com.braiant.restassured.demo.model.SupportModel;
import lombok.Data;

@Data
public class ResourceModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
