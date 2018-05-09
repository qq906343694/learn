
package com.test.first.controller;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;


@Controller
@RequestMapping("/test")

public class UploadController
{
	
	@Autowired
	private FastFileStorageClient fastFileStorageClient;
	
	
	private static Log logger = LogFactory.getLog(UploadController.class);
	
	
	/**
	 * 访问地址：
	 * http://192.168.1.168:8080/group1/M00/00/00/wKgBqFmc5nOAUPnJAANkxh3IoYo708.jpg
	 * 
	 * @return
	 * @throws IOExceptioniz
	 */
	
	@RequestMapping(value = "/upload")
	@ResponseBody
	public String uploadImg(@RequestParam("file") MultipartFile multipartFile) throws IOException
	{
		
		
		/*
		 * String originalFilename = file.getOriginalFilename();
		 * String fileName = StringUtils.getFilenameExtension(originalFilename);
		 * // String strs = fileName.substring(fileName.lastIndexOf(".") + 1);
		 * StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), fileName, null);
		 * System.out.println("path ....=" + storePath.getFullPath());
		 * return "success";
		 */
		
		String urlPath = "";
		if (multipartFile != null && ! multipartFile.isEmpty() && multipartFile.getSize() > 0)
		{
			String originalFilename = multipartFile.getOriginalFilename();
			String filenameExtension = StringUtils.getFilenameExtension(originalFilename);
			try
			{
				StorePath uploadFile = fastFileStorageClient.uploadFile(multipartFile.getInputStream(),
							multipartFile.getSize(), filenameExtension, null);
				urlPath = "/" + uploadFile.getFullPath();
			}
			catch (IOException e)
			{
				logger.error("上传文件失败 :文件名为--'" + multipartFile.getOriginalFilename() + "'--");
				logger.info(e.getMessage());
			}
		}
		return urlPath;
		
	}
	
	
	/*
	 * @RequestMapping("/delete")
	 * @ResponseBody
	 * public void deleteUploadImg(){
	 * storageClient.deleteFile("group1/M00/00/00/wKgBqFmeNkGAD36xAAJRpy6coe8354.jpg");
	 * }
	 */
	/**
	 * 返回主框架页面
	 * 
	 */
	@RequestMapping("/index")
	public String index()
	{
		
		return "index";
	}
}

