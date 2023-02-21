import com.examSystem.ExamSystemApplication;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.UserRegisterDto;
import com.examSystem.domain.vo.CourseVo;
import com.examSystem.mapper.CourseMapper;
import com.examSystem.service.MenuService;
import com.examSystem.service.UserService;
import com.examSystem.utils.PathUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest(classes = ExamSystemApplication.class)
public class test {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void password() {
        String encode = passwordEncoder.encode("111");
        System.out.println(encode);
    }


    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Test
    public void userTest() {
        ResponseResult routers = menuService.getRouters();
        System.out.println(1);
    }

    @Test
    public void UserServiceTest() {
        UserRegisterDto dto = new UserRegisterDto("test1", "女", "17451236489",
                "信息学院", PathUtils.CAPTCHA, "123456");
        ResponseResult register = userService.register(dto);
        Object data = register.getData();
    }

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void CourseTest() {
        int start = (1 - 1) * 10;
        List<CourseVo> courseVos = courseMapper.listAllByUserId(13L, start, 10);
        System.out.println(1);
    }
}
