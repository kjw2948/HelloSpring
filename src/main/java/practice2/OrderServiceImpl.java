package practice2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final MemberService memberService;
    private final MemberRepository memberRepository;
}
