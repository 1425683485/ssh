<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<title>部门主页</title>
<style type="text/css">
	table {
		margin: auto;
		border: 1px solid; 
		/* 取消表格边框之间的距离 */
		border-collapse: collapse;
	}
	
	
	table tr th {
		border: 1px solid;
		
	}
</style>
<script type="text/javascript">


</script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>编号</th>
				<th>部门名称</th>
				<th>部门地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="dept" varStatus="status">
			<tr>
				<th>${status.count }</th>			
				<th>${dept.dname }</th>			
				<th>${dept.loc }</th>		
				<th><a href="javascript:void(0)" onclick="updateDept(${dept.deptno})">修改</a>|<a href="dept/delete.do?deptno=${dept.deptno }">删除</a></th>	
			</tr>
			</c:forEach>
		</tbody>
		
		<tfoot>
			<tr>
				<th colspan="4">
					总共${hander.totalPage }页&nbsp;
					第${hander.pageNum }页&nbsp;
					<a href="dept/deptPage.do?pageNum=1&pageSize=10">首页</a>
					<a href="dept/deptPage.do?pageNum=${hander.pageNum-1 }&pageSize=10">上一页</a>
					<a href="dept/deptPage.do?pageNum=${hander.pageNum+1 }&pageSize=10">下一页</a>
					<a href="dept/deptPage.do?pageNum=${hander.totalPage }&pageSize=10">尾页</a>
				</th>
			</tr>
			<tr>
				<th colspan="4"><a id="saveDept">添加部门</a></th>
			</tr>
		</tfoot>
	
	</table>
	
	<!-- <table id="deptMassage">
		<tr>
			<td><input type="hidden" id="deptno"></td>
		</tr>
		<tr>
			<th>部门名称</th>
			<th><input type="text" id="dname"></th>
		</tr>
		<tr>
			<th>部门地址</th>
			<th><input type="text" id="loc"></th>
		</tr>
		<tr>
			<th colspan="2"><input type="button" id="saveOrUpdate" value="保存"></th>
		</tr>
	</table> -->
	
	<form id="deptMassage" action="dept/saveOrUpdate.do" method="post">
		<input type="hidden" name="deptno">
		<input type="hidden" name="version">
		部门名称：<input type="text" name="dname"><br>
		部门地址：<input type="text" name="loc"><br>
		<input type="submit" value="提交">
	</form>
	
	<script type="text/javascript">
		$("#deptMassage").hide();
	
		function updateDept(e){
			$.post("dept/getDeptById.do",{"deptno":e},function(data){
				$("#deptMassage").show();
				$('input[name="dname"]').val(data.dname);
				$('input[name="loc"]').val(data.loc);
				$('input[name="deptno"]').val(data.deptno);
				$('input[name="version"]').val(data.version);
				
			},"json");
		}
		
		$("#saveDept").on("click",function(){
			$("#deptMassage").show();
			$('input[name="dname"]').val("");
			$('input[name="loc"]').val("");
			$('input[name="deptno"]').val("");
			$('input[name="version"]').val("");
		})
		$("#saveOrUpdate").on("click",function(){
			
		})
	
	</script>
</body>
</html>