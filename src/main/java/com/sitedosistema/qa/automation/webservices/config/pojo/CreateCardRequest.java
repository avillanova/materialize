package com.sitedosistema.qa.automation.webservices.config.pojo;

import com.sitedosistema.qa.automation.utils.Columns;
import lombok.Data;

@Data
public class CreateCardRequest {
    private String name;
    private String description;
    private Columns listId;
}
