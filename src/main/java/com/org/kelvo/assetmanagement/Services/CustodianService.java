package com.org.kelvo.assetmanagement.Services;

import com.org.kelvo.assetmanagement.Entities.Custodian;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustodianService {
    List<Custodian> getAllCUstodians();

    Custodian saveCustodian(Custodian custodian);

    Optional<Custodian> getCustodianById(Long custodianId);
}
