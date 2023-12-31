package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor	// DI: 생성자를 통한 객체 주입 방식
@Service
public class UserService {
	// Client ==> Controller ==> Service ==> Repository == > Entity ==> DB Table
	
	@Autowired
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	// Controller: id, password, email 받아서 DB에 저장하는 메소드
	public SiteUser create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		
		// 매개변수의 값을 받아서 setter 주입
		user.setUsername(username);
		user.setEmail(email);
		
		// 패스워드 암호화 처리 후 setter 주입
		// 메소드 내부에서 암호화 객체를 생성하면 암호화 키가 변경 될 때 수정하기가 어렵다
		// 스프링이 부팅될 때 IoC 컨테이너에 객체를 생성하고 DI를 통해서 사용
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// 패스워드 암호화 해서 주입
		user.setPassword(passwordEncoder.encode(password));
		
		userRepository.save(user);
		
		
		return user;
	}
	
	// 사용자 정보를 읽어오는 메소드
	public void selectUser(String username) {
		
		Optional<SiteUser> Ouser=
		userRepository.findByusername(username);
		
		// 
		if(Ouser.isPresent()) {
			System.out.println(username + "는 존재하는 사용자 입니다.");
			
			SiteUser user = Ouser.get();
			System.out.println("username: " + user.getUsername());
			System.out.println("email: " + user.getEmail());
			System.out.println("password: " + user.getPassword());
			
		}else {
			System.out.println(username + "는 존재하지 않는 사용자 입니다.");
		}
	}
	
	// username을 받아서 DB에서 값을 읽어오는 메소드
	public SiteUser getUser(String username) {
		
		Optional <SiteUser> _siteUser = userRepository.findByusername(username);
		
		if ( _siteUser.isPresent()) {
			// 값이 DB에 존재할 경우
			return _siteUser.get();
		}else {
			// 값이 DB에 존재하지 않는 경우
			throw new DataNotFoundException("사용자가 DB에 존재하지 않습니다.");
		}
		
	}
	
}
