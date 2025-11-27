package com.sbitech.service.impl;

import com.sbitech.dto.PDFInfoDTO;
import com.sbitech.service.PdfScanService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PdfScanServiceImpl implements PdfScanService { //在配置参数中的地址中获取PDF

    @Value("${pdf.scan.path}")
    private String scanPath;


    public List<PDFInfoDTO> getPDFList() {
        List<PDFInfoDTO> list = new ArrayList<>();
        Path dir = Paths.get(scanPath);
        if (!Files.isDirectory(dir)) {
            return list;
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if (Files.isRegularFile(path) && path.toString().toLowerCase().endsWith(".pdf")) {
                    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
                    list.add(new PDFInfoDTO(
                            path.getFileName().toString(),
                            formatSize(attrs.size()),
                            Timestamp.from(attrs.lastModifiedTime().toInstant())
                    ));
//                    System.out.println("创建时间: " + attrs.creationTime());
//                    System.out.println("修改时间: " + attrs.lastModifiedTime());
//                    System.out.println("访问时间: " + attrs.lastAccessTime());
//                    System.out.println("转换后: " + Timestamp.from(attrs.lastModifiedTime().toInstant()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private String formatSize(long size) {  //格式化文件大小
        if (size < 1024) {
            return size + " B";
        } else if (size < 1024 * 1024) {
            return String.format("%.2f KB", size / 1024.0);
        } else {
            return String.format("%.2f MB", size / 1024.0 / 1024.0);
        }
    }

}
