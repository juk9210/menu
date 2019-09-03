package com.juk.menu.repository;


import com.juk.menu.model.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RollRepository extends JpaRepository<Roll, Long> {

    List<Roll> findByOrderByWeightAsc();

    List<Roll> findByOrderByWeightDesc();

    List<Roll> findByOrderByPriceAsc();

    List<Roll> findByOrderByPriceDesc();

    List<Roll> findByTypeOfRoll(String typeOfRoll);

}
