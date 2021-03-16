package com.example.asyncupload.service;

import java.util.List;

import com.example.asyncupload.entity.Item;
import com.example.asyncupload.repository.ItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

	private final ItemMapper mapper;

	@Transactional
	@Override
	public void regist(Item item) throws Exception {
		mapper.create(item);

		String[] files = item.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			mapper.addAttach(fileName);
		}
	}

	@Override
	public Item read(Integer itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Transactional
	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);

		Integer itemId = item.getItemId();

		mapper.deleteAttach(itemId);

		String[] files = item.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			mapper.replaceAttach(fileName, itemId);
		}
	}

	@Transactional
	@Override
	public void remove(Integer itemId) throws Exception {
		mapper.deleteAttach(itemId);
		mapper.delete(itemId);
	}

	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}

	@Override
	public String getPicture(Integer itemId) throws Exception {
		return mapper.getPicture(itemId);
	}

	@Override
	public List<String> getAttach(Integer itemId) throws Exception {
		return mapper.getAttach(itemId);
	}

}
