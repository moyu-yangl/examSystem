import com.examSystem.ExamSystemApplication;
import com.examSystem.domain.entity.User;
import com.examSystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Test
    public void userTest() {
        User byId = userService.getById(1);
        System.out.println(byId.getName());
    }
}
