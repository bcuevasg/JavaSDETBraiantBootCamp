package com.braiant.restassured.demo.model.resource;

import com.braiant.restassured.demo.model.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class ResourcesModel extends PageModel {
    private List<DataModel> data;
}
