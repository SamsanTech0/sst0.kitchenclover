package sst0.kitchenclover.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sst0.kitchenclover.models.Receipt;
import sst0.kitchenclover.repository.ReceiptRepository;
import sst0.kitchenclover.services.IReceiptService;

/**
 * @author Miles
 */
@Service
public class ReceiptService implements IReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public Receipt save(Receipt entity) {
        return receiptRepository.save(entity);
    }

    @Override
    public Receipt update(Receipt entity) {
        return receiptRepository.save(entity);
    }

    @Override
    public void delete(Receipt entity) {
        receiptRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        receiptRepository.deleteById(id);
    }

    @Override
    public Receipt find(Long id) {
        return receiptRepository.findById(id).orElse(null);
    }

    @Override
    public List<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Receipt> users) {
        receiptRepository.deleteInBatch(users);
    }

}
