package br.com.tasktodo.repository;

import java.util.List;

import br.com.tasktodo.entity.TaskEntity;

public interface TaskRepository {

	public void create(TaskEntity taskEntity);
	
	public void update(TaskEntity taskEntity);

	public void delete(TaskEntity taskEntity);
	
	public List<TaskEntity> listTaskFilter(long id, String title, String userEntity, String taskStattusEntity);
	
	public List<TaskEntity> findAll();
	
	public List<TaskEntity> listTaskStattus();
	
}
