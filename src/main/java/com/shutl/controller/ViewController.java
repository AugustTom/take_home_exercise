package com.shutl.controller;

import com.shutl.model.VehicleMarkup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ViewController {

    @GetMapping("/")
    public ModelAndView index() {
        ArrayList<String> vehicleOptions = VehicleMarkup.getVehicleList();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("vehicle_options", vehicleOptions);
        return mav;
    }
}
