package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
	// Spring Security에서 인증을 담당하는 서비스
	// UserDetailsService 인터페이스의 정의된 메소드를 오버라이딩 해서 구현

	private final UserRepository userRepository;
	
	// 인증을 처리하는 메소드
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// login.html.html에서 username, password 넘어오는 username 인풋으로 받음.
		// DB에서 인풋으로 넘어오는 username 값을 DB에서 조회
		Optional<SiteUser> _siteUser = userRepository.findByusername(username);
		
		if (_siteUser.isEmpty()) {
			// DB에서 해당 username이 존재하지 않을 경우
				// 강제로 예외를 발생 시켜 뷰 페이지에서 오류 메세지 출력함
			throw new UsernameNotFoundException("해당 사용자는 데이터베이스에서 찾을 수 없습니다.");
		}
		
		// _siteUser의 값이 비어있지 않으면 SiteUser를 끄집어 냄.
		SiteUser siteUser = _siteUser.get();
		
		// GrantedAuthority: 권한을 부여하는 객체
		List<GrantedAuthority> authorities = new ArrayList();
			// GrantedAutority 인터페이스: 메소드 선언만 되어 있음.
				// SimpleGrantedAuthority: GrantedAutority 인터페이스의 메소드를 구현한 클래스
		
		
		// 관리자인지 사용자인지 처리함.
			// username의 값이 admin이라면: 관리자 권한을 부여
			// username의 값이 admin이 아니라면: 일반 사용자 권한 부여
		
		if ("admin".equals(username)) {
			// username 필드의 값이 admin이라면 관리자 권한을 부여: ADMIN("ROLE_ADMIN")
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
			
		}else {
			// username 필드의 값이 admin이 아니라면 일반 사용자 권한을 부여: USER("ROLE_USER")
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
			
		}

		// UserDetails: 인터페이스
		// User: UserDetails 인터페이스를 구현한 객체
		// User (username, password, 권한)
		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
	}
	
	
}
