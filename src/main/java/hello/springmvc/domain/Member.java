package hello.springmvc.domain;

import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String name;
    private int age;
    private boolean deletedYn;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
        this.deletedYn = false;
    }

    public Member createMember(String name, int age) {
        return new Member(name, age);
    }
}
