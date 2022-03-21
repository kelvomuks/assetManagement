package com.org.kelvo.assetmanagement.Services.templates;

import com.org.kelvo.assetmanagement.Entities.Depreciation;
import com.org.kelvo.assetmanagement.Repositories.DepreciationRepository;
import com.org.kelvo.assetmanagement.Services.DepreciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepreciationServiceImpl implements DepreciationService {

    @Autowired
    private DepreciationRepository depreciationRepository;

    @Override
    public List<Depreciation> getAllDepreciations() {
        return depreciationRepository.findAll();
    }

    @Override
    public Depreciation addDepreciation(Depreciation depreciation) {
        return depreciationRepository.save(depreciation);
    }

    @Override
    public Optional<Depreciation> findDepreciationById(Long depreciationId) {
        return depreciationRepository.findById(depreciationId);
    }
}
