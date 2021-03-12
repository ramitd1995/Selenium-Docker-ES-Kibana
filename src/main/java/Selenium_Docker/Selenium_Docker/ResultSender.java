package main.java.Selenium_Docker.Selenium_Docker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class ResultSender {

    private static final ObjectMapper OM = new ObjectMapper();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ELASTICSEARCH_URL = "http://127.0.0.1:9200/app/suite"; 
    
    public static void send(final TestStatus testStatus){
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(OM.writeValueAsString(testStatus)).asJson();
            System.out.println(OM.writeValueAsString(testStatus));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}