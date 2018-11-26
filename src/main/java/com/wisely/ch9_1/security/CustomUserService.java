package com.wisely.ch9_1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wisely.ch9_1.dao.SysUserRepository;
import com.wisely.ch9_1.domain.SysUser;

public class CustomUserService implements UserDetailsService {	//1、自定义需实现UserDetailService接口
	
	@Autowired
	SysUserRepository userRepository;

	public UserDetails loadUserByUsername(String username){	//2、重写loadUserByUsername方法获得用户
		SysUser user = userRepository.findByUsername(username);
		if(null == user) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;	//3、我们当前的用户实现了UserDetails接口，可直接返回给SpringSecurity使用。
	}

}
