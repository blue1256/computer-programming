#ifndef CPSCALAR_H
#define CPSCALAR_H
#include <cassert>

using namespace std;
class cpScalar {
public:
    cpScalar();
    cpScalar(int num);
    cpScalar(double num);
    void Insert(ostream &sout) const;
    void SetNum(double num);
    double GetNum() const;
    cpScalar Add(const cpScalar &s)const;
    cpScalar Subtract(const cpScalar &s)const;
    cpScalar Multiply(const cpScalar &s)const;
    cpScalar Divide(const cpScalar &s)const;
    friend cpScalar operator+(const cpScalar &s1,const cpScalar &s2) {return s1.Add(s2);}
    friend cpScalar operator*(const cpScalar &s1,const cpScalar &s2) {return s1.Multiply(s2);}
    friend cpScalar operator-(const cpScalar &s1,const cpScalar &s2) {return s1.Subtract(s2);}
    friend cpScalar operator/(const cpScalar &s1,const cpScalar &s2) {return s1.Divide(s2);}
    friend ostream& operator<<(ostream &sout, const cpScalar &s);
private:
    double _num;
};

cpScalar cpScalar::Add(const cpScalar &s)const{
    return cpScalar(_num+s._num);
}
cpScalar cpScalar::Subtract(const cpScalar &s)const{
    return cpScalar(_num-s._num);
}
cpScalar cpScalar::Multiply(const cpScalar &s)const{
    return cpScalar(_num*s._num);
}
cpScalar cpScalar::Divide(const cpScalar &s)const{
    assert(s._num!=0);
    return cpScalar(_num/s._num);
}

cpScalar::cpScalar(){
    _num=0;
}

cpScalar::cpScalar(int num){
    _num =num;
}

cpScalar::cpScalar(double num){
    _num=num;
}

void cpScalar::SetNum(double num){
    _num=num;
}

double cpScalar::GetNum() const{
    return _num;
}

void cpScalar::Insert(ostream &sout) const{
    sout<<_num;
}

ostream& operator<<(ostream &sout, const cpScalar &s){
    s.Insert(sout);
    return sout;
}

#endif
