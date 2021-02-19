package sst0.kitchenclover.services.impl;

import sst0.kitchenclover.models.adminpage;
import sst0.kitchenclover.repository.adminpageRepository;
import sst0.kitchenclover.service.IadminpageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminpageService implements IadminpageService {
	
	@Autowired
	private adminpageRepository adminpageRepository;
	
	@Override
	public adminpage save(adminpage entity) {
		return adminpageRepository.save(entity);
	}

	@Override
	public adminpage update(adminpage entity) {
		return adminpageRepository.save(entity);
	}

	@Override
	public void delete(adminpage entity) {
		adminpageRepository.delete(entity);
	}
          

	@Override
	public void delete(Long id) {
		adminpageRepository.deleteById(id);
	}

	@Override
	public adminpage find(Long id) {
		return adminpageRepository.findById(id).orElse(null);
	}

	@Override
	public List<adminpage> findAll() {
		return adminpage.findAll();
	}

	@Override
	public void deleteInBatch(List<adminpage> adminpage) {
		adminpage.deleteInBatch(adminpage);
	}
	
}