pyenv install 3.9.1;
pyenv global 3.9.1; 
pip install conan;
# https://conan.io/center/
mkdir build && cd build;
brew install cmake;
conan install .. --build=missing;
    # worked : conan install --build=boost --build=bzip2 --build=libbacktrace --build=zlib .. ;