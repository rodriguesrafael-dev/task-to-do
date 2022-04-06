package br.com.tasktodo.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tasktodo.entity.PriorityEntity;
import br.com.tasktodo.services.PriorityServices;

import lombok.Data;

@Data
@Component
@ManagedBean(name = "priorityManagedBean")
@SessionScoped
public class PriorityManagedBean {
	
	@Autowired
	public PriorityServices priorityServices;
	
	private PriorityEntity priorityEntity;
	
	private List<PriorityEntity> priorityList;
	
	public void priorityInit() {
		this.priorityServices.priorityInit();
	}
	
	public List<PriorityEntity> priorityList() {
		this.priorityList = priorityServices.findAll();
		return priorityList;
	}

}
