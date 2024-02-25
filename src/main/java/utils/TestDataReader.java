package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileInputStream;

public class TestDataReader {
    @SneakyThrows
    public static <T> T dataReader(String path, Class<T> typeValue) {
        ObjectMapper mapper = new ObjectMapper();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path);
        return mapper.readValue(fileInputStream,typeValue);
    }

}
