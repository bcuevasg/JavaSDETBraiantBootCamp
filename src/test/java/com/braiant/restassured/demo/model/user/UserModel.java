package com.braiant.restassured.demo.model.user;

import com.braiant.baseapi.BaseModel;
import com.braiant.restassured.demo.model.SupportModel;
import lombok.Data;

@Data
public class UserModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
