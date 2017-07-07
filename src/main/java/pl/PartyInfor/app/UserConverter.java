package pl.PartyInfor.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.PartyInfor.entity.User;
import pl.PartyInfor.repository.UserRepository;

public class UserConverter implements Converter<String, User>{


	@Autowired
	private UserRepository UserRepository;

	@Override
	public User convert(String source) {
		User user = UserRepository.findOne((long) Integer.parseInt(source));
		return user;

	}

}
