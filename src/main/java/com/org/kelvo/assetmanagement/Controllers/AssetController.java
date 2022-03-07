package com.org.kelvo.assetmanagement.Controllers;


import com.org.kelvo.assetmanagement.Entities.Asset;
import com.org.kelvo.assetmanagement.Resources.ResourceNotFound;
import com.org.kelvo.assetmanagement.Services.AssetService;
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

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetService.getAllAssets();
    }

    @PostMapping("/assets")
    public Asset addAsset(@RequestBody Asset asset){

        //System.out.println("Passed location"+asset.getLocationId());
        log.info("New asset is {}",asset);
        return assetService.addNewAsset(asset);
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
