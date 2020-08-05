package com.dmbjz.alioss.service;

import org.springframework.web.multipart.MultipartFile;

public interface AliOssService {
    String uploadFile(MultipartFile file);
}
