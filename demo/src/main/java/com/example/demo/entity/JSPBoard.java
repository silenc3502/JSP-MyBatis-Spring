package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class JSPBoard {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;

}