package com.juk.menu.service;

import com.juk.menu.model.AppUser;

public interface UserService {
    AppUser findByUserName(String userName);

    void save(AppUser appUser);
}
