// Autor: Pablo Alvarez 221082

package factory;

import Interfaces.IMap;
import maps.Option2;
import maps.Option3;
import maps.Option1;

public class Factory {
    

    public IMap returnHashmap(int type){

        switch (type) {
            case 1:
                return new Option1();
            case 2:
                return new Option2();
            case 3:
                return new Option3(); 
            default:
                return null;
        }
    }
}
