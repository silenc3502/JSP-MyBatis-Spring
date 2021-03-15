package com.example.mybatismember.controller;

import com.example.mybatismember.entity.Member;
import com.example.mybatismember.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class MemberController {

	private final MemberService service;

	@GetMapping("/register")
	public void registerForm(Member member, Model model) throws Exception {

	}

	@PostMapping("/register")
	public String register(Member member, Model model) throws Exception {
		service.register(member);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "user/success";
	}

}
