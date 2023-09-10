package com.mycompany.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*
	JoinPoint인터페이스
		; 횡단관심에 해당하는 어드바이스(공통코드) 메소드를 잘 구현하려면 클라이언트가 요청한 비즈니스 메소드의 정보를 알아야한다.
			. 예외가 발생한 비즈니스 메소드 이름이?
			. 그 메소드가 속한 클래스와 패키지정보 ? 등,, 이러한 정보를 이용할 수있도록 스프링은 JointPoint인터페이스를 제공한다. 
		
		* Signature getSignature() : 클라이언트가 요청한 메소드의 시그니쳐(리턴타입, 메소드 이름, 매개변수) 정보가 담긴 객체
		
		* Object getTatget() : 클라이언트가 호출한 비즈니스 메소드를 포함하고있는 객체리턴
		
		* Object[] getArgs() : 클라이언트가 메소드를 호출할때 넘겨준 인자목록
		
		Signature객체
			. String getName() : 클라이언틑가 요청한 메소드이름 리턴
			. String toLongString() : 클라이언트가 호출한 리턴타입, 매개변수, 메소드 이름, 매개변수를 패키지 경로까지 포함 리턴
			. String toShortString() : 호출한 메소드 시그니쳐를 축약한 문자열로 리턴
		
	JointPoint 객체생성과정
		- 사용자 요청 > 스프링컨테이너가 호출과 관련정보를 담은 JointPoint 객체를 생성한다.
			> 스프링 컨테이너가 applicationContext.xml에 설정되어 있는 method를 호출할떄 이 객체를 인자로 넘겨준다.
	
	동작에 따른 활용
	 	- Before, After들 어드바이스 모두.., JointPoint를 사용
	 	- Around어드바이스는  ProceedingJoinPoint를 사용해야한다.
	 	 

*/
@Service
@Aspect
public class BeforeAdvice {
	
	//포인트컷
	/*
	 * @Pointcut("execution(* com.mycompany.biz..*impl.*(..))") public void
	 * allPointCut() {}
	 * 
	 * @Pointcut("execution(* com.mycompany.biz..*impl.get*(..))") public void
	 * getPointCut() {}
	 */
	
	//어드바이스관련 처리 
	/*
		@Before("~~()"), @AfterReturning()
		@AfterThrowing(""), @After
		@Around() - 호출자체를 가로채서 메소드 실행 전후 처리할 로직을  삽입한다.
	*/
	
	@Before("PointCutCommon.allPointCut()") // id 입력
	public void beforeLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전처리]"+method+"()메소드와 args정보 : ");
	}
}
