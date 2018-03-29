package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import models.ImageInfo;

@Controller
public class UploadFile {
	
	private final static String path = "/var/lib/tomcat8/webapps/XMemo/files/images";
	// 属于图片格式
	private final static String[] imgFormat = { ".bmp", ".jpg", ".jpeg",
			".png", ".gif" };
	private final static List<String> imgFormatList = Arrays.asList(imgFormat);
	
	@ResponseBody
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public ImageInfo upImg(HttpServletRequest request)
			throws IllegalStateException, IOException {

		ImageInfo imageInfo = new ImageInfo();
		// 获取的request转换为图片
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		// 获取对应file对象
		Map<String, MultipartFile> imageMap = multipartRequest.getFileMap();
		Iterator<String> imageIterator = multipartRequest.getFileNames();

		// 一个一个获取
		while (imageIterator.hasNext()) {
			String fileKey = imageIterator.next();
			// 获取对应文件
			MultipartFile multipartFile = imageMap.get(fileKey);

			// 获取文件后缀名,并且转换为小写,判断后缀是否为图片
			String fileSuffix = multipartFile.getOriginalFilename().substring(
					multipartFile.getOriginalFilename().lastIndexOf("."));
			fileSuffix = fileSuffix.toLowerCase();

			boolean isUpImage = false;
			// 判断,后缀名属于图片,且文件一致
			if (imgFormatList.contains(fileSuffix)
					&& multipartFile.getSize() != 0L) {
				isUpImage = true;
			}

			// 如果无问题，则上传成功，否则失败
			if (isUpImage) {
				
				String imageName = UUID.randomUUID() + fileSuffix;
				multipartFile.transferTo(new File(path, imageName));

				imageInfo.setData(imageName);
				imageInfo.setMsg("上传成功");
				imageInfo.setStatus(1);
				

			} else {
				imageInfo.setMsg("上传失败");
				imageInfo.setStatus(0);
			}
		}
		System.out.println(imageInfo.getMsg());
		return imageInfo;
	}
}
