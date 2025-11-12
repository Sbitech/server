package com.sbitech.controller;

import com.sbitech.dto.PlayerMatchInfoDTO;
import com.sbitech.dto.PlayerMatchesDTO;
import com.sbitech.dto.PlayerSkillInfoDTO;
import com.sbitech.entity.PlayerMatches;
import com.sbitech.service.PlayerMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static com.sbitech.utils.SimplePDFCreator.createSimplePDF;

@CrossOrigin
@RestController
@RequestMapping("/playerMatches")
public class PlayerMatchesController {

    @Autowired
    private PlayerMatchesService playerMatchesService;

    @GetMapping("/getAll")
    public List<PlayerMatches> getAll() {
        return playerMatchesService.getAll();
    }

    @GetMapping("getAllInfo")
    public List<PlayerMatchInfoDTO> getAllPlayerMatch() {
        return playerMatchesService.getAllPlayerMatch();
    }

    @GetMapping("getAllInfoByEventId")
    public List<PlayerMatchInfoDTO> getAllInfoByEventId(Long eventId) {
        return playerMatchesService.getAllInfoByEventId(eventId);
    }

    @GetMapping("/getPlayerMoveById")   //通过比赛场次获取选手上场顺序和选手招式列表信息
    public List<PlayerSkillInfoDTO> getMoveInfoById(Long eventId) {
        return playerMatchesService.getPlayerMoveById(eventId);
    }

    @GetMapping("/getPlayerMatchesById")
    public PlayerMatchesDTO getPlayerMatchesById(Long id) {
        return playerMatchesService.getPlayerMatchesById(id);
    }

    @GetMapping("/createPDF")
    public String createPDF(String id) {  //前端发送赛事id生成pdf

        String outputPath = "C:/Users/dlnsupport/Documents/Project/武术系统/userFront/public/report/";
        String fileName = "simple_document-" + id + ".pdf";
        try {
            createSimplePDF(outputPath + fileName);
            System.out.println("PDF 创建成功: " + outputPath + fileName);
            return outputPath + fileName;
        } catch (IOException e) {
            System.err.println("创建 PDF 时出错: " + e.getMessage());
            e.printStackTrace();
            return "null";
        }
    }
}
