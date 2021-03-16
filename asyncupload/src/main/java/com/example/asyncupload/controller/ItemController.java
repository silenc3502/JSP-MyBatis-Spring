package com.example.asyncupload.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.example.asyncupload.entity.Item;
import com.example.asyncupload.service.ItemService;
import com.example.asyncupload.util.MediaUtils;
import com.example.asyncupload.util.UploadFileUtils;
import org.apache.commons.io.IOUtils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;

	@Value("${upload.path}")
	private String uploadPath;

	@GetMapping("/list")
	public void list(Model model) throws Exception {
		List<Item> itemList = this.itemService.list();

		model.addAttribute("itemList", itemList);
	}

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute(new Item());

		return "item/register";
	}

	@PostMapping("/register")
	public String register(Item item, Model model) throws Exception {
		String[] files = item.getFiles();

		for (int i = 0; i < files.length; i++) {
			log.info("files[i] = " + files[i]);
		}

		this.itemService.regist(item);

		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "item/success";
	}

	@GetMapping("/modify")
	public String modifyForm(Integer itemId, Model model) throws Exception {
		Item item = this.itemService.read(itemId);

		model.addAttribute(item);

		return "item/modify";
	}

	@PostMapping("/modify")
	public String modify(Item item, Model model) throws Exception {
		String[] files = item.getFiles();

		for (int i = 0; i < files.length; i++) {
			log.info("files[i] = " + files[i]);
		}

		this.itemService.modify(item);

		model.addAttribute("msg", "수정이 완료되었습니다.");

		return "item/success";
	}

	@GetMapping("/remove")
	public String removeForm(Integer itemId, Model model) throws Exception {
		Item item = this.itemService.read(itemId);

		model.addAttribute(item);

		return "item/remove";
	}

	@PostMapping("/remove")
	public String remove(Item item, Model model) throws Exception {
		this.itemService.remove(item.getItemId());

		model.addAttribute("msg", "삭제가 완료되었습니다.");

		return "item/success";
	}

	@ResponseBody
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		log.info("originalName: " + file.getOriginalFilename());

		String savedName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

		return new ResponseEntity<String>(savedName, HttpStatus.CREATED);
	}

	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		log.info("FILE NAME: " + fileName);

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName);

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			} else {

				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@GetMapping("/getAttach/{itemId}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("itemId") Integer itemId) throws Exception {
		log.info("getAttach itemId: " + itemId);

		return itemService.getAttach(itemId);
	}

}
