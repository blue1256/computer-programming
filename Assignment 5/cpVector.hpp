#ifndef CPVECTOR_H
#define CPVECTOR_H
#include "cpScalar.hpp"
#include <cassert>

using namespace std;
class cpVector{
public:
    cpVector();
    cpVector(cpScalar sarr[], unsigned int size);
    cpVector Add(const cpVector &v) const;
    cpVector Subtract(const cpVector &v) const;
    cpScalar Multiply(const cpVector &v) const;
    cpVector Add(const cpScalar &s) const;
    cpVector Subtract(const cpScalar &v) const;
    cpVector Multiply(const cpScalar &s) const;
    cpVector Divide(const cpScalar &s) const;
    void Insert(ostream &sout) const;
    friend cpVector operator+(const cpVector &v1, const cpVector &v2) {return v1.Add(v2);}
    friend cpVector operator-(const cpVector &v1, const cpVector &v2) {return v1.Subtract(v2);}
    friend cpScalar operator*(const cpVector &v1, const cpVector &v2) {return v1.Multiply(v2);}
    friend cpVector operator+(const cpScalar &s, const cpVector &v) {return v.Add(s);}
    friend cpVector operator*(const cpScalar &s, const cpVector &v) {return v.Multiply(s);}
    friend cpVector operator+(const cpVector &v, const cpScalar &s) {return v.Add(s);}
    friend cpVector operator-(const cpVector &v, const cpScalar &s) {return v.Subtract(s);}
    friend cpVector operator*(const cpVector &v, const cpScalar &s) {return v.Multiply(s);}
    friend cpVector operator/(const cpVector &v, const cpScalar &s) {return v.Divide(s);}
    friend ostream& operator<<(ostream &sout,const cpVector &v);
private:
    cpScalar _sarr[2048];
    unsigned int _size;
};

cpVector::cpVector(){
    _size=0;
}

cpVector::cpVector(cpScalar sarr[], unsigned int size){
    _size=size;
    for(int i=0;i<size;i++){
        _sarr[i]=sarr[i];
    }
}

void cpVector::Insert(ostream &sout) const{
    if(_size>0){
        sout<<"["<<_sarr[0].GetNum();
        for(int i=1;i<_size;i++){
            sout<<", "<<_sarr[i].GetNum();
        }
        sout<<"]";
    }
    if(_size==0){
        sout<<"[]";
    }
}

cpVector cpVector::Add(const cpVector &v) const{
    assert(_size==v._size);
    cpScalar scalars[2048];
    for(int i=0;i<_size;i++){
        scalars[i] = _sarr[i]+v._sarr[i];
    }
    return cpVector(scalars,_size);
}

cpVector cpVector::Subtract(const cpVector &v) const{
    assert(_size==v._size);
    cpScalar scalars[2048];
    for(int i=0;i<_size;i++){
        scalars[i] = _sarr[i]-v._sarr[i];
    }
    return cpVector(scalars,_size);
}

cpScalar cpVector::Multiply(const cpVector &v) const{
    assert(_size==v._size);
    cpScalar sum = cpScalar(0);
    for(int i=0;i<_size;i++){
        sum = sum+_sarr[i]*v._sarr[i];
    }
    return sum;
}

cpVector cpVector::Add(const cpScalar &s) const{
    cpScalar scalars[2048];
    for(int i=0;i<_size;i++){
        scalars[i] = _sarr[i]+s;
    }
    return cpVector(scalars,_size);
}

cpVector cpVector::Subtract(const cpScalar &s) const{
    cpScalar scalars[2048];
    for(int i=0;i<_size;i++){
        scalars[i] = _sarr[i]-s;
    }
    return cpVector(scalars,_size);
}

cpVector cpVector::Multiply(const cpScalar &s) const{
    cpScalar scalars[2048];
    for(int i=0;i<_size;i++){
        scalars[i] = _sarr[i]*s;
    }
    return cpVector(scalars,_size);
}

cpVector cpVector::Divide(const cpScalar &s) const{
    assert(s.GetNum()!=0);
    cpScalar scalars[2048];
    for(int i=0;i<_size;i++){
        scalars[i] = _sarr[i]/s;
    }
    return cpVector(scalars,_size);
}

ostream& operator<<(ostream &sout,const cpVector &v){
    v.Insert(sout);
    return sout;
}

#endif
