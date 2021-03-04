package sst0.kitchenclover.repository;

import org.springframework.stereotype.Repository;
import sst0.kitchenclover.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    //User findByEmail(String email);
}
