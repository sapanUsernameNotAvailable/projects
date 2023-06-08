cmake_minimum_required(VERSION 2.8.12)
 project(HelloWorld)

 add_definitions("-std=c++11")

 include(${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
 conan_basic_setup()

 add_executable(hello_world hello_world.cpp)
 target_link_libraries(hello_world ${CONAN_LIBS})