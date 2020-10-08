package com.sitedosistema.qa.automation.webservices;

import com.sitedosistema.qa.automation.webservices.config.pojo.CreateCardRequest;
import com.sitedosistema.qa.automation.webservices.config.pojo.UpdateCardRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.sitedosistema.qa.automation.webservices.config.Endpoints.*;
import static io.restassured.RestAssured.given;

public class Api {
    final String AUTH ="key=782d0ab7808cb95632827cd828a615d2&" +
            "token=4726548c899b8eb9a978620164b2255d46150081a76c535374bb2ea7d29c0036";

    public Response createCard(CreateCardRequest request){
        Map<String, Object> map = getAuth();
        map.put("name", request.getName());
        map.put("desc", request.getDescription());
        map.put("listId", request.getListId().getListId());
        return given().log().all()
                .pathParams(map)
                .contentType("application/json")
                .post(BASE_URL.getEndpoint()+CREATE_CARD.getEndpoint());
    }

    public Response moveCardToDone(UpdateCardRequest request){
        Map<String, Object> map = getAuth();
        map.put("listId", request.getListId().getListId());
        map.put("cardId", request.getCardId());
        return given().log().all().pathParams(map).contentType("application/json")
                .put(BASE_URL.getEndpoint()+UPDATE_CARD.getEndpoint());
    }

    private Map<String, Object> getAuth(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("auth", AUTH);
        return map;
    }

}
