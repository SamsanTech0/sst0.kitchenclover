package sst0.kitchenclover.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sst0.kitchenclover.models.Catering;
import sst0.kitchenclover.repository.CateringRepository;
import sst0.kitchenclover.services.ICateringService;

/**
 * @author Miles
 */
@Service
public class CateringService implements ICateringService {

    @Autowired
    private CateringRepository cateringRepository;

    @Override
    public Catering save(Catering entity) {
        return cateringRepository.save(entity);
    }

    @Override
    public Catering update(Catering entity) {
        return cateringRepository.save(entity);
    }

    @Override
    public void delete(Catering entity) {
        cateringRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        cateringRepository.deleteById(id);
    }

    @Override
    public Catering find(Long id) {
        return cateringRepository.findById(id).orElse(null);
    }

    @Override
    public List<Catering> findAll() {
        return cateringRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Catering> users) {
        cateringRepository.deleteInBatch(users);
    }

}
