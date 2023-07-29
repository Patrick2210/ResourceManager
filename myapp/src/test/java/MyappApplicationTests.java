import com.szaruga.myapp.entity.Members;
import com.szaruga.myapp.service.MemberServiceImpl;
import com.szaruga.myapp.service.MembersService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class MyappApplicationTests {
    private MockMvc mockMvc;
    MemberServiceImpl memberService;

    @Test
    void contextLoads() {
    }

}
