#include <iostream>
#include <fstream>
#include <string>

using namespace std;

char board[130][130];
bool chk[130][130];
int rsize;
int csize;
int rdir[4] = {1,0,0,-1};
int cdir[4] = {0,1,-1,0};
string ptos(int row, int col){
    int r = row*csize+col+1;
    return to_string(r);
}

class node{
public:
    node();
    node(int rnum, int cnum,string p);
    node* next;
    int row;
    int col;
    string path;
};

node::node(int rnum, int cnum, string p){
    row=rnum;
    col=cnum;
    next=nullptr;
    if(p.length()>0){
        path=p+"-"+ptos(rnum,cnum);
    }else{
        path=ptos(rnum,cnum);
    }
}

node::node(){
    row=0;
    col=0;
    next=nullptr;
    path="";
}
 
class queue{
public:
    queue();
    void push(node* tar);
    node* pop();
    bool isEmpty();
    node* head;
};

queue::queue(){
    head=nullptr;
}

void queue::push(node* tar){
    if(head==nullptr){
        head=tar;
    } else {
        node* cur=head;
        while(cur->next!=nullptr){
            cur=cur->next;
        }
        cur->next=tar;
    }
}

node* queue::pop(){
    if(head!=nullptr){
        node* ret=head;
        head=head->next;
        return ret;
    } else {
        return nullptr;
    }
}

bool queue::isEmpty(){
    if(head==nullptr){
        return true;
    } else {
        return false;
    }
}

queue Q;

bool check(node tar){
    if(tar.row>=rsize||tar.col>=csize||tar.row<0||tar.col<0){
        return false;
    } else if(chk[tar.row][tar.col]){
        return false;
    } else if(board[tar.row][tar.col]=='0'){
        return false;
    } else {
        return true;
    }
}

string bfs(){
    int curR = rsize-1;
    int curC = 0;
    int destR = 0;
    int destC = csize-1;
    node start = node(curR,curC,"");
    Q.push(&start);
    chk[start.row][start.col]=true;
    node* cur = nullptr;
    while(!Q.isEmpty()){
        cur = Q.pop();
        for(int i=0;i<4;i++){
            node* move = new node(cur->row+rdir[i],cur->col+cdir[i],cur->path);
            if(check(*move)){
                if(move->row==destR&&move->col==destC){
                    return move->path;
                }
                chk[move->row][move->col]=true;
                Q.push(move);
            }
        }
    }
    if(cur==Q.head){
        return Q.head->path;
    } else {
        return "";
    }
}

int main(int argc, const char * argv[]){
    ifstream fin(argv[1]);
    ofstream fout(argv[2]);
    for(int i=0;i<130;i++){
        for(int j=0;j<130;j++){
            board[i][j]=0;
            chk[i][j]=false;
        }
    }
    rsize=0;
    csize=0;
    Q = queue();
    char n;
    int row=0;
    int col=0;
    while(fin.get(n)){
        if(n=='\n'){
            rsize++;
            row++;
            col=0;
        }
        else if (n!='\t')
            board[row][col]=n;
        else if (n=='\t'){
            col++;
            csize=col;
        }
    }
    csize++;
    string path = bfs();
    fout<<path<<endl;
}

