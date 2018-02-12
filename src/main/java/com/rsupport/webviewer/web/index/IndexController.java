package com.rsupport.webviewer.web.index;

import com.rsupport.webviewer.core.common.WebViewerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final WebViewerProperties webViewerProperties;

    @GetMapping("/") // corona/web
    public String index(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("project1", webViewerProperties.getRole());
        model.addAttribute("project2", webViewerProperties.getProject().getName());
        return "index";
    }

    //파일 다운로드
    @GetMapping("/download/file")
    public ResponseEntity<Resource> downLoadFile(HttpServletRequest request) throws IOException {
        //여기서 다운로드 url 생성...
        String fullPath = "classpath:storage/update/MXxzdGFscGFrci5zdGFydHN1cHBvcnQuY29tfGZmODA4MDgxNjAyYjIxZmIwMTYwN2RjODllYmIwOWNlfDN8.exe";
        String saveFileName = "MXxzdGFscGFrci5zdGFydHN1cHBvcnQuY29tfGZmODA4MDgxNjAyYjIxZmIwMTYwN2RjODllYmIwOWNlfDN8.exe";
        File file = new File(fullPath);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + saveFileName + "\";");
        headers.add(HttpHeaders.TRANSFER_ENCODING, "binary");

        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .body(inputStreamResource);

    }


}
