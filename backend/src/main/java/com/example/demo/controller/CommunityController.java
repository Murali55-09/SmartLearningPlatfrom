package com.example.demo.controller;

import com.example.demo.model.Community;
import com.example.demo.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    // CREATE community
    @PostMapping
    public Community createCommunity(@RequestBody Community community) {
        return communityService.createCommunity(community);
    }

    // READ all communities
    @GetMapping
    public List<Community> getAllCommunities() {
        return communityService.getAllCommunities();
    }

    // READ single community
    @GetMapping("/{id}")
    public Community getCommunityById(@PathVariable Long id) {
        return communityService.getCommunityById(id);
    }

    // UPDATE community
    @PutMapping("/{id}")
    public Community updateCommunity(@PathVariable Long id, @RequestBody Community communityDetails) {
        return communityService.updateCommunity(id, communityDetails);
    }

    // DELETE community
    @DeleteMapping("/{id}")
    public String deleteCommunity(@PathVariable Long id) {
        communityService.deleteCommunity(id);
        return "Community deleted with id: " + id;
    }
}
