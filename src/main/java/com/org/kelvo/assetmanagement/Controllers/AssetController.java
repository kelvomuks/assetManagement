package com.org.kelvo.assetmanagement.Controllers;


import com.org.kelvo.assetmanagement.Entities.Asset;
import com.org.kelvo.assetmanagement.Entities.Custodian;
import com.org.kelvo.assetmanagement.Entities.Department;
import com.org.kelvo.assetmanagement.Entities.Location;
import com.org.kelvo.assetmanagement.Services.AssetService;
import com.org.kelvo.assetmanagement.Services.CustodianService;
import com.org.kelvo.assetmanagement.Services.DepartmentService;
import com.org.kelvo.assetmanagement.Services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class AssetController {
    @Autowired
    private AssetService assetService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CustodianService custodianService;

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetService.getAllAssets();
    }

    @PostMapping("/assets")
    /*public Asset addAsset(@RequestBody Asset asset){

        //System.out.println("Passed location"+asset.getLocationId());
        log.info("New asset is {}",asset);
        return assetService.addNewAsset(asset);
    }*/

    public ResponseEntity<Asset> createComment(@RequestBody Asset asset) {
       /* Asset asset1 = locationService.getLocationById(asset.getLocationId()).map(location -> {
            asset.setLocation((Location) location);
            return assetService.addNewAsset(asset);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Location with id = " + asset.getLocationId()));*/

       Optional<Location> location = locationService.getLocationById(asset.getLocationId());
       if (location.isPresent()){


           Optional<Department> department = departmentService.findDepartmentById(asset.getDepartmentId());

           if(department.isPresent()){
               Optional<Custodian> custodian = custodianService.getCustodianById(asset.getCustodianId());

               if (custodian.isPresent()) {
                   asset.setDepartment(department.get());
                   asset.setLocation(location.get());
                   assetService.addNewAsset(asset);
               }else{
                   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
               }
           }else {
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
       }


        return new ResponseEntity<>(asset, HttpStatus.CREATED);
    }

    @GetMapping("/assets/{id}")
    public Optional<Asset> getAssetById(@PathVariable Long id){
        return assetService.findAssetById(id);
    }

    @PutMapping("/assets/{id}")
    public Asset updateAsset(@PathVariable Long id,@RequestBody Asset asset){

        return assetService.updateAsset(id,asset);
    }

    @DeleteMapping("/assets/{id}")
    public ResponseEntity<?> deteteAsset(@PathVariable Long id)  {

        if(!assetService.deleteAssetById(id)){
            log.info("Asset with id {} not found",id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Asset with id {} deleted",id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
