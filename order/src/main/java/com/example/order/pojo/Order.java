package com.example.order.pojo;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/9/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private Long id;
    private String name;
    private Date createTime;
    private Date finishTime;
    private int state;

    public String getCreateTimeString() {
        if (this.createTime == null) return null;
        else return DateUtil.format(this.createTime, "yyyy-MM-dd HH:mm:SS");
    }

    public void setFinishNewTime(int time) {
        if (this.createTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.createTime);
            calendar.add(Calendar.MINUTE, time);
            this.finishTime = calendar.getTime();
        }
    }
}
