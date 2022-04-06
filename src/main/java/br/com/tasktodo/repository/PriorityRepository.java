package br.com.tasktodo.repository;

import java.util.List;

import br.com.tasktodo.entity.PriorityEntity;

public interface PriorityRepository {
	
	public void create(PriorityEntity priorityEntity);
	
	public void priorityInit();
	
	public List<PriorityEntity> findAll();
	
}
