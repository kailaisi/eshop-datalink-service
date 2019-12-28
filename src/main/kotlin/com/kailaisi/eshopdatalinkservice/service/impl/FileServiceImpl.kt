package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.service.FileService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

@Service
class FileServiceImpl : FileService {
    var filePath: String? = null
        @Value("\${filePath}")
        set(value) {
            field = value
        }

    override fun uploadFileToLocal(file: MultipartFile): String {
        Assert.notNull(file,"文件不能为空")
        var newName = UUID.randomUUID().toString().plus(file.originalFilename)
        val path = "${filePath}/$newName"
        file.transferTo(File(path))
        return newName
    }
}