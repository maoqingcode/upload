package test;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class UserControllerTest {
    @Test
    public void testHandle(){
        RestTemplate restTemplate=new RestTemplate();
        MultiValueMap<String,String> form=new LinkedMultiValueMap<String, String>();
        form.add("name","lily");
        form.add("age","22");
        restTemplate.postForLocation("http://localhost:8080/handle1",form);
    }
    @Test
    public void testHandle2() throws IOException {
        RestTemplate restTemplate=new RestTemplate();
        byte[] resp=restTemplate.postForObject("http://localhost:8080/handle2/{imageId}",null,byte[].class,"1233");
       Resource outFile=new FileSystemResource("d:/image_copy3.jpg");
        FileCopyUtils.copy(resp,outFile.getFile());
    }
}
