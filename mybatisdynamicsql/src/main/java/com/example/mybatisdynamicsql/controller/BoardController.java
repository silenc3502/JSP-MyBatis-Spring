package com.example.mybatisdynamicsql.controller;

import com.example.mybatisdynamicsql.entity.Board;
import com.example.mybatisdynamicsql.service.BoardService;
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

	@PostMapping("/search")
	public String search(String title, Model model) throws Exception {
		Board board = new Board();
		board.setTitle(title);

		model.addAttribute("board", board);

		model.addAttribute("list", service.search(title));

		return "board/list";
	}

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		model.addAttribute("board", new Board());

		model.addAttribute("list", service.list());
	}

	@PostMapping("/modify")
	public String modify(Board board, Model model) throws Exception {
		service.modify(board);

		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/modify")
	public void modifyForm(int boardNo, Model model) throws Exception {

		model.addAttribute(service.read(boardNo));
	}

	@GetMapping("/read")
	public void read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {

		model.addAttribute(service.read(boardNo));
	}

	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		service.register(board);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "board/success";
	}

	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception {

	}

	@PostMapping("/remove")
	public String remove(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		service.remove(boardNo);

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "board/success";
	}

}
