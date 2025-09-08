package com.sbitech.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class video {    //录像实体类

    private Long id;    // 主键ID
    private Long userId;    //参与者ID
    private String fileUrl; //文件Url
    private Timestamp uploadedTime; //上传时间
    private String project; //项目名称
    private String remarks; //备注信息

}
