package com.rsupport.webviewer.web.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLDecoder;


@Controller
@RequiredArgsConstructor
public class ClientController {


//    //corona 접속 번호 입력
//    @RequestMapping("/corona/connect_control")
//    @ResponseBody
//    public ResponseVO connectControl(@RequestParam("access_code") String accessCode,
//                                     @RequestParam(required = false, value = "client_name") String clientName, HttpServletRequest request)
//            throws Exception {
//
//        if (StringUtils.isBlank(accessCode)) {
//            throw new ParameterEmptyAccessCodeException("access code must not be blank!");
//        }
//
//        if (StringUtils.isNotBlank(clientName)) {
//            clientName = URLDecoder.decode(clientName, BaseConstants.DEFAULT_CHARSET);
//            if (clientName.length() > 100) {
//                throw new InvalidClientNameMaxLengthExceededException(
//                        "Client name is too long. Maximum length exceeded.");
//            }
//        }
//
//        if (log.isDebugEnabled()) {
//            log.debug(String.format("/corona/connect_control::accessCode:%s, clientName:%s", accessCode, clientName));
//        }
//
//        return coronaManager.connectControl(accessCode, clientName, request);
//    }
//
//
//    //원격지원 파일 -> 다운로드.....
//    @RequestMapping(value = "/corona/host_download_url", method = RequestMethod.GET)
//    public ModelAndView getHostDownloadUrl(@RequestParam String roomId) {
//        return coronaManager.getHostDownloadUrl(roomId);
//    }


    //파일 다운로드
//    @GetMapping("/client/makeGroup")
//    public ModelAndView downLoadFile(HttpServletRequest request) {
//        String fullPath = "D:\\fileupload\\MXxzdGFscGFrci5zdGFydHN1cHBvcnQuY29tfGZmODA4MDgxNjAyYjIxZmIwMTYwN2RjODllYmIwOWNlfDN8.exe";
//        File downloadFile = new File(fullPath);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("fileDownLoadView");
//        mav.addObject("downloadFile", downloadFile);
//        mav.addObject("downloadFileName", "한글.txt");
//        return mav;
//    }

//    ResponseBody xml 전달.....
//    @RequestMapping("/client/update_info")
//    @ResponseBody
//    public void getHostUpdateInfo(@RequestParam(required = false) String accessCode, @RequestParam(required = false) String relayUriKey,
//                                  @RequestParam(required = false) String clientName, HttpServletResponse response) throws Exception {
//
//        ClientHostUpdateResponseVO clientHostUpdateResponseVO =  clientHostAccessManager.updateInfo(accessCode, relayUriKey);
//
//        if (log.isDebugEnabled())
//            log.debug(clientHostUpdateResponseVO);
//
//        writeXml(clientHostUpdateResponseVO, response);
//    }


//    @RequestMapping("/client/support_info_by_access_code")
//    public ModelAndView supportInfoByAccessCode(@RequestParam("access_code") String accessCode,
//                                                @RequestParam(required = false, value = "client_name") String clientName, HttpServletRequest request)
//            throws Exception {
//
//        if (StringUtils.isBlank(accessCode))
//            throw new ParameterEmptyAccessCodeException("access code must not be blank!");
//
//        if (StringUtils.isNotBlank(clientName)) {
//            clientName = URLDecoder.decode(clientName, BaseConstants.DEFAULT_CHARSET);
//            if (clientName.length() > 100) {
//                throw new InvalidClientNameMaxLengthExceededException("Client name is too long. Maximum length exceeded.");
//            }
//        }
//
//        if (log.isDebugEnabled())
//            log.debug(String.format("/client/support_info_by_access_code::accessCode:%s, clientName:%s", accessCode, clientName));
//
//        ClientAccessInfoVO clientAccessInfoVO = getBrowserAndClientAccessInfo(clientName, request);
//        Server targetAuthServer = clientAccessManager.getTargetAuthServer(accessCode);
//        SupportInfoByAccessCodeVO supportInfoByAccessCodeVO = null;
//        if (targetAuthServer == null) {
//            supportInfoByAccessCodeVO = handleSupportInfoAtLocalServer(accessCode, clientAccessInfoVO);
//        } else {
//            supportInfoByAccessCodeVO = handleSupportInfoAtRemoteServer(accessCode, clientAccessInfoVO, targetAuthServer, request);
//        }
//
//        return JsonpUtil.getModelAndView(supportInfoByAccessCodeVO);
//    }
}
