package com.org.kelvo.assetmanagement.Services.templates;

import com.org.kelvo.assetmanagement.Entities.Custodian;
import com.org.kelvo.assetmanagement.Repositories.CustodianRepository;
import com.org.kelvo.assetmanagement.Services.CustodianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustodianServiceImpl implements CustodianService {
    @Autowired
    private CustodianRepository custodianRepository;

    @Override
    public List<Custodian> getAllCUstodians() {
        return custodianRepository.findAll();
    }

    @Override
    public Custodian saveCustodian(Custodian custodian) {
        return custodianRepository.save(custodian);
    }

    @Override
    public Optional<Custodian> getCustodianById(Long custodianId) {
        return custodianRepository.findById(custodianId);
    }
}
