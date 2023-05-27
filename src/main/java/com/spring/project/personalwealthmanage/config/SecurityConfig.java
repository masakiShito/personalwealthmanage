package com.spring.project.personalwealthmanage.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SpringSecurityの認証設定
 *
 * @author　masaking
 * @version　1.0.0
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	/**
	 * ログイン・ログアウト・権限についての設定
	 * それぞれの設定内容については、各コメントを参照
	 *
	 * @author　masaking
	 * @version　1.0.0
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.formLogin(form -> form
						/* ログイン情報の送信先URL*/
						.loginProcessingUrl("/pwm_001")
						/* ログイン画面のURL(カスタムログイン画面)*/
						.loginPage("/pwm_001")
						/* ログインに成功した場合のリダイレクト先URL*/
						.defaultSuccessUrl("/")
						/* ログインに失敗した場合のリダイレクト先URL*/
						.failureUrl("/pwm_001?error=true")
				)
				.logout(logout -> logout
						/* ログアウト成功時の遷移先*/
						.logoutSuccessUrl("/pwm_001")
				)
				.authorizeHttpRequests(authz -> authz
						/* 静的ファイル（"/css/**"など）はログインなしでもアクセス可能とする*/
						.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
						/* ログイン画面は未ログインでもアクセス可能にする*/
						.requestMatchers("/pwm_001").permitAll()
						/* "/admin"はADMIN権限を持っている人のみアクセス可能*/
						.requestMatchers("/admin").hasRole("ADMIN")
						/* 他のURLはログイン後のみアクセス可能*/
						.anyRequest().authenticated()
				);

		return http.build();
	}


	/**
	 * パスワードをハッシュ化
	 *  passwordEncoderを呼び出すことでパスワードをハッシュ化
	 *
	 * @author まさき
	 * @version 1.1
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {

		/* SpringSecurityに内包されているハッシュ化するためのクラス*/
		return new BCryptPasswordEncoder();
	}
}
