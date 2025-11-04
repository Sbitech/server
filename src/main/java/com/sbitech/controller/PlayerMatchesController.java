package com.sbitech.controller;

import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.PlayerMatches;
import com.sbitech.service.PlayerMatchesService;
import com.sbitech.utils.SimplePDFCreator;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.sbitech.utils.SimplePDFCreator.createSimplePDF;

@CrossOrigin
@RestController
@RequestMapping("/playerMatches")
public class PlayerMatchesController {

    @Autowired
    private PlayerMatchesService playerMatchesService;

    @GetMapping("/getAll")
    public List<PlayerMatches> getAll(){
        return  playerMatchesService.getAll();
    }

    @GetMapping("/getPlayerMoveById")
    public List<PlayerSkillInfoDTO> getMoveInfoById(Long eventId){
        return playerMatchesService.getPlayerMoveById(eventId);
    }

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
