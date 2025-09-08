package com.sbitech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Backups {

    private Long id; //id
    private String fileName; //文件名
    private String fileSize; //文件大小
    private String filePath; //文件路径
    private String backupType; //备份类型
    private String status; //状态
    private Timestamp backupTime; //备份时间

}
