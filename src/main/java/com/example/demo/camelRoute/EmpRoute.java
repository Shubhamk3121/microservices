package com.example.demo.camelRoute;

import com.example.demo.Predicates.EmpPredicate;
import com.example.demo.Processors.ProcessorClass;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpRoute extends RouteBuilder {

    @Autowired
    public EmpPredicate empPredicate;

    @Autowired
    public ProcessorClass processorClass;
    @Override
    public void configure() throws Exception {
        from("activemq:from")
                .process(processorClass)
                .choice()
                .when(empPredicate)
                .to("activemq:even")
                .otherwise()
                .to("activemq:odd")
                .end();
    }
}
