package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Depreciation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepreciationService {
    List<Depreciation> getAllDepreciations();

    Depreciation addDepreciation(Depreciation depreciation);

    Optional<Depreciation> findDepreciationById(Long depreciationId);
}
