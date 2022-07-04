package com.org.kelvo.assetmanagement.Services.templates;

import com.org.kelvo.assetmanagement.Entities.Location;
import com.org.kelvo.assetmanagement.Repositories.LocationRepository;
import com.org.kelvo.assetmanagement.Services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Page<Location> getLocations(int page,int size) {
        PageRequest paging = PageRequest.of(page,size);
        Page<Location> locations = locationRepository.findAll(paging);
        return locations;
    }

    @Override
    public Location addNewLocation(Location location) {

        return locationRepository.save(location);
    }

   /* // @Override
     @PostConstruct
    public void addNewLocation() {

         List<Location> locations = IntStream.rangeClosed(0,30)
                         .mapToObj(i -> new Location(null,"location"+i,"code"+i))
                                 .collect(Collectors.toList());
         locationRepository.saveAll(locations);
    }*/

    @Override
    public Optional<Location> getLocationById(Long locationId) {
        log.info("Service finding location by id {}",locationId);
        Optional<Location> location = locationRepository.findById(locationId);
        //location.get();
        if (location.isPresent()){
            log.info("Location with id {} was found",locationId);
        }
        log.error("location with id {} was not found",locationId);
        return location;
    }
}
