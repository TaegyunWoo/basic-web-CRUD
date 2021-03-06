# 프로젝트 계획서

<br/><br/>

# 학습 개요

## 학습 목표

- 기본적인 게시판형 웹 애플리케이션을 구축한다.
- 스프링부트를 활용하여 백엔드를 구현한다.
- 서버단 구축에 집중한다.

<br/>

## 기대 효과

- 스프링을 활용한 웹 애플리케이션에 대한 큰 그림이 그려진다.
- 직접 작성한 코드를 통해, 스프링에 대한 개념과 원리를 피부로 느낀다.
- 그동안 학습한 스프링의 개념과 원리가 머릿속에서 정리된다.
- Thymeleaf 문법을 익힌다.

<br/><br/>

# 프로젝트 계획

## 개요

### 프로젝트 주제

- 기본적인 게시판형 웹 애플리케이션 (CRUD)

### 개발 내용

- 로그인
- CRUD형 게시판
- 예외 처리

<br/>

## 시스템 구성도

### SW 구성도

![Untitled](/docs/img/Untitled%201.png)

### 적용 기술

|구분|기술|
|----|----|
|Front|BootStrap Templete|
|Back|Spring Boot|
|DB|MariaDB|
|Template Engine|Thymeleaf|

<br/><br/>

# 요구 분석

## 시스템 제공 기능

- 로그인
- 게시글 읽기, 쓰기, 수정, 삭제

<br/>

## 시스템 WorkFlow

![Untitled](/docs/img/Untitled%202.png)

<br/>

## 요구사항 상세

### 1. 로그인 기능

- 서버에 저장된 정보를 기반으로 사용자가 로그인할 수 있다.
- SNS 로그인 기능은 제공하지 않는다.
- 아이디 찾기 및 비밀번호 찾기는 제공하지 않는다.
- 세션을 통해, 로그인 상태를 유지할 수 있도록 한다.
- 로그인에 실패할 경우
    - "존재하지 않는 아이디나 비밀번호입니다." 와 같은 메시지로 사용자에게 안내한다.

### 2. 회원가입 기능

- 사용자가 로그인을 할 수 있도록 회원가입 기능을 제공한다.
- 사용자 정보는 자체 DB에서 관리한다.
- 아이디
    - 빈 값을 제출할 수 없다.
    - 클라이언트단에서 검사 진행 X (자바스크립트 사용 X)
    - 오직 서버단에서만 값을 검증한다.
- 비밀번호
    - 빈 값을 제출할 수 없다.
    - 숫자, 알파벳, 특수문자 조합으로 이루어져야 한다.
    - 클라이언트단에서 검사 진행 X (자바스크립트 사용 X)
    - 오직 서버단에서만 값을 검증한다.
- 값 검증에 실패할 경우
    - 잘못된 값이 입력된 필드를 사용자에게 설명과 함께 안내한다.

### 3. 사용자 인증

- 애플리케이션에 접속한 사용자가 인증된 사용자인지 검사한다.
- 인증된 (회원가입된) 사용자가 사용할 수 있는 기능
    - 글 읽기
    - 글 쓰기
    - 자신이 작성한 글 수정
    - 자신이 작성한 글 삭제
- 인증되지 않은 사용자가 사용할 수 있는 기능
    - 글 읽기
- 인증되지 않은 사용자가 사용할 수 없는 기능에 접근시, UI 안내와 함께 로그인 페이지로 리다이렉션한다.
    - 로그인 페이지로 리다이렉션된 후, 로그인이 성공하면 다시 원래 페이지로 돌아올 수 있어야 한다.

### 4. 게시글 작성

- 사용자가 직접 작성해야하는 항목
    - 제목
    - 본문
- 값 검증
    - 제목은 비어있을 수 없다.
    - 본문의 글자수는 10자 이상이어야 한다.
- 값 검증에 실패할 경우
    - 잘못된 값이 입력된 필드를 사용자에게 설명과 함께 안내한다.

### 5. 게시글 보기

- 사용자에게 제공하는 정보
    - 제목
    - 본문
    - 작성일 (글 수정시 경우, 작성일을 업데이트한다.)
    - 작성자

### 6. 게시글 수정

- 제목, 본문 모두 수정할 수 있다.
- 값 검증
    - 제목은 비어있을 수 없다.
    - 본문의 글자수는 10자 이상이어야 한다.
- 값 검증에 실패할 경우
    - 잘못된 값이 입력된 필드를 사용자에게 설명과 함께 안내한다.
