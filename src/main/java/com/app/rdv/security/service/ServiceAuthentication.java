package com.app.rdv.security.service;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import com.app.rdv.security.repositories.AppRoleRepository;
import com.app.rdv.security.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuthentication implements IServiceAuthentication {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ServiceAuthentication(AppUserRepository appUserRepository,
                                 AppRoleRepository appRoleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser createAppUser(AppUser appUser) {
        // Vérification d'unicité du username
        if (appUserRepository.findByUsername(appUser.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Cryptage du mot de passe
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        // Sauvegarde de l'utilisateur
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole createAppRole(AppRole appRole) {
        // Vérification d'unicité du rôle
        if (appRoleRepository.findByRole(appRole.getRole()) != null) {
            throw new RuntimeException("Role already exists");
        }

        // Sauvegarde du rôle
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {

    }

    @Override
    public AppUser LoadUserName(String username) {
        return null;
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public AppRole findByRole(String role) {
        return appRoleRepository.findByRole(role);
    }
}
