package com.kailaisi.eshopdatalinkservice.control

import com.kailaisi.eshopdatalinkservice.config.intercepter.result.ResponseResult
import com.kailaisi.eshopdatalinkservice.service.FileService
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 *描述：上传文件功能
 *<p/>作者：wu
 *<br/>创建时间：2019/12/28 16:33
 */
@RestController
@ResponseResult
@RequestMapping("/upload")
@Api(value = "上传文件", tags = ["UpLoadController"])
class UpLoadController {
    @Autowired
    lateinit var fileService: FileService

    @PostMapping("/singleFile")
    fun uploadToLocal(@RequestParam("file") file: MultipartFile): String {
        return fileService.uploadFileToLocal(file)
    }
}