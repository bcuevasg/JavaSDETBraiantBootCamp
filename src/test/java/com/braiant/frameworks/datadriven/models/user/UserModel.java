package com.braiant.frameworks.datadriven.models.user;

import com.braiant.baseapi.BaseModel;
import com.braiant.frameworks.datadriven.models.SupportModel;
import lombok.Data;

@Data
public class UserModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
