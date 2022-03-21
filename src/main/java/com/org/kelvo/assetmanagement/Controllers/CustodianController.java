package com.org.kelvo.assetmanagement.Controllers;

import com.org.kelvo.assetmanagement.Entities.Custodian;
import com.org.kelvo.assetmanagement.Entities.Department;
import com.org.kelvo.assetmanagement.Entities.Location;
import com.org.kelvo.assetmanagement.Services.CustodianService;
import com.org.kelvo.assetmanagement.Services.DepartmentService;
import com.org.kelvo.assetmanagement.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustodianController {

    @Autowired
    private CustodianService custodianService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/custodians")
    public ResponseEntity<List<Custodian>> getAllCustodians(){

        return new ResponseEntity<List<Custodian>>(custodianService.getAllCUstodians(),HttpStatus.OK);
    }


    @PostMapping("/custodians")
    public ResponseEntity<Custodian> addCustodian(@RequestBody Custodian custodian){

        Optional<Location> location = locationService.getLocationById(custodian.getLocationId());
        if (location.isPresent()){


            Optional<Department> department = departmentService.findDepartmentById(custodian.getDepartmentId());

            if(department.isPresent()){
                custodian.setDepartment(department.get());
                custodian.setLocation(location.get());
                custodianService.saveCustodian(custodian);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }


        return new ResponseEntity<>(custodian, HttpStatus.CREATED);

      //  return new ResponseEntity<>( custodianService.saveCustodian(custodian),HttpStatus.CREATED);
    }

    @GetMapping("/custodians/{custodianId}")
    public ResponseEntity<Optional<Custodian>> findCustodianById(@PathVariable Long custodianId){
        Optional<Custodian> custodian = custodianService.getCustodianById(custodianId);
        if (!custodian.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(custodian,HttpStatus.FOUND);
    }
}
