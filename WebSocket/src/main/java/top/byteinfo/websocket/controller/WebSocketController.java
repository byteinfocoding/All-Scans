package top.byteinfo.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import top.byteinfo.websocket.WebSocketApi;
import top.byteinfo.websocket.model.Result;
import top.byteinfo.websocket.model.VoiceVO;

public class WebSocketController {
    @Autowired
    private WebSocketApi webSocketApi;

    /**
     * 保存语音信息
     *
     * @param voiceVO 语音信息
     * @return {@link Result<String>} 语音地址
     */
    @PostMapping("/voice")
    public Result<?> sendVoice(VoiceVO voiceVO) {
        webSocketApi.sendVoice(voiceVO);
        return Result.builder().message("ok").statusCode(200).build();
    }
}
