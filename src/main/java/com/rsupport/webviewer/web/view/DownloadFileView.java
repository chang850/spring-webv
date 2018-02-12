package com.rsupport.webviewer.web.view;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

@Component("downloadFileView")
public class DownloadFileView extends AbstractView {

    public DownloadFileView() {
        setContentType("application/octet-stream");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = (File) map.get("downloadFile");
        String saveFileName = (String) map.get("saveFileName");

        if (StringUtils.isBlank(saveFileName))
            saveFileName = file.getName();

        response.setContentType(getContentType());
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + saveFileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        OutputStream out = response.getOutputStream();
        try(FileInputStream fis =  new FileInputStream(file)){
            FileCopyUtils.copy(fis, out);
            out.flush();
        }

//      FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(file);
//            FileCopyUtils.copy(fis, out);
//        } finally {
//            FileUtil.closeQuietly(fis);
//        }
    }
}
