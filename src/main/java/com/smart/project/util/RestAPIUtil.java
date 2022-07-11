package com.smart.project.util;

import kong.unirest.HttpRequestWithBody;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;

import java.security.SignatureException;

@Slf4j
public class RestAPIUtil {

    public static void sendMessage(){
        HttpResponse<JsonNode> response = Unirest.post("http://localhost/member/check")
                .header("accept", "application/json")
                .queryString("apiKey", "NCSNCRCOR0UDNQMN")
                .field("name", "youngGwang")
                .field("phone", "01086730692")
                .asJson();

        log.error("response ==>{}", response.getStatus()+"");
    }



}
