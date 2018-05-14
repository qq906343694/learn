package com.neo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by summer on 2017/5/5.
 */
@Data
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -3258839839160856613L;
	private Long id;
	private String userName;
	private String passWord;

	@Override
	public String toString() {
		return "UserEntity{" + "id=" + id + ", userName='" + userName + '\'' + ", passWord='" + passWord + '\'' + '}';
	}
}
