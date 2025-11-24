package com.sbitech.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pdf")
@Data
public class PdfScanProperties {
    private String path = ".";  // 默认值
    private boolean recursive = true;
}