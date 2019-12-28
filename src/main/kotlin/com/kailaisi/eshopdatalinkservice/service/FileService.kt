package com.kailaisi.eshopdatalinkservice.service

import org.springframework.web.multipart.MultipartFile

/**
 * 进行文件的处理
 */
interface FileService {
    fun uploadFileToLocal(request: MultipartFile): String

}
