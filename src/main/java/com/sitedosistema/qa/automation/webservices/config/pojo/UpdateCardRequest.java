package com.sitedosistema.qa.automation.webservices.config.pojo;

import com.sitedosistema.qa.automation.utils.Columns;
import lombok.Data;

@Data
public class UpdateCardRequest {
    private Columns listId;
    private String cardId;
}
