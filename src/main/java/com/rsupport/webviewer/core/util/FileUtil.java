package com.rsupport.webviewer.core.util;

import com.google.common.base.Charsets;
import com.rsupport.webviewer.core.common.BaseConstants;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


@CommonsLog
public final class FileUtil {

    private FileUtil() {
    }

    //기준점 1
    public static void download(File file, String fileName, HttpServletRequest request, HttpServletResponse response) {
        download(file, fileName, null, request, response);
    }

    //기준점 2
    public static void download(File file, String fileName, String contentType, HttpServletRequest request,
            HttpServletResponse response) {

        FileInputStream fis = null;

        try {
            response.setContentLength((int) file.length());
            fis = new FileInputStream(file);
            download(contentType, fis, fileName, request, response);
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("file(%s) download error.., message:%s", file.getAbsolutePath(), e.getMessage()), e);
        } finally {
            closeQuietly(fis);
        }
    }

    //기준점 3
    private static void download(String contentType, InputStream in, String fileName, HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        response.setContentType(
                StringUtils.isNotBlank(contentType) ? contentType : "application/octet-stream; charset=UTF-8");

        OutputStream out = getDownloadOutputStream(request, response, fileName);

        if (out == null)
            return;

        copy(in, out);
        out.flush();
    }

    public static OutputStream getDownloadOutputStream(HttpServletRequest request, HttpServletResponse response,
                                                       String downloadFileName) {

        OutputStream result = null;

        try {
            String userAgent = request.getHeader("User-Agent");

            if (StringUtils.isBlank(userAgent))
                return null;

            if (userAgent.indexOf("MSIE 5.5") > -1) {
                response.setHeader("Content-Disposition",
                        "filename=" + URLEncoder.encode(downloadFileName, BaseConstants.DEFAULT_CHARSET) + ";");
            } else if (userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("rv") > -1) {
                response.setHeader("Content-Disposition", "attachment; filename="
                        + URLEncoder.encode(downloadFileName, BaseConstants.DEFAULT_CHARSET).replace("+", " ") + ";");
            } else {
                response.setHeader("Content-Disposition", "attachment; filename=\""
                        + new String(downloadFileName.getBytes(BaseConstants.DEFAULT_CHARSET), Charsets.ISO_8859_1)
                        + "\";");
            }

            response.setHeader("Content-Transfer-Encoding", "binary");
            result = response.getOutputStream();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    public static int copy(InputStream in, OutputStream out) throws IOException {
        return org.springframework.util.FileCopyUtils.copy(in, out);
    }

    public static void closeQuietly(Closeable... closeables) {
        for (Closeable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    log.debug(e.toString());
                }
            }
        }
    }
}
