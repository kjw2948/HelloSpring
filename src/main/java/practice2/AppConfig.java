package practice2;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemberServiceImpl(memberRepository()),
                memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
