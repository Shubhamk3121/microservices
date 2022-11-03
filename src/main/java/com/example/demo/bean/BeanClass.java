package com.example.demo.bean;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "DecisionNumber")
public class BeanClass {

    @JacksonXmlProperty(localName = "Number")
    int number;

    public BeanClass(){
    }

    public BeanClass(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }
}
