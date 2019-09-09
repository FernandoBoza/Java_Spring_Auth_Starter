package com.starter_kit.auth.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.starter_kit.auth.Utils.Utils.*;
import static com.starter_kit.auth.Utils.Constants.*;


@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        User u = findUserByEmail(user.getEmail());
        if (u.getEmail().equals(user.getEmail())) {
            return null;
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRole(ADMIN);
            return userRepo.save(user);
        }
    }

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    public User findById(String id) {
        return getFromOptional(userRepo.findById(id));
    }

    public User findUserByName(String name) {
        return userRepo.findUserByName(name);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(email);
        if (user != null){
            List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
            return buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    private List<GrantedAuthority> getUserAuthority(String userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(userRoles));

        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities){
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
