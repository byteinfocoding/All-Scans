package top.byteinfo.blogsecurity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.byteinfo.blogsecurity.dao.RoleDao;
import top.byteinfo.blogsecurity.model.JSON;
import top.byteinfo.blogsecurity.model.ResourceRoleDTO;

import java.util.List;

@SpringBootTest
class BlogSecurityApplicationTests {
    @Autowired
    RoleDao roleDao;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() throws JsonProcessingException {
//        String encode = passwordEncoder.encode("1234");
//        System.out.println(encode);

        List<ResourceRoleDTO> resourceRoleDTOS = roleDao.listResourceRoles();

        String jsonString = JSON.toJSONString(resourceRoleDTOS);
        System.out.println(resourceRoleDTOS);
        System.out.println(jsonString);
        System.out.println("==============================================");
        System.out.println("==============================================");
        for (ResourceRoleDTO resourceRoleDTO : resourceRoleDTOS) {
            resourceRoleDTO.getUrl();
            resourceRoleDTO.getRequestMethod();
            List<String> roleList = resourceRoleDTO.getRoleList();
            String[] strings = roleList.toArray(new String[]{});
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println("----------------------------");
            System.out.println(roleList);
            System.out.println("==============================================");

        }

    }

}
