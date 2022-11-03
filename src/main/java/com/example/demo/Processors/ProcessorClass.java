package com.example.demo.Processors;

import com.example.demo.bean.BeanClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


@Component
public class ProcessorClass implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String strValue = (String) exchange.getIn().getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();
        if(strValue.startsWith("{") || strValue.startsWith("[")){
            BeanClass beanClass = objectMapper.readValue(strValue,BeanClass.class);
            exchange.setProperty("strValue",beanClass.getNumber());
        } else if (strValue.startsWith("<")) {
            BeanClass beanClass = xmlMapper.readValue(strValue,BeanClass.class);
            exchange.setProperty("strValue",beanClass.getNumber());
        }
        else {
            exchange.setProperty("strValue",Integer.parseInt((strValue)));
        }
    }
}
