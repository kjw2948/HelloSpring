package hello.springmvc.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * {"username" : "kim" , "age" : 20}
 * content-type : application/json
 */
@Controller
@Slf4j
public class RequestBodyJsonController {

    // ObjectMapper로 메시지바디에 있는 값을 가지고 있는 객체로 변환
    private ObjectMapper objectMapper = new ObjectMapper();


    // HttpServlet 사용하여 요청 메시지 바디 읽고 응답 보내기
    @PostMapping("request-body-json-v1")
    public void RequestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody = {}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username = {}, age ={}", helloData.getUsername(), helloData.getAge());


        response.getWriter().write("ok");
    }

    //HttpServlet 대신 @RequestBody 이용
    @PostMapping("request-body-json-v2")
    public String RequestBodyJsonV2(@RequestBody String messageBody) throws IOException {
        log.info("messageBody = {}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username = {}, age ={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }


    //객체를 바로 선언하여 ObjectMapper를 이용한 객체 변환과정 없이 객체 자체를 넘겨서 바디에 있는 값들을 넣어줌
    //@Re
    @ResponseBody
    @PostMapping("request-body-json-v3")
    public String RequestBodyJsonV3(@RequestBody HelloData helloData) {
        log.info("username = {}, age ={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v4")
    public String RequestBodyJsonV4(HttpEntity<HelloData> httpEntity) {
        HelloData helloData = httpEntity.getBody();
        log.info("username = {}, age ={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v5")
    public HelloData RequestBodyJsonV5(@RequestBody HelloData helloData) {
        log.info("username = {}, age ={}", helloData.getUsername(), helloData.getAge());
        return helloData;
    }

    
}
