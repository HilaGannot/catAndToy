package com.jb.catAndToy.repos;
/*

Hila Gannot
11/8/2022 11:33

*/

import com.jb.catAndToy.baens.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy,Integer> {
}
