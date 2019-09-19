package com.juk.menu.repository;

import com.juk.menu.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String roleName);

    AppRole findById(Integer id);

}
