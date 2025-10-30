package com.sbitech.controller;

import com.sbitech.entity.PlayerMatches;
import com.sbitech.utils.SimplePDFCreator;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.sbitech.utils.SimplePDFCreator.createSimplePDF;

@CrossOrigin
@RestController
@RequestMapping("/playerMatches")
public class PlayerMatchesController {

    @GetMapping("/createPDF")
    public String createPDF(String id) {  //前端发送赛事id生成pdf

        String outputPath = "C:/Users/dlnsupport/Documents/Project/武术系统/userFront/public/report/";
        String fileName ="simple_document-"+ id+".pdf";
        try {
            createSimplePDF(outputPath+fileName);
            System.out.println("PDF 创建成功: " + outputPath+fileName);
            return outputPath+fileName;
        } catch (IOException e) {
            System.err.println("创建 PDF 时出错: " + e.getMessage());
            e.printStackTrace();
            return "null";
        }


    }

}
