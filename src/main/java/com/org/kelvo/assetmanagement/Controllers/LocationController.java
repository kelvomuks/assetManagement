package com.org.kelvo.assetmanagement.Controllers;


import com.org.kelvo.assetmanagement.Entities.Location;
import com.org.kelvo.assetmanagement.Services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/location/{page}/{size}")
    public Page<Location> getLocation(@PathVariable (required = false )int page, @PathVariable (required = false ) int size){

        return locationService.getLocations(page,size);
    }

    @PostMapping("/location")
    public Location addNewLocation(@RequestBody Location location){

        return locationService.addNewLocation(location);
    }

  /*  @PostMapping("/location")
    public String addNewLocation(){

        locationService.addNewLocation();

        return "Ok";
    }*/
}
