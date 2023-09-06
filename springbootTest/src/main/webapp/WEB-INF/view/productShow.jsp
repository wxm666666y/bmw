<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品信息展示</title>
</head>
<body>
<div>
<table align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="field">商品名称:</td><td>${product.name}</td>
	</tr>
	<tr>
		<td class="field">商品描述:</td><td>${product.desc}</td>
	</tr>
	<tr>
		<td class="field">商品ID:</td><td>${product.productId}</td>
	</tr>
	<tr>
		<td class="field">商品展示URL:</td><td>${product.imgUrl}</td>
	</tr>
	<tr>
		<td class="field">商品创建时间:</td><td>${product.createTimeString}</td>
	</tr>
	<tr>
		<td colspan="2"><a href="${ctx}/productview/listProduct">返回首页</a></td>
	</tr>
</table>
</div>
</body>
</html>