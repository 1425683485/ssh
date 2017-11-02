package com.zhidi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhidi.entity.Dept;
import com.zhidi.service.IDeptService;
import com.zhidi.util.PagerHander;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private IDeptService deptService;
	
	@RequestMapping("/index")
	public String index(){
		return "dept/index";
	}
	
	/**
	 * 分页查询
	 * @param model 传递数据到前台
	 * @param pageNum 页数
	 * @param pageSize 每页的数据数目
	 * @return
	 */
	@RequestMapping("/deptPage")
	public String getDeptByPage(Model model,Integer pageNum,Integer pageSize){
		PagerHander hander = new PagerHander(pageSize, pageNum);
		if (pageNum == null ){
			hander.setPageNum(1);
		} 
		if (pageSize == null){
			hander.setPageSize(10);
		}
		Integer totalRows = deptService.getTotalRows();
		hander.setTotalRows(totalRows);
		List<Dept> list = deptService.getDeptByPage(hander);
		model.addAttribute("list", list);
		model.addAttribute("hander", hander);
		return "dept/index";
	}
	
	/**
	 * 根据主键获取部门信息
	 * @param model
	 * @param deptno
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDeptById")
	public Dept getDeptById(Integer deptno){
		Dept dept = deptService.get(deptno);
		return dept;
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(Dept dept){
		System.out.println(dept);
		if (dept.getDeptno() != null){
			deptService.update(dept);
		} else {
			deptService.save(dept);
		}
		return "forward:deptPage.do?pageNum=1&pageSize=10";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer deptno){
		deptService.delete(deptno);
		return "forward:deptPage.do?pageNum=1&pageSize=10";
	}
}

