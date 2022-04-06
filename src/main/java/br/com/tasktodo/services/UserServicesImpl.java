package br.com.tasktodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.tasktodo.entity.UserEntity;
import br.com.tasktodo.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void create(UserEntity userEntity) {
		userRepository.create(userEntity);	
	}

	@Override
	public void update(UserEntity userEntity) {
		userRepository.update(userEntity);
	}
	
	@Override
	public void delete(UserEntity userEntity) {
		userRepository.delete(userEntity);
	}
	
	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

}
