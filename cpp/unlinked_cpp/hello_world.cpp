#include <iostream>
void helloWorld();
void dataTypes();
void memoryManipulation();
int dummy(int);

int main() {
    helloWorld();
    dataTypes();
    memoryManipulation();
    return 0;
}

void helloWorld() {
    std::cout << "Hello World!";
}

class clazz { // to be declared ahead of use
    public:
    int var;

    void func() {
        std::cout << var << std::endl;
    }
};

struct structz {
     int a;
     float b;
};

enum enumz {a = 10, b = 20};

void dataTypes() {
    int score = 99;
    char ch = 's';
    bool is_true = true;
    float val = 15.26;
    double val2 = 2019.1526;

    long long int val3 = 1;
    long double	val4 = 1.0;

    int arr[4]={0,1,2,3};
    int* point_int;
    float &ref = val; ref++; std::cout << ref;

    dummy(0);

    clazz obj1, obj2;
    obj1.var = 4;
    obj1.func();
    enum enumz res = a;

    typedef long int aliasForLongInt;
}

int dummy(int num1) {
  return 0;
}

void memoryManipulation() {
  int target=4;
  std::cout << "memory address" << &target << std::endl;
  int* pointVar =  new int(50);
  std::cout << "allocated array memory address" << &pointVar << std::endl;
  delete pointVar;
}
