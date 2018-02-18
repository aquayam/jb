package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UsersVo;

@Service
public class BlogService {
	@Autowired
	BlogDao blogDao;

	public BlogVo getBlog(int userNo) {
		
		return blogDao.getBlog(userNo);
	}

	public void updateBlog(BlogVo blogVo, MultipartFile blogFile) {
		
		String saveDir = "D:\\JAVA\\upload";
		// 파일 정보 수집
		// original 파일이름
		String orgName = blogFile.getOriginalFilename();
		System.out.println(orgName);

		// 확장자 (.뭐뭐뭐)
		String exName = blogFile.getOriginalFilename().substring(blogFile.getOriginalFilename().lastIndexOf("."));
		System.out.println(exName);

		// 저장될 파일 이름
		// 파일명 중복을 피하기 위해서 UUID 사용
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);

		// 파일위치 (path)
		String filePath = saveDir + "\\" + saveName;
		System.out.println(filePath);

		// 파일 사이즈.getSize() (default로 byte단위)
		/*
		 * 8bit -> 1BYTE 
		 * 1024byte -> 1KB 
		 * 1024KB -> 1MB 
		 * 1024MB -> 1GB 
		 * 1024GB -> 1TB
		 */
		long fileSize = blogFile.getSize();
		int kbSize = (int) Math.ceil(fileSize / 1024.0);
		System.out.println(fileSize + " 바이트");
		System.out.println(kbSize + "kb");
		
		// 사용자가 업로드한 파일 카피
		try {
			
			byte[] fileData = blogFile.getBytes();
			OutputStream out = new FileOutputStream(saveDir + "\\" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			bout.write(fileData);
			
			if(bout != null) {
				bout.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		blogVo.setBlogFile(saveName);
		blogDao.updateBlog(blogVo);
	}
}
