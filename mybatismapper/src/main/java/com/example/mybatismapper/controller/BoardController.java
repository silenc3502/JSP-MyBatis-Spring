package com.example.mybatismapper.controller;

import com.example.mybatismapper.entity.Board;
import com.example.mybatismapper.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

	private final BoardService service;

	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception {
		
	}

	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		service.register(board);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("list", service.list());
	}

	@GetMapping("/read")
	public void read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		service.remove(boardNo);

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/modify")
	public void modifyForm(int boardNo, Model model) throws Exception {
		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/modify")
	public String modify(Board board, Model model) throws Exception {
		service.modify(board);

		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "board/success";
	}

}
