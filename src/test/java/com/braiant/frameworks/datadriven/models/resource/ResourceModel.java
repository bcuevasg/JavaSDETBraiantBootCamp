package com.braiant.frameworks.datadriven.models.resource;

import com.braiant.baseapi.BaseModel;
import com.braiant.frameworks.datadriven.models.SupportModel;
import lombok.Data;

@Data
public class ResourceModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
