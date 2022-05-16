package com.company;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parsers {
    public Parsers(){

    }
    public List<Reactor> parsjson(String str){
        Gson gson = new Gson();
        List<Reactor> result = new ArrayList<>();
        try {
            Reactortype reactortype = gson.fromJson(new FileReader(str), Reactortype.class);
            result = reactortype.getReactortype();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return result;
    }


    public List<Reactor> parsyaml(String s){
        Yaml yaml = new Yaml();
        InputStream str = null;
        try {
            str = new FileInputStream(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Iterable<Object> A = yaml.loadAll(str); //обращаемся к yaml библиотеке и загружаем все что есть внутри файла в виде "колллекции"
        List<Reactor> B = new ArrayList<>();
        A.forEach(a -> B.add((Reactor) a)); //превращаем из класса объект в класс реактор

        return B;
    }

    public List<Reactor> Parsxml(String str){
        List<Reactor> result = new ArrayList<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Reactortype.class);//создаем объект библиотеки, настраиваемые на конкретный класс, котороый мы будем читать из файла
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();//это метод  объекты xml преобразует в объекты Reactortype
            Reactortype unmarshal = (Reactortype) unmarshaller.unmarshal(new FileReader(str));// в Reactortype
            result=unmarshal.getReactortype();
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }


}
