# TermProject<Programing Term>
------------------------------
  ## 1. 프로젝트 설명
  * 프로젝트 주제
    - 프로그래밍 용어의 이해를 돕는 웹서비스
  
  * 프로젝트 목적
    - 컴퓨터 분야를 전공으로 하는 학생들이 전공 지식을 확실히 이해하고 실력을 향상하는 데 도움이 되기 위해
    - 회원들의 용어 등록 시스템을 통해 지식 공유의 환경을 제공하기 위해
  
  -----------------------------------------------
  ## 2. 프로젝트 기능
  ### 회원
  1. 용어 검색
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
  >>> 하나의 css 파일에 모든 것을 담기에는 수정 및 추가가 어려워 3개의 css 파일로 나누어 개발했다. 보통 css 파일명과 관련된 jsp에 사용했지만, 새로 만들 필요성을 못 느낀 경우 css 파일명과 관련 없이 사용하였다.
  
  >> termResult
  >>> 보관함 저장 이후, 아이디나 비밀번호 찾기 성공 및 실패 등 간단한 정보를 알려주고 다른 페이지로의 이동을 선택할 수 있는 화면
  
  >> WEB-INF
  >>> * web.xml
  >>>> 가장 처음에 시작할 때 start.jsp가 실행되도록, .do로 끝나는 것은 FrontController로 이동하도록 설정
  
  
