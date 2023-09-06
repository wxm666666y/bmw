<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增产品</title>
</head>
<body>
<div>
<form action="${ctx}/productview/addProduct" method="post">
添加新的商品信息<br/>
<table width="98%" align="center" border="0" cellspacing="0" cellpadding="0">
	<tr>	
		<td class="field">商品名称:</td>		
		<td>
		<input type="text" id="name" name="name" maxlength="50"/>
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;&nbsp;</td></tr>
	<tr>
		<td class="field">商品描述</td>	
		<td>
		<input type="text" id="desc" name="desc" maxlength="300"/>
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;&nbsp;</td></tr>
	<tr>
		<td class="field">商品价格</td>	
		<td>
		<input type="text" id="price" name="price" maxlength="10"/>
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;&nbsp;</td></tr>
	<tr>
		<td class="field">商品ID</td>	
		<td>
		<input type="text" id="productId" name="productId" maxlength="50"/>
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;&nbsp;</td></tr>
	<tr>
		<td class="field">商品描述地址</td>	
		<td>
		<input type="text" id="imgUrl" name="imgUrl" maxlength="60"/>
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;&nbsp;</td></tr>
	<tr>
		<td colspan="2">
			<input id="submitButton" name="submitButton" type="submit" value="提交"/>
		</td>
	</tr>

</table>	
</form>
</div>
</body>
</html>