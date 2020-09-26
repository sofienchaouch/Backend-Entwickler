package com.backendentwickler.springbootrestapi.controller;

import com.backendentwickler.springbootrestapi.service.TreatmentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//REST API

//to test Rest API of the app
//Access The link
//http://localhost:8080/api/v1/{nbr}
@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/api")
public class RestController {

    //Autowirding treatment service
    @Autowired
    private TreatmentService treatmentService;

    //Get Methode to get result
    //Test exemple :
    // http://localhost:8080/api/v1/9
    @GetMapping("/v1/{nbr}")
    public ResponseEntity<?> getResult(@PathVariable(value = "nbr") int number) {

        try {
            return ResponseEntity.ok().body(treatmentService.result(number).toString());
        } catch (Exception e) {
            throw new  IllegalArgumentException() ;

        }

    }


}