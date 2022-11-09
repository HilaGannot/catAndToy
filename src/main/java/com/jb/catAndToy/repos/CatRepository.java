package com.jb.catAndToy.repos;
/*

Hila Gannot
11/8/2022 11:37

*/

import com.jb.catAndToy.baens.COLOR;
import com.jb.catAndToy.baens.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    List<Cat> findByNameAndWeight(String name, double weight);

    List<Cat> findByNameOrWeight(String name, double weight);

    List<Cat> findByOrderByWeightDesc();

    List<Cat> findByOrderByWeightAsc();

    int countCatByColor(COLOR color);
    List<Cat> findByNameStartingWith(String startName);
    @Query(value = "select avg (weight) from cats", nativeQuery = true)
    double avgAllWeight();
}
