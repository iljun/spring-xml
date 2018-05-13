# spring-xml

어노테이션 설정 없이 xml로 간단한 게시판 구현

## 사용기술
Spring MVC

Tomcat

myBatis

mySql

## xml 설정에 초점을 맞춰보았다
컨트롤러 코드는 형편없지만 xml 설정만으로 어노테이션없이 간단한 컨트롤러만 만들어보았다.

만약 rest형식으로 요청을 받아야한다면 Servlet을 하나 더 등록하면 된다.

HandlerMapping에 컨트롤러를 등록하느건 SimpleUrlHandlerMapping을 사용해
url에 따라 메소드명을 찾아가게 만들었다.

MultiActionController가 deprecated여서 코드 수정이 필요하다.

Autowired도 마찬가지로 xml설정으로 진행했다.
