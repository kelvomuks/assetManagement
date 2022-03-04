package com.org.kelvo.assetmanagement.Services.templates;

import com.org.kelvo.assetmanagement.Entities.Asset;
import com.org.kelvo.assetmanagement.Repositories.AssetRepository;
import com.org.kelvo.assetmanagement.Services.AssetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @Override
    public Asset addNewAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Optional<Asset> findAssetById(Long id) {
        return assetRepository.findById(id);
    }

    @Override
    public Asset updateAsset(Long id, Asset asset) {
        Optional<Asset> assetOptional = assetRepository.findById(id);
        if(assetOptional.isPresent()){
            log.info("Asset with id {} was found",id);
           Asset ast= assetOptional.get();
           ast.setAssetCode(asset.getAssetCode());
           ast.setAssetName(asset.getAssetName());
           ast.setAssetType(asset.getAssetType());
           ast.setCustodian(asset.getCustodian());
           ast.setAssetValue(asset.getAssetValue());
           ast.setDepartment(asset.getDepartment());
           ast.setLocation(asset.getLocation());
           ast.setModel(asset.getModel());
           ast.setSerialNo(asset.getSerialNo());

           return assetRepository.save(ast);
        }

        log.info("Asset with id {} was  not found",id);
        log.info("New asset  {} to be created ",asset);
        return assetRepository.save(asset);
    }

    @Override
    public boolean deleteAssetById(Long id) {

        if (assetRepository.findById(id).isPresent()) {
            assetRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
