package com.hcl.msastudio.service;

import com.hcl.msastudio.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
