package com.company;/// список реакторов


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="ReactorType") //Аннотация, чтобы в xml все открывалось
@XmlAccessorType(XmlAccessType.FIELD)
public class Reactortype {
    @XmlElement(name = "TYPE") //условие
    private List<Reactor> reactortype;

    public Reactortype(){ //пустой конструктор создает объект
    }

    public List<Reactor> getReactortype() {
        return reactortype;
    }

    public void setReactortype(List<Reactor> reactortype) {
        this.reactortype = reactortype;
    }
}