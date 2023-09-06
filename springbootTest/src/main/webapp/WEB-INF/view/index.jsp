<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表中心页</title>
</head>
<body>
<div>
	<form name="searchForm" action="${ctx}/productview/listProduct" method="post">
	<table width="98%" align="center" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td>商品名称：<input type="text" name="name" id="name" value="${name}"/></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" name="sbtBtn" id="sbtBtn" value="查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${ctx}/productview/add">新建商品</a>
			</td>
		</tr>
	</table>	
	</form>
</div>
<div>
	<table width="98%" align="center" border="0" cellspacing="0" cellpadding="0">
		<thead>
		<tr>
			<th>商品名称</th>
			<th>商品ID</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr>
			<td>${item.name}</td>
			<td>${item.productId}</td>
			<td>${item.createTimeString}</td>
			<td>
			<a href="${ctx}/productview/getProduct?id=${item.id}">查看详情</a>&nbsp;&nbsp;
			<a href="${ctx}/productview/update?id=${item.id}">更新商品</a>&nbsp;&nbsp;
			<a href="${ctx}/productview/delete?id=${item.id}">删除商品</a>
			</td>
		</tr>	
		</c:forEach>
		</tbody>
	</table>
</div>
<div>
	<table width="98%" align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<c:if test="${pageNum == 1}"><a href="#">首页</a></c:if>
			<c:if test="${pageNum != 1 }"><a href="${ctx}/productview/listProduct?pageNum=1">首页</a></c:if>
			<c:if test="${totalPage > pageNum}">
				<a href="${ctx}/productview/listProduct?pageNum=${pageNum+1}">下一页</a>
			</c:if>
			<c:if test="${pageNum > 1}">
				<a href="${ctx}/productview/listProduct?pageNum=${pageNum-1}">上一页</a>
			</c:if>
			<c:if test="${pageNum == totalPage}"><a href="#">末页</a></c:if>
			<c:if test="${pageNum < totalPage}"><a href="${ctx}/productview/listProduct?pageNum=${totalPage}">末页</a></c:if>
			&nbsp;&nbsp;
			共${total}商品，当前${pageNum}/共${totalPage}页
		</td>
	</tr>
	</table>
</div>
</body>
</html>