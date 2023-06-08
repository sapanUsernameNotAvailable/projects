package com.xd.lang;

public class GenericFactory<T> {
    
    private final Class<T> factoryClassType;
    public GenericFactory(Class<T> factoryClassType) { // T ensures runtime type is same as compile type.
        this.factoryClassType = factoryClassType;
    }
    
    public T getInstance() throws InstantiationException, IllegalAccessException {
        return factoryClassType.newInstance();
    }
}
