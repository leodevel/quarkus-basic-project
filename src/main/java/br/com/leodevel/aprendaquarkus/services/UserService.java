package br.com.leodevel.aprendaquarkus.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.leodevel.aprendaquarkus.dto.request.UserRequestDTO;
import br.com.leodevel.aprendaquarkus.dto.response.UserResponseDTO;
import br.com.leodevel.aprendaquarkus.models.User;
import br.com.leodevel.aprendaquarkus.repositories.UserRepository;

@ApplicationScoped
@Transactional
public class UserService {

	@Inject
	UserRepository userRepository;

	public List<UserResponseDTO> findUsers(){
		return userRepository
				.streamAll()
				.map(UserResponseDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	public UserResponseDTO save(UserRequestDTO userRequestDTO) {		
		User user = User.fromDTO(userRequestDTO);
		userRepository.persistAndFlush(user);
		return UserResponseDTO.fromEntity(user);		
	}
	
}