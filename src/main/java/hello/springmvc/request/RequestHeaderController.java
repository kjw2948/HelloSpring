package hello.springmvc.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Slf4j
public class RequestHeaderController {


    // 헤더정보를 어떻게 받는지 확인하기 위함
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie) {

        log.info("request ={}",request );
        log.info("response ={}", response);
        log.info("httpMethod={}",httpMethod );
        log.info("locale ={}",locale );
        log.info("headerMap ={}", headerMap);
        log.info("host ={}", host);
        log.info("cookie ={}", cookie);

        return "OK";
    }
}
