package com.zhidi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhidi.entity.Emp;
import com.zhidi.service.IEmpService;
import com.zhidi.util.PagerHander;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private IEmpService empService;

	/**
	 * 分页查询
	 * @param model
	 * @param hander
	 * @return
	 */
	@RequestMapping("/toEmp")
	public String toEmp(Model model,PagerHander hander){
		if (hander.getPageNum() == null){
			hander.setPageNum(1);
		}
		if (hander.getPageSize() == null)
			hander.setPageSize(10);
		
		//获取总记录数量
		hander.setTotalRows(empService.getTotalRows());
		
		List<Emp> list = empService.getDeptByPage(hander);
		model.addAttribute("list", list);
		model.addAttribute("hander", hander);
		return "index";
	}
	
}
