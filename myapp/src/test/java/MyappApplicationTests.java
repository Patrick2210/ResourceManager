import com.szaruga.myapp.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class MyappApplicationTests {
    private MockMvc mockMvc;
    MemberServiceImpl memberService;

    @Test
    void contextLoads() {
    }

}
