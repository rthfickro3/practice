package com.webapp.controller;

import com.webapp.Dto.UserDto;
import com.webapp.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@AllArgsConstructor
@Controller
public class ScheduleManagementToolController {
    private UserService userService;

    @GetMapping("/Index.do")
    public String Index() {
        return "/Index";
    }

    @GetMapping("/Login.do")
    public String Login(){
        return "/Login";
    }

    @GetMapping("/Register.do")
    public String Register(UserDto userDto){
        return "/Register";
    }

    @PostMapping("/Register.do")
    public String SuccessRegister(@Valid UserDto userDto, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("userDto", userDto);

            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()){
                model.addAttribute(key, validatorResult.get(key));
            }

            return "/Register";
        }/*

        if(!userDto.isPwEqualToCheckPw()){
            model.addAttribute("valid_password_Check", "비밀번호가 일치하지 않습니다.");
            return "/Register";
        }*/

        userService.joinUser(userDto);

        return "redirect:/Login.do";
    }
}
