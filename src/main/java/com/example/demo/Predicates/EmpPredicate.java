package com.example.demo.Predicates;

import com.example.demo.Processors.ProcessorClass;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmpPredicate implements Predicate {


    @Override
    public boolean matches(Exchange exchange) {
        int response = (Integer) exchange.getProperty("strValue");
//        int res = Integer.parseInt(response);
        return response % 2 == 0 ;
    }
}
