package ch.bfh.ti.cookingWebapp.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UnitServices {
    private UnitRepository unitRepository;

    @Autowired
    public UnitServices(UnitRepository unitRepository) {
        super();
        this.unitRepository = unitRepository;
    }

    public List<Unit> getAllUnits() {
        List<Unit> units = new ArrayList<>();
        this.unitRepository.findAll().forEach(units::add);
        return units;
    }

    public void addUnit(String unitName) {
        Unit unit = new Unit(unitName);
        this.unitRepository.save(unit);
    }
}

