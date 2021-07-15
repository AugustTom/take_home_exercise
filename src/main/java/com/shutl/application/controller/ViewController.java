package com.shutl.application.controller;

import com.shutl.application.model.Quote;
import com.shutl.application.model.VehicleMarkup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
