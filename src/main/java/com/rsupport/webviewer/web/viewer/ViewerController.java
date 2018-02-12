package com.rsupport.webviewer.web.viewer;

import com.rsupport.webviewer.core.service.ServerGroupManager;
import com.rsupport.webviewer.core.service.ViewerManager;
import com.rsupport.webviewer.core.vo.ResponseVO;
import com.rsupport.webviewer.web.swagger.Greeting;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ViewerController {

    private final ViewerManager viewerManager;
    private final ServerGroupManager serverGroupManager;


    @ApiOperation(value = "뷰어 새로운 그룹 만들기", tags = "Viewer")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false,
                    dataType = "String", paramType = "query", defaultValue = "Niklas")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @GetMapping("/viewer/makeRoom") // corona/api/login + /corona/api/make_group
    public ResponseVO makeRoom(Model model) {
        //여기서 JWT 전달
        //해당 풀어서 security 에 저장

        ViewerMakeRoomResVO resVO = serverGroupManager.getServer("1");
        return new ViewerMakeRoomResVO();
    }

    private String getRandomAccessCode() throws RuntimeException {
        int maxCount = 5;
        String serverCode = "333";
        return null;
    }


    //corona test 를 위해 스타트.....


//    @ApiOperation(value = "해당게시판 조회", tags = "changhee")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "사용자 이름", required = false,
//                    dataType = "String", paramType = "query", defaultValue = "Niklas")
//    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
//            @ApiResponse(code = 401, message = "Unauthorized"),
//            @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "Not Found"),
//            @ApiResponse(code = 500, message = "Failure")
//    })
//    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces = "application/json")
//    @ResponseBody
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        String template = "Hello, %s!";
//        return new Greeting(new AtomicLong().incrementAndGet(), String.format(template, name));
//    }
//
//    @GetMapping("/welcome")
//    public ModelAndView downLoadFile(HttpServletRequest request) {
//        String fullPath = "D:\\fileupload\\MHxodHRwczovL3N0YWxwYS5zdGFydHN1cHBvcnQuY29tfG51bGx8MHw5OTk5OTk5OTk5 (1).exe";
//        File downloadFile = new File(fullPath);
//
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("downloadFileView");
//        mav.addObject("downloadFile", downloadFile);
//        mav.addObject("downloadFileName", "한글.txt");
//        return mav;
//    }


//    @ApiOperation(value = "뷰어 시작", tags = "changhee2")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "User's name", required = false,
//                    dataType = "String", paramType = "query", defaultValue = "Niklas")
//    })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
//            @ApiResponse(code = 401, message = "Unauthorized"),
//            @ApiResponse(code = 403, message = "Forbidden"),
//            @ApiResponse(code = 404, message = "Not Found"),
//            @ApiResponse(code = 500, message = "Failure")
//    })
//    @GetMapping("/welcom2")
//    public String welcome(HttpServletRequest request, HttpServletResponse response, Model model) {
//
//        model.addAttribute("time", new Date());
//        model.addAttribute("project1", webViewerProperties.getRole());
//        model.addAttribute("project2", webViewerProperties.getProject().getName());
//        return "viewer/start";
//    }

//만약여기서 현재 하려고 하는 건
//    @GetMapping(value = "/list")
//    public SupportRoomListResponseVO list(SupportRoomRequestVO requestVO) {
//        return Optional.ofNullable(supportRoomRepo.getSupportRoomResponseVO("4444"))
//                .orElseThrow(SupportNotFoundException::new);


    /*@RequestMapping(value = CORONA_CONNECTED_CONTROL)
    @ResponseBody
    public ResponseVO connectedControl(@RequestBody CoronaRequestVO requestVO) throws Exception {
        User user = this.getCurrentUser();

        if (user == null) {
            return null;
        }

        log.debug("connect_ok");

        return manager.connectedControl(requestVO);
    }*/

   /* @RequestMapping(value = CORONA_CLOSE_SESSION_CONTROL)
    @ResponseBody
    public ResponseVO closeSessionControl(@RequestBody CoronaRequestVO requestVO) throws Exception {
        String guid = requestVO.getViewerId4Control();
        log.debug(String.format("[guid:%s][caller:webViewer]/support/close_session start...request->%s", guid,
                requestVO));

        if (StringUtils.isBlank(guid)) {
            throw new ParameterEmptyGuidException("guid must not be blank!");
        }

        ResponseVO responseVO = manager.closeSession(guid, requestVO.getCaller());
        responseVO.setMessage(null);

        return responseVO;

    }*/
}
