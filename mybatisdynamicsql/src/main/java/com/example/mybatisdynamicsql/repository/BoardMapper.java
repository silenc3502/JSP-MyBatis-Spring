package com.example.mybatisdynamicsql.repository;

import java.util.List;

import com.example.mybatisdynamicsql.entity.Board;
import org.apache.ibatis.annotations.Param;

public interface BoardMapper {

	public void create(Board board) throws Exception;

	public Board read(Integer boardNo) throws Exception;

	public void update(Board board) throws Exception;

	public void delete(Integer boardNo) throws Exception;

	public List<Board> list() throws Exception;

	public List<Board> search(@Param("title") String title) throws Exception;

}
