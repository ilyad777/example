package ru.example.views;

import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

public class MyView implements View {

    public String getContentType() {
        return null;
    }

    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        SoyFileSet sfs = SoyFileSet.builder()
                .add(new File(MyView.class.getClassLoader().getResource("templates/hello.soy").getFile())).build();

        SoyTofu tofu = sfs.compileToTofu();
        httpServletResponse.getWriter().write(
                tofu.newRenderer("examples.simple.helloWorld").setData(map).render());
    }
}
