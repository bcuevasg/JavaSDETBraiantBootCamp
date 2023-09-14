package com.braiant.frameworks.datadriven.models.user;

import com.braiant.frameworks.datadriven.models.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class UsersModel extends PageModel {
    private List<DataModel> data;
}
