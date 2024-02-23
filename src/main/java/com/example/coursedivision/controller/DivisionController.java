package com.example.coursedivision.controller;

import com.example.coursedivision.entity.Division;
import com.example.coursedivision.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @GetMapping
    public ResponseEntity<List<Division>> getAllDivisions() {
        List<Division> divisions = divisionService.getAllDivisions();
        return ResponseEntity.ok(divisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Division> getDivisionById(@PathVariable("id") Long id) {
        Division division = divisionService.getDivisionById(id);
        if (division == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(division);
    }

    @PostMapping
    public ResponseEntity<Division> addDivision(@RequestBody Division division) {
        Division newDivision = divisionService.addDivision(division);
        return ResponseEntity.ok(newDivision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable("id") Long id, @RequestBody Division division) {
        Division updatedDivision = divisionService.updateDivision(id, division);
        if (updatedDivision == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDivision);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable("id") Long id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }
}
