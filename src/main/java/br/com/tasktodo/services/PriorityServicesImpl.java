package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.entity.PriorityEntity;
import br.com.tasktodo.repository.PriorityRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class PriorityServicesImpl implements PriorityServices {

	@Autowired
	private PriorityRepository priorityRepository;
	
	@Override
	public void create(PriorityEntity priorityEntity) {
		priorityRepository.create(priorityEntity);
		
	}
	
	@Override
	public void priorityInit() {
		priorityRepository.priorityInit();
	}
	
	@Override
	public List<PriorityEntity> findAll() {
		return priorityRepository.findAll();
	}
	
}
