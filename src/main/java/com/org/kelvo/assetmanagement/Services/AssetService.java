package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Asset;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface AssetService {

    Page<Asset> getAllAssets(int page, int size);

    Asset addNewAsset(Asset asset);

    Optional<Asset> findAssetById(Long id);

    Asset updateAsset(Long id, Asset asset);

    boolean deleteAssetById(Long id);
}
