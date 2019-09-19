package com.juk.menu.service;

import com.juk.menu.model.AppRole;
import com.juk.menu.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public AppRole findById(int id){
        return roleRepository.findById( id );
    }
}

