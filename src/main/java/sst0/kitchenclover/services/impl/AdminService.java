package sst0.kitchenclover.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sst0.kitchenclover.models.Admin;
import sst0.kitchenclover.repository.AdminRepository;
import sst0.kitchenclover.services.IAdminService;

/**
 * @author Miles
 */
@Service
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin save(Admin entity) {
        return adminRepository.save(entity);
    }

    @Override
    public Admin update(Admin entity) {
        return adminRepository.save(entity);
    }

    @Override
    public void delete(Admin entity) {
        adminRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin find(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Admin> users) {
        adminRepository.deleteInBatch(users);
    }

}
