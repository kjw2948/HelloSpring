package hello.springmvc.controller;


import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HttpRequestController {


    //request 바디에 있는 내용을 읽어서 messageBody에 넣어줌
    @PostMapping("/request-body-string-v4")
    public HttpEntity<String> requestBodyStringV4(@RequestBody String messageBody) {
        return new HttpEntity<>("ok");
    }

    @GetMapping("/request-body-string-v4")
    public HttpEntity<String> requestBodyGetV4(@RequestParam String username,
                                               @RequestParam int age,
                                               @RequestParam String messageBody) {
        return new HttpEntity<>("success");
    }
}

