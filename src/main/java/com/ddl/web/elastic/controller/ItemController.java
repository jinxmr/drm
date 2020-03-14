package com.ddl.web.elastic.controller;

import com.ddl.model.AjaxResult;
import com.ddl.model.TableDataInfo;
import com.ddl.web.elastic.domain.Item;
import com.ddl.web.elastic.service.ItemService;
import com.ddl.web.system.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/test" )
public class ItemController extends BaseController {

	@Autowired
	private ItemService itemService;

	@ApiOperation(value = "创建索引", httpMethod = "GET")
	@GetMapping("createIndex")
	@ResponseBody
	public AjaxResult createIndex() {
		boolean res = itemService.createIndex();
		return res ? AjaxResult.success("SUCCESS") : AjaxResult.error("FAILD");
	}

	@ApiOperation(value = "批量新增", httpMethod = "GET")
	@GetMapping("insertList")
	@ResponseBody
	public AjaxResult insertList() {
		Iterable<Item> items = itemService.insertList();
		return AjaxResult.success("SUCCESS");
	}

	@ApiOperation(value = "查询", httpMethod = "GET")
	@GetMapping("search")
	@ResponseBody
	public TableDataInfo<Item> search(@RequestParam(name = "title", defaultValue = "", required = true) String title) {
		TableDataInfo<Item> search = itemService.search(title);
		return search;
	}
}
