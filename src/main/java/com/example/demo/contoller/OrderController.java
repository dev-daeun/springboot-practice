package com.example.demo.contoller;

import com.example.demo.dto.GetOrderDto;
import com.example.demo.dto.PostOrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// API 스펙은 http://localhost:8080/swagger-ui/index.html 에서 조회

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final Logger LOGGER  = LoggerFactory.getLogger(OrderController.class);

    // path param
    @GetMapping(value = "{orderId}")
    public String getOrder(@PathVariable int orderId) {
        LOGGER.info("getOrder({}) Called.", orderId);
        return "this is order " + orderId;
    }

    // GetMapping 어노테이션에 명시된 path param 이름과 메서드 파라미터 이름을 다르게 하고 싶을 때
    @GetMapping(value = "/diff/{orderId}")
    public String getDiffOrder(@PathVariable(value = "orderId") int differentVarName) {
        return "this is diff order " + differentVarName;
    }

    // query param (default: required -> 쿼리파람 없이 요청하면 400 BAD request)
    @GetMapping
    public String getFilteredOrder(@RequestParam int zoneId, @RequestParam String deliveryVendor) {
        return "orders filtered with " + zoneId  + deliveryVendor;
    }

    // query param 키 이름이 뭔지 모를 때?
    @GetMapping(value = "/random")
    public String getFilteredOrderWithRandomKey(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // DTO 형식으로 query param 선언
    @GetMapping(value = "/dto")
    public String getOrderWithDto(GetOrderDto orderDto) {
        return orderDto.toString();
    }

    // RestController 는 자동으로 DTO -> JSON 으로 response body 타입 변환
    @PostMapping
    public PostOrderDto postOrder(@RequestBody PostOrderDto postOrderDto) {
        return postOrderDto;
    }

    // ResponseEntity 활용
    @PutMapping(value = "/{orderId}")
    public ResponseEntity<PostOrderDto> updateOrder(@RequestBody PostOrderDto postOrderDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("some-header1", "some-value1");
        headers.set("some-header2", "some-value2");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(postOrderDto);
    }

    @DeleteMapping(value = "/{orderId}")
    public String deleteOrder(@PathVariable  int orderId, @RequestParam String reason) {
        return "order " + orderId + " deleted because of " + reason;
    }
}
