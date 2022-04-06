package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.entity.TaskEntity;

import br.com.tasktodo.repository.TaskRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class TaskServicesImpl implements TaskServices {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void create(TaskEntity taskEntity) {
		taskRepository.create(taskEntity);	
	}

	@Override
	public void update(TaskEntity taskEntity) {
		taskRepository.update(taskEntity);
	}
	
	@Override
	public void delete(TaskEntity taskEntity) {
		taskRepository.delete(taskEntity);
	}
	
	@Override
	public List<TaskEntity> listTaskFilter(long id, String title, String userEntity, String taskStattusEntity) {
		return taskRepository.listTaskFilter(id, title, userEntity, taskStattusEntity);
	}
	
	@Override
	public List<TaskEntity> findAll() {
		return taskRepository.findAll();
	}
	
	@Override
	public List<TaskEntity> listTaskStattus() {
		return taskRepository.listTaskStattus();
	}
	
}
