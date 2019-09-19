package com.juk.menu.service;

import com.juk.menu.model.AppRole;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    AppRole findById(int id);
}
