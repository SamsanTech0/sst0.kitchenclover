package sst0.kitchenclover.repository;

import org.springframework.stereotype.Repository;
import sst0.kitchenclover.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    //User findByEmail(String email);
}
