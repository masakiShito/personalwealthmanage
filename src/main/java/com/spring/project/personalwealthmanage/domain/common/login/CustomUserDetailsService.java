package com.spring.project.personalwealthmanage.domain.common.login;

import com.spring.project.personalwealthmanage.domain.entity.User;
import com.spring.project.personalwealthmanage.domain.mapper.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* SpringSecurityの認証処理
* SpringSecurityの規約に習い認証処理を実装
* @author　masaking
* @version　1.0.0
*/

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		return userRepository.findByUserId(username)
				.map(
						user -> new CustomUserDetails(
								user.getUserId(),
								user.getUserPw(),
								toGrantedAuthorityList(user.getUserAuth())))
				.orElseThrow(
						() -> new UsernameNotFoundException(
								"Given username is not found. (username = '" + username + "')"));

	}

	private List<GrantedAuthority> toGrantedAuthorityList(User.UserAuth userAuth){
		return Collections.singletonList(new SimpleGrantedAuthority(userAuth.name()));
	}

}
