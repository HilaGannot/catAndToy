package com.jb.catAndToy.services;
/*

Hila Gannot
11/8/2022 1:51

*/

import com.jb.catAndToy.baens.COLOR;
import com.jb.catAndToy.baens.Cat;
import com.jb.catAndToy.exception.CatSystemException;

import java.util.List;

public interface CatService {
    void addCat(Cat cat) throws CatSystemException;
    void updateCat(int id, Cat cat) throws CatSystemException;
    void deleteCat(int id) throws CatSystemException;
    List<Cat> getAllCats();
    Cat getSingletCat(int id) throws CatSystemException;
    List<Cat> findByNameAndWeight(String name, double weight) throws CatSystemException;
    List<Cat> findByNameOrWeight(String name, double weight) throws CatSystemException;
    List<Cat> findByOrderByWeightDesc();
    List<Cat> findByOrderByWeightAsc();
    List<Cat> findByNameStartingWith(String startName);
    double avgAllWe();
}
