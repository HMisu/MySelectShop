package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.FolderRequestDto;
import com.sparta.myselectshop.dto.FolderResponseDto;
import com.sparta.myselectshop.security.UserDetailsImpl;
import com.sparta.myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders")
    public void addFolders(@RequestBody FolderRequestDto folderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<String> folderNames = folderRequestDto.getFolderNames();
        folderService.addFolders(folderNames, userDetails.getUser());
    }

    @GetMapping("/folders")
    public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return folderService.getFolders(userDetails.getUser());
    }

    // @ExceptionHandler : 스프링에서 Controller에서 발생한 예외처리 하기 위해 사용
    // AOP를 이용하 예외 처리 방식이어서 메소드마다 try-catch 할 필요 없음
    // @ExceptionHandler({IllegalArgumentException.class})
    // public ResponseEntity<RestApiException> handleException(IllegalArgumentException ex) {
    //     RestApiException restApiException = new RestApiException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    //     return new ResponseEntity<>(
    //             // HTTP body
    //             restApiException,
    //             // HTTP status code
    //             HttpStatus.BAD_REQUEST
    //     );
    // }
}
