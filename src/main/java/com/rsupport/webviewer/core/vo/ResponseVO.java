package com.rsupport.webviewer.core.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Getter
@Setter
@XmlRootElement(name = "RESULT")
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO implements Serializable {

    private static final long serialVersionUID = -8878939503373294517L;

    @JsonProperty(value = "retcode")
    private String code;

    private String message;
}
