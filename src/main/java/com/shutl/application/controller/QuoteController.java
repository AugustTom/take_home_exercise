package com.shutl.application.controller;


import com.shutl.application.model.Quote;
import com.shutl.application.model.VehicleMarkup;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody
    Quote quote(@RequestBody Quote quote) {
        long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36)) / 100000000);
        try {
            price += Math.round(price * VehicleMarkup.valueOf(quote.getVehicle()).getMarkupByVehicle());
        } catch (NullPointerException e){
            return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), price);
        }
        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), price);
    }

}

