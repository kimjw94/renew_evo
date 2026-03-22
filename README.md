# 쇼핑몰 웹 애플리케이션 재구축

## 프로젝트 소개
기존 쇼핑몰 프로젝트를 기반으로 구조 개선 및 유지보수성을 고려하여 재설계 중인 프로젝트

## 기술 스택
- Java, Spring Framework, MyBatis
- Oracle DB
- Spring Security

## 주요 개선 사항
- DB 구조 재설계 (Account / Profile / Address / Role 분리)
- Controller → Service → DAO 구조로 개선
- DTO / VO 기반 데이터 구조 개선
- Apache Commons FileUpload 적용
- Spring Security 기반 인증/인가 적용

## 진행 상태
- 핵심 사용자 및 권한 구조 구현 완료
- 판매자 승인 프로세스 구현 완료
- 상품 등록 / 주문 / 결제 기능 추가 개발 진행 중
