package com.example.demo.controller;

import com.example.demo.model.Section;
import com.example.demo.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;

    // CREATE section
    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionRepository.save(section);
    }

    // READ all sections
    @GetMapping
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    // READ single section
    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    // UPDATE section
    @PutMapping("/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section sectionDetails) {
        Section section = sectionRepository.findById(id).orElse(null);
        if (section != null) {
            section.setName(sectionDetails.getName());
            section.setDescription(sectionDetails.getDescription());
            return sectionRepository.save(section);
        }
        return null;
    }

    // DELETE section
    @DeleteMapping("/{id}")
    public String deleteSection(@PathVariable Long id) {
        sectionRepository.deleteById(id);
        return "Section deleted with id: " + id;
    }
}
