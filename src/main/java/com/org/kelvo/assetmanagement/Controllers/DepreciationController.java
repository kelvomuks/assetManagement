package com.org.kelvo.assetmanagement.Controllers;

import com.org.kelvo.assetmanagement.Entities.Depreciation;
import com.org.kelvo.assetmanagement.Services.DepartmentService;
import com.org.kelvo.assetmanagement.Services.DepreciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepreciationController {

    @Autowired
    private DepreciationService depreciationService;

    @GetMapping("/depreciation")
    public ResponseEntity<List<Depreciation>> getAllDepreciations(){
        List<Depreciation> depreciationList;
        depreciationList = depreciationService.getAllDepreciations();

        if (depreciationList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(depreciationList, HttpStatus.OK);
    }


    @PostMapping("/depreciations")
    public ResponseEntity<Depreciation> addDepreciationType(@RequestBody Depreciation depreciation){
        if (depreciationService.addDepreciation(depreciation) != null){
            return new ResponseEntity<>(depreciation,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/depreciations/{depreciationId}")
    public ResponseEntity<Depreciation> getDepreciationById(@PathVariable Long depreciationId){
        Optional<Depreciation> depreciation = depreciationService.findDepreciationById(depreciationId);

        if (depreciation.isPresent()){
            return new ResponseEntity<>(depreciation.get(),HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
