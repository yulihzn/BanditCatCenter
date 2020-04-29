package com.banditcat.center.round;

import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@CrossOrigin
@RestController
public class RoundController {
    @RequestMapping(value = "/mapList",method = RequestMethod.GET)
    String queryMapList(@RequestParam("file") String filename){
        return readFile(filename);
    }
    public String readFile( String fileName) {
        String jsonStr = "";
        String path =RoundController.class.getClassLoader().getResource("").getPath();
        try {
            File file = new File(path+fileName);
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return "path: "+path+fileName+" is not exist";
        }
    }
}
