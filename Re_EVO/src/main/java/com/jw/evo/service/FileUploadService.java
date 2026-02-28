package com.jw.evo.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileUploadService {
	private final ServletContext servletContext;

	public String upload(MultipartFile file, String subDir) {
		// 1. 첨부파일이 없으면 null 반환 (DB에도 null로 들어가도록)
		if (file == null || file.isEmpty()) {
			return null;
		}
		// 2. 프로젝트 내부의 실제 배포 경로 가져오기
		String basePath = servletContext.getRealPath("/resources/img/upload");
		String targetPath = basePath + File.separator + subDir;
		// 3. 폴더가 없으면 생성
		File directory = new File(targetPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		// 4. UUID + 원본 파일명 조합
		String originalFileName = file.getOriginalFilename();

		//파일명 null 체크 및 소문자 변환
		if (originalFileName == null || originalFileName.trim().isEmpty()) {
		    throw new RuntimeException("파일명이 존재하지 않습니다.");
		}

		// 확장자 검사를 위해 임시로 소문자로 변환
		String lowerFileName = originalFileName.toLowerCase();

		// 대소문자 상관없이 확장자 필터링 통과!
		if (!(lowerFileName.endsWith(".png") || lowerFileName.endsWith(".jpg") || lowerFileName.endsWith(".jpeg"))) {
		    throw new IllegalArgumentException("이미지 파일(.png, .jpg, .jpeg)만 업로드 가능합니다."); 
		    // 팁: 단순 RuntimeException보다 인자값이 잘못되었다는 뜻의 IllegalArgumentException을 쓰면 예외의 의미가 더 명확해집니다!
		}
		//파일 이름을 png 나 등등으로 바꿔서 다른 파일 올리는 것 방지
		String contentType = file.getContentType();
		if (contentType == null || !(contentType.equals("image/png") || contentType.equals("image/jpeg"))) {
		    throw new IllegalArgumentException("허용되지 않는 파일 형식입니다.");
		}

		String savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
		// 5. 서버에 파일 저장
		try {
			File targetFile = new File(targetPath + File.separator + savedFileName);
			file.transferTo(targetFile);

			return savedFileName; // 최종 생성된 파일명 반환
		} catch (IOException e) {
			// 파일 저장 실패 시 RuntimeException을 던져서
			// SellerService의 @Transactional이 롤백되도록 유도해야 합니다!
			throw new RuntimeException("파일 업로드 중 오류가 발생했습니다.", e);
		}
	}

}
