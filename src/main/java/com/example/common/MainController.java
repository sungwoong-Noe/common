package com.example.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {


    @GetMapping("/")
    public ResponseEntity<?> main() {
        return ResponseEntity.ok().body("메인페이지입니다");
    }

    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 페이지입니다.");
    }

    @GetMapping("/user")
    public ResponseEntity<?> user() {
        return ResponseEntity.ok().body("사용자 페이지입니다.");
    }


    @GetMapping("/admin")
    public ResponseEntity<?> adminPage() {
        return ResponseEntity.ok().body("관리자 페이지입니다.");
    }


}
