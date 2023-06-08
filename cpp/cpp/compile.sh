cd build;
cmake .. -G "Unix Makefiles" -DCMAKE_BUILD_TYPE=Release;
cmake --build .;
build/bin/hello_world;
# gcc hello_world.cpp -lstdc++ && ./a.out;