package com.bounce.submore.user;

import com.bounce.submore.user.domain.User;
import com.bounce.submore.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @RequestMapping("/join")
    public String join() {
        return "user/join";
    }

    @GetMapping("/login")
    public String loginView() {
        return "user/login";
    }

    @PostMapping("/loginPost")
    public String login(
            @RequestParam("loginId") String loginId,
            @RequestParam("password") String password,
            HttpServletRequest request) {

        // DB에서 사용자 정보 조회
        User user = userService.getUserByLoginId(loginId);

        // 로그인 판별 (비밀번호는 나중에 암호화 체크로 수정 필요)
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {

            // 세션에 로그인 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("loginId", user.getLogin_id());
            session.setAttribute("userName", user.getName());
            return "redirect:/main"; // 로그인 성공 시 메인으로
        } else {
            return "redirect:/user/login-view?error=true"; // 실패 시 에러 표시와 함께 이동
        }
    }


}
