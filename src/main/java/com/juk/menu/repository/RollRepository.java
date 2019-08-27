package com.juk.menu.repository;

import com.juk.menu.model.Composition;
import com.juk.menu.model.Roll;
import com.juk.menu.model.TypeOfRollEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface RollRepository extends CrudRepository<Roll, Long> {
//    List<Roll> findRollsByType(Collection<TypeOfRollEnum> types);
//
//    List<Roll> findRollsByComposition(Composition composition);
//    List<Roll> findRollsByName(String name);
//    List<Roll> filterRollsByPrice(Integer price);
}
