package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //애플리케이션 컨텍스트가 사용할 설정정보
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean//빈을 생성할 메소드
    public MemberService memberService() { //메소드 반환타입 MemberService는 빈의 타입, 메소드 이름은 빈의 이름
        return new MemberService(memberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository() {
    //return new MemoryMemberRepository();
    //return new JdbcMemberRepository(dataSource);
    //return new JdbcTemplateMemberRepository(dataSource);
    //return new JpaMemberRepository(em);
    //}
}
