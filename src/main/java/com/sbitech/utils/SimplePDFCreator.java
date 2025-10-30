package com.sbitech.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.IOException;

public class SimplePDFCreator {

    public static void createSimplePDF(String outputPath) throws IOException {
        // 创建一个新的 PDF 文档
        try (PDDocument document = new PDDocument()) {

            // 创建一个新页面 (A4 尺寸)
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // 创建内容流来写入文本
            try (PDPageContentStream contentStream =
                         new PDPageContentStream(document, page)) {

                // 加载中文字体 (从系统字体目录)
                // Windows 系统使用黑体
                String fontPath = "C:/Windows/Fonts/simhei.ttf";
                //"C:/Windows/Fonts/simhei.ttf"      // 黑体
                //"C:/Windows/Fonts/simsun.ttc"      // 宋体
                //"C:/Windows/Fonts/msyh.ttf"        // 微软雅黑
                // Linux 系统使用: /usr/share/fonts/truetype/wqy/wqy-microhei.ttc
                // macOS 系统使用: /System/Library/Fonts/PingFang.ttc

                PDType0Font chineseFont = PDType0Font.load(document, new File(fontPath));

                // 开始文本
                contentStream.beginText();

                // 使用中文字体显示标题
                contentStream.setFont(chineseFont, 24);
                contentStream.newLineAtOffset(50, 750);
                contentStream.showText("你好，使用 PDFBox 3.0.5!");

                // 换行
                contentStream.newLineAtOffset(0, -30);

                // 切换到普通英文字体显示英文内容
                contentStream.setFont(
                        new PDType1Font(Standard14Fonts.FontName.HELVETICA),
                        12
                );
                contentStream.showText("This is a simple PDF document created with Apache PDFBox.");

                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("PDFBox is a powerful Java library for working with PDF files.");

                // 再次使用中文字体
                contentStream.newLineAtOffset(0, -30);
                contentStream.setFont(chineseFont, 12);
                contentStream.showText("支持中文显示，字体渲染正常。");

                // 结束文本
                contentStream.endText();

                // 绘制一条线
                contentStream.moveTo(50, 680);
                contentStream.lineTo(550, 680);
                contentStream.stroke();
            }

            // 保存文档
            document.save(outputPath);
        }
    }

    // 使用指定字体路径创建 PDF
    public static void createSimplePDF(String outputPath, String fontPath) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream =
                         new PDPageContentStream(document, page)) {

                // 使用指定的字体文件
                PDType0Font chineseFont = PDType0Font.load(document, new File(fontPath));

                contentStream.beginText();
                contentStream.setFont(chineseFont, 24);
                contentStream.newLineAtOffset(50, 750);
                contentStream.showText("你好，使用 PDFBox 3.0.5!");
                contentStream.endText();
            }

            document.save(outputPath);
        }
    }
}