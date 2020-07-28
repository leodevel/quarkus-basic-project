package br.com.leodevel.quarkusbasicproject.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.leodevel.quarkusbasicproject.dto.request.UserRequestDTO;
import br.com.leodevel.quarkusbasicproject.dto.response.UserResponseDTO;
import br.com.leodevel.quarkusbasicproject.models.User;
import br.com.leodevel.quarkusbasicproject.repositories.UserRepository;

@ApplicationScoped
public class UserService {

	@Inject
	UserRepository userRepository;

	public List<UserResponseDTO> findUsers(){
		return userRepository
				.streamAll()
				.map(UserResponseDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public UserResponseDTO save(UserRequestDTO userRequestDTO) {		
		User user = User.fromDTO(userRequestDTO);
		userRepository.persistAndFlush(user);
		return UserResponseDTO.fromEntity(user);		
	}
	
	public UserResponseDTO findByUsername(String username) {
		User user = userRepository
				.find("SELECT u FROM User u WHERE u.username = ?1", username)
				.firstResult();

		if (user == null)
			return null;

		return UserResponseDTO.fromEntity(user);
	}
	
	public User login(String username, String password) {	
		User user = userRepository
				.find("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2", username, password)
				.firstResult();
		return user;
			
	}
	
}