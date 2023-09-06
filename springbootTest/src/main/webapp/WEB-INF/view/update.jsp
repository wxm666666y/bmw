<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改信息信息</title>
</head>
<body>
<div>
<form action="${ctx}/productview/updateProduct" method="post">
修改商品信息<input type="hidden" name="id" id="id" value="${product.id}"/><br/>
<table width="98%" align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>	
		<td class="field">商品名称:</td>		
		<td>
		<input type="text" id="name" name="name" maxlength="50" value="${product.name}"/>
		</td>
	</tr>
	<tr>
		<td class="field">商品描述</td>	
		<td>
		<input type="text" id="desc" name="desc" maxlength="300" value="${product.desc}"/>
		</td>
	</tr>
	<tr>
		<td class="field">商品描述地址</td>	
		<td>
		<input type="text" id="imgUrl" name="imgUrl" maxlength="60" value="${product.imgUrl}"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input id="submitButton" name="submitButton" type="submit" value="提交"/>
			<input id="submitButton" name="submitButton" type="btn" value="放弃" onclick="javascript:history.go(-1);"/>
		</td>
	</tr>

</table>	
</form>
</div>
</body>
</html>