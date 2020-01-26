package com.retailsuper.priceengine.repository;

import com.retailsuper.priceengine.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Setting, String> {
    Setting findByCode(String code);
}
