package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> getLocations();

    Location addNewLocation(Location location);

    Optional<Location> getLocationById(Long locationId);
}
