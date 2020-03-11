package com.ddl.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestErrorController {

	@GetMapping()
	public String errorMain() {

		int i = 1 / 0;
		return i + "";
	}
}
