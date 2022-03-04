package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Asset;

import java.util.List;
import java.util.Optional;


public interface AssetService {

    List<Asset> getAllAssets();

    Asset addNewAsset(Asset asset);

    Optional<Asset> findAssetById(Long id);

    Asset updateAsset(Long id, Asset asset);

    boolean deleteAssetById(Long id);
}
