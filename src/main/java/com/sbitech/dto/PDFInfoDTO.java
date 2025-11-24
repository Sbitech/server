package com.sbitech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PDFInfoDTO {

    private String fileName;
    private String fileSize;
    private Timestamp createTime;

}
