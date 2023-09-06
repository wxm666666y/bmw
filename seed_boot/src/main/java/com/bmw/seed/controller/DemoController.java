package com.bmw.seed.controller;

import com.bmw.seed.model.Demo;
import com.bmw.seed.model.vo.DemoReq;
import com.bmw.seed.service.DemoService;
import com.bmw.seed.util.bean.BaseRequest;
import com.bmw.seed.util.bean.BaseResponse;
import com.bmw.seed.util.bean.PageReq;
import com.bmw.seed.util.bean.PageResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/demo")
@Slf4j
@Api(value = "demo相关", tags = "demo相关")
public class DemoController {

	@Autowired
	DemoService demoService;
	@Value("${data.showversion}")
	private String dataShowVersion;

	@RequestMapping(value="/test")
	public BaseResponse<String> test() {
		return BaseResponse.ok(dataShowVersion);
	}

	//设定方法只有post
	@PostMapping("/add")
	@ApiOperation("新增demo")
	public BaseResponse<Boolean> add( @Validated @RequestBody BaseRequest<DemoReq.BaseInfo> demoData ) {
		//@RequestBody表示把请求方法体内容转换为demoData对象，请求对象是BaseRequest<T>泛型类
		DemoReq.BaseInfo baseInfo = demoData.getData();
		demoService.insert(baseInfo.getText(), baseInfo.getDcode());
		return BaseResponse.ok(true);
	}

	@PostMapping("/listPage")
	@ApiOperation("分页查询")
	public BaseResponse<PageResp<DemoReq.ShowBaseInfo>> listPage(@Validated @RequestBody BaseRequest<PageReq> reqData) {
		PageReq pageReq = reqData.getData();

		//用来测试全局异常处理方法
//		if (pageReq.getPage() == 1) throw new RuntimeException("test");

		PageResp<Demo> demoPageResp = demoService.page(pageReq);
		//接下来到本方法结束都是要把数据库版本的Demo转换为对外输出的Vo:DemoReq.ShowBaseInfo
		//BeanUtils.copyProperties 会把属性的“名称和对应类型”完全一致的复制上
		PageResp<DemoReq.ShowBaseInfo> showPageResp = new PageResp<>();
		BeanUtils.copyProperties(demoPageResp, showPageResp);
		//里面的list对应的类型不同，demoPageResp中是List<Demo>, showPageResp中的是List<DemoReq.ShowBaseInfo>，不会直接复制
		showPageResp.setList(new ArrayList<DemoReq.ShowBaseInfo>());
		//lambda表达式，大概知道用法就行，相当于for循环
		demoPageResp.getList().stream().forEach(e->{
			DemoReq.ShowBaseInfo showBaseInfo = new DemoReq.ShowBaseInfo();
			BeanUtils.copyProperties(e, showBaseInfo);
			//时间要做一下专门处理，因为没有名称一致的属性，Demo中只有ceateTime,但是返回的DemoReq.ShowBaseInfo里面的是createTime
			showBaseInfo.setCreateTimeString(DateUtils.formatDate(e.getCreateTime(),"yyyy-MM-dd HH:mm:SS"));
			showPageResp.getList().add(showBaseInfo);
		});
		return BaseResponse.ok(showPageResp);
	}
}
