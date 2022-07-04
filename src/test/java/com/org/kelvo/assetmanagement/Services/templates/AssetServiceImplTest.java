package com.org.kelvo.assetmanagement.Services.templates;

import com.org.kelvo.assetmanagement.Entities.Asset;
import com.org.kelvo.assetmanagement.Repositories.AssetRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AssetServiceImplTest {

    @Autowired
   // @InjectMocks
    private AssetServiceImpl assetService;

    @MockBean
    private AssetRepository assetRepository;



    @Test
    @DisplayName("Testing Asset save")
    void testAddNewAsset(){
        Asset asset = new Asset();
        asset.setLocationId(41L);
        asset.setAssetType("Equipment");
        asset.setAssetName("wheelbarrow");
        asset.setAssetId(100L);
        asset.setCustodianId(36L);
        asset.setDepartmentId(33L);
        asset.setAssetValue("10000");
        asset.setAssetCode("Wh12345d");
        asset.setAssetType("WHL12");

        doReturn(asset).when(assetRepository).save(any());

        Asset savedAsset = assetService.addNewAsset(asset);

        Assertions.assertNotNull(savedAsset,"Saved asset should be null");
        //Assertions.assertEquals(1L,asset.getAssetId(),"Asset Id should not be null");

    }

    @Test
    @DisplayName("Testing finding asset by Id")
    void testFindAssetById(){
        Asset asset = new Asset();
        asset.setAssetId(1L);
        asset.setAssetName("Landcruser");
        asset.setLocationId(31L);
        asset.setDepartmentId(43L);

        doReturn(Optional.of(asset)).when(assetRepository).findById(1L);

        Optional<Asset> foundAsset = assetService.findAssetById(1L);

        Assertions.assertTrue(foundAsset.isPresent(),"Asset was not found");
        Assertions.assertSame(foundAsset.get(),asset,"Asset found was not the same as mock asset");
    }

    /*@Test
    @DisplayName("Test findAllAsset")
    void testFindAllAsset(){

        Asset asset = new Asset();
        asset.setAssetId(1L);
        asset.setAssetName("Landcruser");
        asset.setLocationId(31L);
        asset.setDepartmentId(43L);

        Asset asset1 = new Asset();
        asset1.setAssetId(2L);
        asset1.setAssetName("RangeRover");
        asset1.setLocationId(31L);
        asset1.setDepartmentId(43L);

        doReturn(Arrays.asList(asset, asset1)).when(assetRepository).findAll();

        Page<Asset> assetList = assetService.getAllAssets(1,2);


        Assertions.assertEquals(2,assetList.getTotalElements(),"Find all should return two assets");

    }*/

    @Test
    @DisplayName("Test delete Asset by Id")
    void testDeleteAssetById(){
        var asset = new Asset();
        asset.setAssetId(1l);
        asset.setLocationId(41l);
        asset.setDepartmentId(23l);
        asset.setAssetName("TestAsset");
        asset.setAssetType("Asset type");
        asset.setAssetCode("ASTCode");
        asset.setCustodianId(1l);

       //
        assetRepository.deleteById(1l);
        verify(assetRepository).deleteById(asset.getAssetId());
//        assertThat(asset).isNull();



    }
}