package com.dmbjz.vodservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {

    String uploadVideo(MultipartFile file);

    void deleteVideo(String videoId);

    void removeMoreAliyunVideo(List videoIdList);

}
