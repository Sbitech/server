package com.sbitech.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class SimplePDFCreator {
//
//    public static void main(String[] args) {
//        // 指定输出文件路径
//        String outputPath = "simple_document.pdf";
//
//        try {
//            createSimplePDF(outputPath);
//            System.out.println("PDF 创建成功: " + outputPath);
//        } catch (IOException e) {
//            System.err.println("创建 PDF 时出错: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

    public static void createSimplePDF(String outputPath) throws IOException {
        // 创建一个新的 PDF 文档
        try (PDDocument document = new PDDocument()) {

            // 创建一个新页面 (A4 尺寸)
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // 创建内容流来写入文本
            try (PDPageContentStream contentStream =
                    new PDPageContentStream(document, page)) {

                // 设置字体和字号 (PDFBox 3.x 使用 Standard14Fonts)
                contentStream.setFont(
                    new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD),
                    24
                );

                // 开始文本
                contentStream.beginText();

                // 设置文本位置 (x, y 坐标)
                contentStream.newLineAtOffset(50, 750);

                // 写入标题
                contentStream.showText("Hello, PDFBox 3.0.5!");

                // 换行
                contentStream.newLineAtOffset(0, -30);

                // 切换到普通字体
                contentStream.setFont(
                    new PDType1Font(Standard14Fonts.FontName.HELVETICA),
                    12
                );

                // 写入正文
                contentStream.showText("This is a simple PDF document created with Apache PDFBox.");

                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("PDFBox is a powerful Java library for working with PDF files.");

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
}