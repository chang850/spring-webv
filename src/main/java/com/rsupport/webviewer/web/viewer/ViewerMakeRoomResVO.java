package com.rsupport.webviewer.web.viewer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rsupport.webviewer.core.domain.Server;
import com.rsupport.webviewer.core.vo.ResponseVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ViewerMakeRoomResVO extends ResponseVO {

    @JsonProperty(value = "groupId")
    private String viewerRoomId;

    private String hostUrl = "localhost:8080";

    @JsonProperty(value = "viewerId4Group")
    private String viewerSessionid;

    @JsonProperty(value = "accessCode4Group")
    private String accessCode;

    @JsonProperty(value = "rsNetServers")
    private List<SupportServer> rsNetServerList = new ArrayList<>();

    @JsonProperty(value = "pushServers")
    private List<SupportServer> pushServerList = new ArrayList<>();

    @Getter
    @Setter
    public static class SupportServer {
        private String id;
        private String host;
        private Integer port;

        public SupportServer(String id, String host, Integer port) {
            this.id = id;
            this.host = host;
            this.port = port;
        }
    }
}
