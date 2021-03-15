package com.example.mybatismember.repository;

import com.example.mybatismember.entity.Member;
import com.example.mybatismember.entity.MemberAuth;

public interface MemberMapper {

	public void create(Member member) throws Exception;

	public void createAuth(MemberAuth memberAuth) throws Exception;

}
