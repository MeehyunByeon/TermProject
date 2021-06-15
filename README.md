# TermProject
------------------------------
  ## 1. 프로젝트 설명
  * 프로젝트 주제
    - [Programing Term]
    - 다양한 프로그래밍 용어들을 정의함으로써 프로그래밍의 이해와 실력을 높이는 웹서비스
  
  * 프로젝트 개발 동기 및 목적
    - 2학년이 되어 웹서비스와 관련된 전공 지식을 배우면서 생소한 용어들로 인해 조금 어려움을 겪었고, 헷갈리거나 어려운 용어들을 이해하는 데 도움을 주는 웹서비스의 필요성을 느껴 기획하게 되었습니다. 이 프로젝트의 목적은 컴퓨터 분야를 전공으로 하는 학생들이 전공을 이해하고 실력이 향상되는 데 도움이 되고, 회원들의 용어 등록 시스템을 통해 지식 공유의 환경을 제공하기 위해서입니다. 웹서비스 개발에 대한 완전한 이해뿐만 아니라 용어 데이터를 수집하며 다시 한번 배운 내용을 정리해보는 효과를 기대하며 프로젝트에 임했습니다.
  
  -----------------------------------------------
  ## 2. 프로젝트 기능
  ### 비회원
  1. 용어 검색 및 용어 상세보기
  
  ### 회원
  1. 용어 검색 및 용어 상세보기
  2. 용어 등록
  3. 등록한 용어 수정 및 삭제
  4. 용어 정의 요청
  5. 보관함에 용어 저장
  6. 개인정보 수정
  
  ### 관리자
  1. 회원의 모든 기능
  2. 모든 용어 수정 및 삭제 가능
  3. 모든 회원 리스트 확인
  
  -------------------------------
  ## 3. 폴더 구조
  > Java Resources
  >> src
  >>> cs.term.controller
  >>>> 1. 기본
  >>>> * Controller.java
  >>>> * HttpUtil.java
  >>>> * FrontController.java -> .do
  >>>> * MainpageController.java -> 메인 화면
  >>>> * AlltermController.java -> 용어 리스트 화면
  >>>> * StorageController.java -> 보관함 화면
  >>>> * RequestController.java -> 요청 화면
  
  >>>> 2. 웹서비스 기능
  >>>> * ResearchController.java -> 용어 검색
  >>>> * ConnectController.java -> 용어 상세보기
  >>>> * EnrollController.java  -> 용어 등록
  >>>> * TermUpdateController.java -> 용어 수정
  >>>> * TermDeleteController.java -> 용어 삭제
  >>>> * StoreController.java -> 보관함에 용어 저장
  >>>> * PlusReqController.java -> 용어 정의 요청
  >>>> * ReqDeleteController.java -> 용어 정의 요청 삭제
  
  >>>> 2. 회원
  >>>> * LoginController.java -> 로그인
  >>>> * JoinController.java -> 회원가입
  >>>> * MyInfoController.java -> 회원정보 셋팅
  >>>> * UpdateController.java -> 회원정보 수정
  >>>> * FindInfoController.java -> 아이디&비밀번호 찾기
  
  >>>> 3. 관리자
  >>>> * ManagerController.java -> 관리자 화면
  
  >>> cs.term.dao
  >>>> * termDAO.java
  
  >>> cs.term.service
  >>>> * termService.java
  
  >>> cs.term.vo
  >>>> * Member.java -> 회원
  >>>> * Request.java -> 요청
  >>>> * Storage.java -> 저장
  >>>> * Term.java -> 용어
  
  > WebContent
  >> css
  >>> 하나의 css 파일에 모든 것을 담기에는 수정 및 추가가 어려워 3개의 css 파일로 나누어 개발했다. 보통 css 파일명과 관련된 jsp에 사용했지만, 제공하고자 하는 결과 화면이 같을 경우 css 파일명과 관련 없이 사용하였다.
  
  >> termResult
  >>> 보관함 저장 이후, 아이디나 비밀번호 찾기 성공 및 실패 등 간단한 정보를 알려주고 다른 페이지로의 이동을 선택할 수 있는 화면
  >>> * joinsuccess.jsp -> 회원가입 성공 화면
  >>> * enrollSuccess.jsp -> 용어등록 성공 화면
  >>> * storeSuccess.jsp -> 보관함 저장 성공 화면
  >>> * updateSuccess.jsp -> 회원정보 수정 성공 화면
  >>> * findInfo.jsp -> 아이디&비밀번호 찾기 결과 화면
  >>> * searchResult.jsp -> 용어 검색 결과 화면
  >>> * loginfail.jsp -> 로그인 실패 화면
  >>> * storeFail.jsp -> 보관함 저장 실패 화면
  >>> * toStorageFail.jsp -> 로그아웃 상태_보관함, 용어 요청, 용어 등록 등을 클릭한 상항에 사용하는 화면
  
  >> WEB-INF
  >>> * web.xml
  >>>> 가장 처음에 시작할 때 start.jsp가 실행되도록, .do로 끝나는 모든 것은 FrontController로 이동하도록 설정
  
  >> * start.jsp -> 웹서비스를 가장 처음 시작할 때 한번 만 실행
  >> * header.jsp -> 웹서비스 헤더
  >> * footer.jsp -> 웹서비스 푸터
  >> * main.jsp -> 메인 페이지
  >> * login.jsp -> 로그인 페이지
  >> * logout.jsp -> 로그아웃 페이지
  >> * enroll.jsp -> 용어 등록 페이지
  >> * request.jsp -> 요청 페이지
  >> * storage.jsp -> 보관함 페이지
  >> * termlist.jsp -> 용어 리스트 페이지
  >> * detailterm.jsp -> 용어 상세보기 페이지
  >> * manager.jsp -> 관리자 페이지
  >> * myinfo.jsp -> 회원정보 페이지
  >> * join.jsp -> 회원가입 페이지
  >> * termUpdate.jsp -> 용어 수정 페이지
  >> * findIdPwd.jsp -> 로그인&비밀번호 찾기 페이지
  
  
