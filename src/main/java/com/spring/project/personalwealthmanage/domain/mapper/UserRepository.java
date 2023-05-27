package com.spring.project.personalwealthmanage.domain.mapper;

import java.util.List;
import java.util.Optional;

import com.spring.project.personalwealthmanage.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRepository {
	/* ユーザIDからユーザ情報を取得*/
	Optional<User> findByUserId(String userId);
	
}
