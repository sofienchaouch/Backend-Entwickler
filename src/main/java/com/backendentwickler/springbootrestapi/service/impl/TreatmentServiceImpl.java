package com.backendentwickler.springbootrestapi.service.impl;

import com.backendentwickler.springbootrestapi.service.TreatmentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/* CREATING Treatment service implimentation that describes the service logic*/
@Service
public class TreatmentServiceImpl implements TreatmentService {

    @Override
    public JSONObject result(int nbr) {


        //Declaring output Json object
        JSONObject output = new JSONObject();

        //numbers list
        List<Integer> numbersList = new ArrayList<>();

        //conditions

        if (nbr%3==0 && nbr%5==0){
            for (int i = 1; i <=nbr ; i++) {
                numbersList.add(i);
            }
            output.put("Type","FizzBuzz");
            output.put("NumbersList",numbersList);

        }else if (nbr%3==0 ){

            for (int i = 1; i <=nbr ; i++) {
                numbersList.add(i);
            }

            output.put("Type","Fizz");
            output.put("NumbersList",numbersList);

        }else if (nbr%5==0){

            for (int i = 1; i <=nbr ; i++) {
                numbersList.add(i);
            }

            output.put("Type","Buzz");
            output.put("NumbersList",numbersList);

        }else {
            output.put("NextNumber",++nbr);
        }
        return output;
    }
}
