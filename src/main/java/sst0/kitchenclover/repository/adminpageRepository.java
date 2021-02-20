package sst0.kitchenclover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sst0.kitchenclover.models.adminpage;


@Repository
public interface AdminPageRepository extends JpaRepository<adminpage, Long> {

//	adminpage findByEmail(String email);
}
