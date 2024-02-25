package utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileOutputStream;

public class TestDataWriter {
    @SneakyThrows
    public static void dataWriter(String path, Object object){
        ObjectMapper objectMapper =new ObjectMapper();
        FileOutputStream fileOutputStream=new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/test_data/"+path);
        objectMapper.writeValue(fileOutputStream,object);

    }

}
