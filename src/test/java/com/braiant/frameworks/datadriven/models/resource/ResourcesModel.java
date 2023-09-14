package com.braiant.frameworks.datadriven.models.resource;

import com.braiant.frameworks.datadriven.models.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class ResourcesModel extends PageModel {
    private List<DataModel> data;
}
