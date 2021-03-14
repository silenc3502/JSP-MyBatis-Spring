package com.example.demo.controller;

import com.example.demo.entity.JSPBoard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/boards")
public class BoardController {

    @GetMapping(value = "/{boardNo}", produces = "application/xml")
    public ResponseEntity<JSPBoard> readToXml(@PathVariable("boardNo") int boardNo) {
        log.debug("readToXml()");

        JSPBoard board = new JSPBoard();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("작성자");
        board.setRegDate(LocalDateTime.now());

        ResponseEntity<JSPBoard> entity = new ResponseEntity<JSPBoard>(board, HttpStatus.OK);

        return entity;
    }

    @GetMapping(value = "/{boardNo}", produces = "application/json")
    public ResponseEntity<JSPBoard> readToJson(@PathVariable("boardNo") int boardNo) {
        log.debug("readToJson()");

        JSPBoard board = new JSPBoard();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("작성자");
        board.setRegDate(LocalDateTime.now());

        ResponseEntity<JSPBoard> entity = new ResponseEntity<JSPBoard>(board, HttpStatus.OK);

        return entity;
    }

    @GetMapping(value = "/{boardNo}")
    public ResponseEntity<JSPBoard> read(@PathVariable("boardNo") int boardNo) {
        log.debug("read()");

        JSPBoard board = new JSPBoard();
        board.setTitle("제목");
        board.setContent("내용");
        board.setWriter("작성자");
        board.setRegDate(LocalDateTime.now());

        ResponseEntity<JSPBoard> entity = new ResponseEntity<JSPBoard>(board, HttpStatus.OK);

        return entity;
    }
}
