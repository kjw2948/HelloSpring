package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String LogTest() {
        String name = "Spring";
        log.trace(" trace log = {}", name);  //
        log.debug(" debug log = {}", name);  // 디버그할 때 (개발서버)
        log.info(" info log = {}", name); // 비즈니스 정보
        log.warn(" warn log = {}", name); // 경고
        log.error(" error log = {}", name); // 에러

        return "ok";
    }
}
