package sst0.kitchenclover.services.impl;

import sst0.kitchenclover.models.adminpage;
import sst0.kitchenclover.repository.AdminPageRepository;
import sst0.kitchenclover.service.IAdminPageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPageService implements IAdminPageService {
	
	@Autowired
	private AdminPageRepository adminPRepository;
	
	@Override
	public adminpage save(adminpage entity) {
		return adminPRepository.save(entity);
	}

	@Override
	public adminpage update(adminpage entity) {
		return adminPRepository.save(entity);
	}

	@Override
	public void delete(adminpage entity) {
		adminPRepository.delete(entity);
	}
          

	@Override
	public void delete(Long id) {
		adminPRepository.deleteById(id);
	}

	@Override
	public adminpage find(Long id) {
		return adminPRepository.findById(id).orElse(null);
	}

	@Override
	public List<adminpage> findAll() {
		return adminPRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<adminpage> reservation) {
		adminPRepository.deleteInBatch(reservation);
	}
	
}