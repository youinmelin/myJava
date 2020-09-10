package com.lin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class RunPythonController {

    @ResponseBody
    @RequestMapping("/python")
    public String runPython() throws IOException, InterruptedException {
        String exe = "python";
        String command = "D:\\testing_tools\\my_git\\practice2020\\data_wrangling\\sort_excel_by_key_argv.py";
//        String path = "data_source\\";
        String filename = "panda_02_read_excel_02.xlsx";
        String[] cmdArr = new String[] {exe, command, filename};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readLine();
        process.waitFor();
        System.out.println(str);
        return str;
    }
}
