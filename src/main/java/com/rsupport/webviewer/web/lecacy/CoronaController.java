package com.rsupport.webviewer.web.lecacy;

import com.rsupport.webviewer.core.domain.ViewerAgent;
import com.rsupport.webviewer.core.domain.ViewerRoom;
import com.rsupport.webviewer.core.domain.ViewerSession;
import com.rsupport.webviewer.core.repository.ViewerAgentRepo;
import com.rsupport.webviewer.core.repository.ViewerRoomRepo;
import com.rsupport.webviewer.core.repository.ViewerSessionRepo;
import com.rsupport.webviewer.core.service.ServerGroupManager;
import com.rsupport.webviewer.core.service.ViewerAgentManager;
import com.rsupport.webviewer.core.vo.ResponseVO;
import com.rsupport.webviewer.web.viewer.ViewerMakeRoomResVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CoronaController {

    private final ViewerAgentManager viewerAgentManager;

    private final ViewerAgentRepo viewerAgentRepo;

    private final ViewerRoomRepo viewerRoomRepo;

    private final ViewerSessionRepo viewerSessionRepo;

    private final ServerGroupManager serverGroupManager;


    //현재 원격지원 채팅 까지 -> 3단계
    @RequestMapping(value = "/corona/api/login")
    @ResponseBody
    public ResponseVO login(HttpServletRequest request) throws Exception {
        ViewerAgent viewerAgent = new ViewerAgent();
        viewerAgentManager.save(viewerAgent);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("100");
        return responseVO;
    }

    @RequestMapping(value = "/corona/api/make_group")
    @ResponseBody
    public ResponseVO makeGroup(HttpServletRequest request) throws Exception {
        List<ViewerAgent> viewerAgentList = viewerAgentRepo.findAll();
        ViewerAgent viewerAgent = viewerAgentList.get(0);
        ViewerMakeRoomResVO resVO = serverGroupManager.getServer("1");
        ViewerRoom viewerRoom = new ViewerRoom();
        ViewerSession viewerSession = new ViewerSession();
        viewerRoom.setAccessCode("77777");
        viewerRoomRepo.save(viewerRoom);
        viewerSession.setViewerAgent(viewerAgent);
        viewerSession.setViewerRoom(viewerRoom);
        viewerSessionRepo.save(viewerSession);
        resVO.setAccessCode(viewerRoom.getAccessCode());
        resVO.setViewerRoomId(viewerRoom.getId());
        resVO.setViewerSessionid(viewerSession.getId());
        resVO.setCode("100");
        return resVO;
    }

    @RequestMapping(value = "/corona/api/make_group_ok")
    @ResponseBody
    public ResponseVO makeGroupOk(@RequestBody String viewerId4Group, HttpServletRequest request) throws Exception {
        ViewerSession viewerSession = viewerSessionRepo.getOne(viewerId4Group);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode("100");
        return responseVO;
    }

  /*  @RequestMapping(value = {"web", "/web/{accessCode"})
    public String corona(Model model) {

        return "relay/gate_corona";
    }*/

    //원격지원 파일 -> 다운로드.....
    /*@RequestMapping(value = "/corona/host_download_url", method = RequestMethod.GET)
    public ModelAndView getHostDownloadUrl(@RequestParam String roomId) {
        return coronaManager.getHostDownloadUrl(roomId);
    }*/
}
