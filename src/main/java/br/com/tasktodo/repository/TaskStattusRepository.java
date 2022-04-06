package br.com.tasktodo.repository;

import java.util.List;

import br.com.tasktodo.entity.TaskStattusEntity;

public interface TaskStattusRepository {

	public void create(TaskStattusEntity priorityEntity);
	
	public void taskStattusInit();
	
	public List<TaskStattusEntity> findAll();
	
}
