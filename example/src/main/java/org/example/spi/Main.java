package org.example.spi;

import org.example.spi.service.SPIService;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 **/
public class Main {
    public static void main(String[] args) {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        while(providers.hasNext()) {
            SPIService ser = providers.next();
            ser.execute();
        }
        System.out.println("--------------------------------");
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        Iterator<SPIService> iterator = load.iterator();
        while(iterator.hasNext()) {
            SPIService ser = iterator.next();
            ser.execute();
        }
    }
}
