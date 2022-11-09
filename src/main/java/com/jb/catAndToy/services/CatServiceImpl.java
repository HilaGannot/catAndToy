package com.jb.catAndToy.services;

import com.jb.catAndToy.baens.Cat;
import com.jb.catAndToy.exception.CatSystemException;
import com.jb.catAndToy.exception.ErrMsg;
import com.jb.catAndToy.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*

Hila Gannot
11/8/2022 1:54

*/
@Service
public class CatServiceImpl implements CatService{

    @Autowired
    private CatRepository catRepository;


    @Override
    public void addCat(Cat cat) throws CatSystemException {
        int id = cat.getId();
        if(catRepository.existsById(id)){
            throw new CatSystemException(ErrMsg.ID_ALREADY_EXIST);
        }
        catRepository.save(cat);
    }

    @Override
    public void updateCat(int id, Cat cat) throws CatSystemException {
        if(!catRepository.existsById(id)){
            throw new CatSystemException(ErrMsg.ID_NOT_FOUND);
        }
        catRepository.saveAndFlush(cat);
    }

    @Override
    public void deleteCat(int id) throws CatSystemException {
        if(!catRepository.existsById(id)){
            throw new CatSystemException(ErrMsg.ID_NOT_FOUND);
        }
        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getSingletCat(int id) throws CatSystemException {
        return catRepository.findById(id).orElseThrow(()->new CatSystemException(ErrMsg.ID_NOT_FOUND));
    }

    @Override
    public List<Cat> findByNameAndWeight(String name, double weight) throws CatSystemException {
        if(weight < 0){
            throw new CatSystemException(ErrMsg.WEIGHT_MUST_BR_MORE_THAN_ZERO);
        }
        return catRepository.findByNameAndWeight(name, weight);
    }

    @Override
    public List<Cat> findByNameOrWeight(String name, double weight) throws CatSystemException {
        if(weight < 0){
            throw new CatSystemException(ErrMsg.WEIGHT_MUST_BR_MORE_THAN_ZERO);
        }
        return catRepository.findByNameOrWeight(name, weight);
    }

    @Override
    public List<Cat> findByOrderByWeightDesc() {
        return catRepository.findByOrderByWeightAsc();
    }

    @Override
    public List<Cat> findByOrderByWeightAsc() {
        return catRepository.findByOrderByWeightDesc();
    }


    @Override
    public List<Cat> findByNameStartingWith(String startName) {
        return catRepository.findByNameStartingWith(startName);
    }

    @Override
    public double avgAllWe() {
        return catRepository.avgAllWeight();
    }
}
