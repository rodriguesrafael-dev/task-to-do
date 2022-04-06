package br.com.tasktodo.services;

import java.util.List;

import br.com.tasktodo.entity.UserEntity;

public interface UserServices {

	public void create(UserEntity userEntity);
	
	public void update(UserEntity userEntity);

	public void delete(UserEntity userEntity);
	
	public List<UserEntity> findAll();
	
}
