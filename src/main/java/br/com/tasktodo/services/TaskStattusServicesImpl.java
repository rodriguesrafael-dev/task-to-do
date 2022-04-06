package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.entity.TaskStattusEntity;
import br.com.tasktodo.repository.TaskStattusRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class TaskStattusServicesImpl implements TaskStattusServices {

	@Autowired
	private TaskStattusRepository taskStattusRepository;
	
	@Override
	public void create(TaskStattusEntity taskStattusEntity) {
		taskStattusRepository.create(taskStattusEntity);	
	}
	
	@Override
	public void taskStattusInit() {
		taskStattusRepository.taskStattusInit();
	}

	@Override
	public List<TaskStattusEntity> findAll() {
		return taskStattusRepository.findAll();
	}
	
}
