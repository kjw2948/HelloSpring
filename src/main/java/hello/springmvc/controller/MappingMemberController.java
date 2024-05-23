package hello.springmvc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingMemberController {

    @GetMapping
    public String user() {
        return "get users";
    }

    @PostMapping
    public String save() {
        return "add users";
    }

    @GetMapping("/{userId}")
    public String find(@PathVariable Long userId) {
        return "get userId = " + userId;
    }

    @PatchMapping("/{userId}")
    public String update(@PathVariable Long userId) {
        return "update userId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable Long userId) {
        return "delete userId = " + userId;
    }
}
