package com.braiant.restassured.demo.model.user;

import com.braiant.restassured.demo.model.PageModel;
import lombok.Data;

import java.util.List;
@Data
public class UsersModel extends PageModel {
    private List<DataModel> data;
}
