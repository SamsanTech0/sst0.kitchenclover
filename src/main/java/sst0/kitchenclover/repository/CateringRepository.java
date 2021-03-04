package sst0.kitchenclover.repository;

import org.springframework.stereotype.Repository;
import sst0.kitchenclover.models.Catering;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CateringRepository extends JpaRepository<Catering, Long> {
    //User findByEmail(String email);
}
