package com.spring.project.personalwealthmanage.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	/* ユーザID*/
	private String userId;
	/* ユーザ名*/
	private String userNm;
	/* パスワード*/
	private String userPw;
	/* 権限*/
	private UserAuth userAuth;
	/* 削除フラグ*/
	private String delFlg;
	/* 登録者*/
	private String insDy;
	/* 登録日*/
	private String insTime;
	/* 更新者*/
	private String updBy;
	/* 更新日*/
	private String updTime;

	/* 権限の列挙型*/
	public enum UserAuth {
		ADMIN,
		GENERAL
	}
}
