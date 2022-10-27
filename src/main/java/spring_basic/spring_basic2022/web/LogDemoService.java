package spring_basic.spring_basic2022.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring_basic.spring_basic2022.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("Service id = " + id);
    }
}
