package ru.example.resolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;
import ru.example.views.MyView;

import java.util.Locale;

public class MyViewResolver extends AbstractCachingViewResolver{

    public MyViewResolver() {
    }

    protected View loadView(String s, Locale locale) throws Exception {
        return new MyView();
    }

}
