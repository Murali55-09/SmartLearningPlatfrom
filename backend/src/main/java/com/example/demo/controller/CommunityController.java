package com.example.demo.controller;

import com.example.demo.model.Community;
import com.example.demo.repository.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityRepository communityRepository;

    // CREATE community
    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityRepository.save(community);
    }

    // READ all communities
    @GetMapping
    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    // READ single community
    @GetMapping("/{id}")
    public Community getCommunityById(@PathVariable Long id) {
        return communityRepository.findById(id).orElse(null);
    }

    // UPDATE community
    @PutMapping("/{id}")
    public Community updateCommunity(@PathVariable Long id, @RequestBody Community communityDetails) {
        Community community = communityRepository.findById(id).orElse(null);
        if (community != null) {
            community.setName(communityDetails.getName());
            community.setDescription(communityDetails.getDescription());
            return communityRepository.save(community);
        }
        return null;
    }

    // DELETE community
    @DeleteMapping("/{id}")
    public String deleteCommunity(@PathVariable Long id) {
        communityRepository.deleteById(id);
        return "Community deleted with id: " + id;
    }
}
