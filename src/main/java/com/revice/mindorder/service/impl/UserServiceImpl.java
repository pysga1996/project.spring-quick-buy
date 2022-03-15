package com.revice.mindorder.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revice.mindorder.model.dto.SettingDTO;
import com.revice.mindorder.model.dto.UserDTO;
import com.revice.mindorder.model.dto.UserProfileDTO;
import com.revice.mindorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final ObjectMapper objectMapper;

    @Autowired
    public UserServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof OAuth2AuthenticatedPrincipal) {
            OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(principal.getAttribute("id"));
            userDTO.setUsername(principal.getName());
            userDTO.setAuthorities(new HashSet<>(principal.getAuthorities()));
            UserProfileDTO userProfile = this.objectMapper
                    .convertValue(principal.getAttribute("profile"), UserProfileDTO.class);
            userDTO.setUserProfile(userProfile);
            SettingDTO setting = this.objectMapper
                    .convertValue(principal.getAttribute("setting"), SettingDTO.class);
            userDTO.setSetting(setting);
            return userDTO;
        }
        return null;
    }

}
