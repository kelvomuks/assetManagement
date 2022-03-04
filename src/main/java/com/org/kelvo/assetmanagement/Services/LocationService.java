package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Location;

import java.util.List;

public interface LocationService {
    List<Location> getLocations();

    Location addNewLocation(Location location);
}
