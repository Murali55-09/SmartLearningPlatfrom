package com.example.demo.service;

import com.example.demo.model.Community;
import com.example.demo.repository.CommunityRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    public Community getCommunityById(Long id) {
        return communityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Community not found with id " + id));
    }

    public Community updateCommunity(Long id, Community communityDetails) {
        Community community = getCommunityById(id);
        community.setName(communityDetails.getName());
        community.setDescription(communityDetails.getDescription());
        return communityRepository.save(community);
    }

    public void deleteCommunity(Long id) {
        Community community = getCommunityById(id);
        communityRepository.delete(community);
    }
}
