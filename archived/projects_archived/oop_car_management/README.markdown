# Car Information System

This app is a simple car information system.

## Purpose
To exercise java design skills

## Functionality
- Addition of a car type. Eg: SUV
- Addition of an instance for a particular car type. Eg: Tata safari for SUV
- Getting a car type for a given car model specifications. Eg. System will determine that the car is an SUV if given specs say for scorpio.

## Implementation details:
- There are separation of different application layers.
- The Application plugs into a view layer which itself plugs into a service layer which itself plugs into an in-memory information storage system.

### View Layer 
- View layer is represented by an interface called ViewLayer.
- Its implementation is ViewLayerImpl
- Its factory is ViewLayerFactory
- factory and singleton patterns are followed.

### Service Layer 
- Service layer is represented by an interface called ServiceLayer.
- Its implementation is ServiceLayerImpl
- Its factory is ServiceLayerFactory
- factory and singleton patterns are followed.

### Information Storage Layer 
- Information storage layer is represented by an interface called CarTypeInformationSystem.
- Its implementation is CarTypeInformationSystemImpl
- Its factory is CarTypeInformationSystemFactory
- factory and singleton patterns are followed.

### notes
 - Duration : ~1 day , ~ 15-16 June 2012 : original coding
 - Duration : ~1 day , ~ 24-25 June 2012 : refactoring (introducing service, view layering, factories etc.)

### Possible scope for improvements:
- Using spring for dependency injection
- minor code improvements specced out in TODOs
- making separate packages for each layer