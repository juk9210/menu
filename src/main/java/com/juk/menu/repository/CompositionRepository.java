package com.juk.menu.repository;

import com.juk.menu.model.Composition;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompositionRepository extends CrudRepository<Composition,Long> {
//    Optional <Composition>  getCompositionByName(String name);
}
