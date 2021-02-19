/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sst0.kitchenclover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sst0.kitchenclover.models.adminpage;


@Repository
public interface adminpageRepository extends JpaRepository<adminpage, Long> {

	//User findByEmail(String email);
}
