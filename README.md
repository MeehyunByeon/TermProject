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
  
  ## 3. 폴더 구조
  > Java Resources
  >> src
  >>> cs.term.controller
  >>>> * AlltermController.java
  >>>> * ConnectController.java
  >>>> * Controller.java
  >>>> * EnrollController.java  
  >>>> * FindInfoController.java
  >>>> * ForntController.java
  >>>> * HttpUtil.java
  >>>> * JoinController.java
  >>>> * LoginController.java
  >>>> * MainpageController.java
  >>>> * ManagerController.java
  >>>> * MyInfoController.java
  >>>> * PlusReqController.java
  >>>> * ReqDeleteController.java
  >>>> * RequestController.java
  >>>> * ResearchController.java
  >>>> * StorageController.java
  >>>> * StoreController.java
  >>>> * TermDeleteController.java
  >>>> * TermUpdateController.java
  >>>> * UpdateController.java
  
  
  >>> cs.term.dao
      >>>> * termDAO.java
  
  >>> cs.term.service
  >>>> * termService.java
  
  
  >>> cs.term.vo
  >>>> * Member.java
  >>>> * Request.java
  >>>> * Storage.java
  >>>> * Term.java
  
        
