package hello.springmvc.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET) // 해당 요청 URL과 매핑되는 메서드
    public String helloBasic() {
        log.info("helloBasic");
        return "OK";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * 경로변수 @PathVariable --> 리소스 경로에 식별자를 넣는 스타일
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        //@PathVariable String userId 요런식으로 리소스 경로에 식별자 이름과 데이터이름이 같으면 따로 이름을 안정해줘도 데이터명을 인식함
        log.info("mappingPath userId ={} ", data);
        return "ok";
    }

    @GetMapping("/mapping/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable String userId,
                              @PathVariable String orderId) {
        log.info("mappingPath userId ={}, orderId = {} ", userId, orderId);
        return "Ok";
    }

}
