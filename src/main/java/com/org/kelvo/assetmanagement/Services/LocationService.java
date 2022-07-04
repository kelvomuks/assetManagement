package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Location;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    Page<Location> getLocations(int page, int size);

    Location addNewLocation(Location location);
   // void addNewLocation();

    Optional<Location> getLocationById(Long locationId);
}
