package ru.malik.myApp3.server.repos.simple;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Created by Малик on 04.11.2014.
 */
public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor{
    public FinderIntroductionAdvisor(){
        super(new FinderIntroductionInterceptor());
    }
}
