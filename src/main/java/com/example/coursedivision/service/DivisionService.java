package com.example.coursedivision.service;

import com.example.coursedivision.entity.Division;
import com.example.coursedivision.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    public List<Division> getAllDivisions() {
        return divisionRepository.findAll();
    }

    public Division getDivisionById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    public Division addDivision(Division division) {
        return divisionRepository.save(division);
    }

    public Division updateDivision(Long id, Division division) {
        Division existingDivision = divisionRepository.findById(id).orElse(null);
        if (existingDivision != null) {
            division.setId(id);
            return divisionRepository.save(division);
        }
        return null;
    }

    public void deleteDivision(Long id) {
        divisionRepository.deleteById(id);
    }
}
