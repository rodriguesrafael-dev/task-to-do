package br.com.tasktodo.services;

import java.util.List;

import br.com.tasktodo.entity.PriorityEntity;

public interface PriorityServices {
	
	public void create(PriorityEntity priorityEntity);
	
	public void priorityInit();
	
	public List<PriorityEntity> findAll();
	
}
