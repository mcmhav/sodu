package z;

import java.util.ArrayList;
import java.util.HashMap;

public class A {

	private int[][] b = new int[9][9];
	private int[][] temp1 = new int[9][9];
	private int[][] temp2 = new int[9][9];
	private int[][] temp3 = new int[9][9];
	private int f,m,c,o,p,q1,q2,qv,sm,sf,m2,ssf,ssm, q11, q22, sssm, sssf;
	private boolean a7, a71, a7r, a7s2k, a7s2h, a61, a77, a66;
	private ArrayList<ArrayList> l = new ArrayList<ArrayList>();
	private ArrayList<Integer> a6 = new ArrayList<Integer>();
	private HashMap<Integer, ArrayList> h = new HashMap<Integer, ArrayList>();
	private HashMap<Integer, ArrayList> t1 = new HashMap<Integer, ArrayList>();
	private HashMap<Integer, ArrayList> t2 = new HashMap<Integer, ArrayList>();
	private HashMap<Integer, ArrayList> t3 = new HashMap<Integer, ArrayList>();
	int r = 0;
	
	public A(int[][] b){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(b[i][j]>0){
					this.b[i][j] = b[i][j];
					f++;
				}
				else{
					m++;
				}
			}
		}
		for (int i = 1; i <= 81; i++) {
			h.put(i, l);
		}
		q1=0;
		q2=0;
		a7 = true;
		a71 = true;
		a61 = true;
		a66 = false;
		a77 = false;
	}

	private boolean q(int p1,int p2,int v){
		int u=0;
		int k=0;
		if((p1)<3){
			u=0;
		}
		else if((p1)<6){
			u=3;
		}
		else if((p1)<=9){
			u=6;
		}
		if((p2)<3){
			k=0;
		}
		else if((p2)<6){
			k=3;
		}
		else if((p2)<=9){
			k=6;
		}
		for(int i=u;i<u+3;i++){
			for(int j=k;j<k+3;j++){
				if(v==b[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	private void a1(int p1, int p2){
		if(b[p1][p2]==0){
			ArrayList<Integer> v = new ArrayList<Integer>();
			for(int i=1;i<=9;i++){
				boolean r = true;
				for(int j=0;j<9;j++){
					if(i==b[j][p2] || i==b[p1][j]){
						r = false;
						break;
					}
				}
				if(r && q(p1,p2,i)){
					v.add(i);
				}
			}
			if(v.size()==1){
				b[p1][p2]=v.get(0);
				if(p2<=2)
					h.put(((p2+1)+3*p1), l);
				else if(p2<=5)
					h.put(((p2+1)+3*p1)+24, l);
				else if(p2<=8)
					h.put(((p2+1)+3*p1)+24*2, l);
				m--;
				f++;
				for (int j = box(p1,p2)*9+1; j <= box(p1,p2)*9+9; j++) {
					for (int i = 0; i < h.get(j).size(); i++) {
						if((Integer)h.get(j).get(i)==b[p1][p2]){
							h.get(j).remove(i);
						}
					}
				}
			}else{
				if(p2<=2)
					h.put(((p2+1)+3*p1), v);
				else if(p2<=5)
					h.put(((p2+1)+3*p1)+24, v);
				else if(p2<=8)
					h.put(((p2+1)+3*p1)+24*2, v);
//				h.put(p1*9+p2+1, v);
			}
		}
	}
	
	private void a2(int a){
		for(int m = 1;m <=9;m++){
			int w = 0;
			int p = 0;
			for (int j = a*9+1; j <= a*9+9; j++) {
				for (int i = 0; i < h.get(j).size(); i++) {
					if((Integer)h.get(j).get(i)==m){
						w++;
						p=j;
					}
				}
			}
			if(w==1){
				for(int i = 0; i <= 8; i++){
					for(int j = 0; j <= 8; j++){
						if(j<=2){
							if(((j+1)+3*i)==p){
                                a2h(m,i,j);
								break;
							}
						}else if(j<=5){
							if((((j+1)+3*i)+24)==p){
                                a2h(m,i,j);
								break;
							}
						}else if(j<=8){
							if((((j+1)+3*i)+24*2)==p){
								a2h(m,i,j);
								break;
							}
						}
					}
				}
			}
		}
	}

    private void a2h(int m, int i, int j){
        b[i][j]=m;
        if(j<=2)
            h.put(((j+1)+3*i), l);
        else if(j<=5)
            h.put(((j+1)+3*i)+24, l);
        else if(j<=8)
            h.put(((j+1)+3*i)+24*2, l);
        this.m--;
        f++;
        for (int j2 = box(i,j)*9+1; j2 <= box(i,j)*9+9; j2++) {
            for (int i2 = 0; i2 < h.get(j2).size(); i2++) {
                if((Integer)h.get(j2).get(i2)==b[i][j]){
                    h.get(j2).remove(i2);
                }
            }
        }
    }

	private void a3c(int p1, int p2){
		if(b[p1][p2]==0){
			
		}else{
			if(p2<=2){
				for(int i = p2+1; i <= 25+p2; i = i + 3){
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==b[p1][p2]){
							h.get(i).remove(j);
						}
					}
				}
			}else if(p2<=5){
				for(int i = p2+25; i <= 49+p2; i = i + 3){
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==b[p1][p2]){
							h.get(i).remove(j);
						}
					}
				}
			}else if(p2<=8){
				for(int i = p2+49; i <= 73+p2; i = i + 3){
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==b[p1][p2]){
							h.get(i).remove(j);
						}
					}
				}
			}
		}
	}
	
	private void a3cc(int a){
			for(int m = 1; m <= 9; m++){
				int c = 0;
				int r = -1;
				boolean t = false;
				for(int i = a*9+1; i <= a*9+7;i = i+3){
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==m){
							c++;
							r=0;
							t=true;
							break;
						}
					}
					if(c>0&&t){
						break;
					}
				}
				t=false;
				for(int i = a*9+2; i <= a*9+8;i = i+3){
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==m){
							c++;
							r=1;
							t=true;
							break;
						}
					}
					if(c>0&&t){
						break;
					}
				}
				t=false;
				for(int i = a*9+3; i <= a*9+9;i = i+3){
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==m){
							c++;
							r=2;
							t=true;
							break;
						}
					}
					if(c>0&&t){
						break;
					}
				}
				if(c==1){
					if(a<=2){
						for(int i = r+1; i <= 25+r; i = i + 3){
							if(i==r+1&&a==0){
								i = 10+r;
							}else if(i==r+10&&a==1){
								i = 19+r;
							}else if(i==r+19&&a==2){
								break;
							}
							for(int j = 0; j < h.get(i).size(); j++){
								if((Integer)h.get(i).get(j)==m){
									h.get(i).remove(j);
								}
							}
						}
					}else if(a<=5){
						for(int i = r+3+25; i <= 49+3+r; i = i + 3){
							if(i==r+3+25&&a==3){
								i = 34+r+3;
							}else if(i==r+3+34&&a==4){
								i = 43+r+3;
							}else if(i==r+3+43&&a==5){
								break;
							}
							for(int j = 0; j < h.get(i).size(); j++){
								if((Integer)h.get(i).get(j)==m){
									h.get(i).remove(j);
								}
							}
						}
					}else if(a<=8){
						for(int i = r+6+49; i <= 73+r+6; i = i + 3){
							if(i==r+6+49&&a==6){
								i = 58+r+6;
							}else if(i==r+6+58&&a==7){
								i = 67+r+6;
							}else if(i==r+67+6&&a==8){
								break;
							}
							for(int j = 0; j < h.get(i).size(); j++){
								if((Integer)h.get(i).get(j)==m){
									h.get(i).remove(j);
								}
							}
						}
					}
				}
			}
	}
	
	private void a3r(int p1, int p2){
		if(b[p1][p2]==0){
			
		}else{
			int c = 0;
			for(int i = p1*3+1; i <= 57+p1*3;){
				for(int j = 0; j < h.get(i).size(); j++){
					if((Integer)h.get(i).get(j)==b[p1][p2]){
						h.get(i).remove(j);
					}
				}
				c++;
				if(c==3){
					i = i+24;
				}else if(c==6){
					i = i+24;
				}
				i++;
			}
		}
	}
	
	private void a3rc(int a){
		for(int m = 1; m <= 9; m++){
			int c = 0;
			int r = -1;
			boolean s = false;
			for(int i = a*9+1; i <= 9*a+3; i++){
				for(int j = 0; j < h.get(i).size(); j++){
					if((Integer)h.get(i).get(j)==m){
						c++;
						r = 1;
						s = true;
						break;
					}
				}
				if(c>0&&s){
					break;
				}
			}
			s = false;
			for(int i = a*9+1+3; i <= 9*a+3+3; i++){
				for(int j = 0; j < h.get(i).size(); j++){
					if((Integer)h.get(i).get(j)==m){
						c++;
						r = 4;
						s = true;
						break;
					}
				}
				if(c>0&&s){
					break;
				}
			}
			s = false;
			for(int i = a*9+1+6; i <= 9*a+3+6; i++){
				for(int j = 0; j < h.get(i).size(); j++){
					if((Integer)h.get(i).get(j)==m){
						c++;
						r = 7;
						s = true;
						break;
					}
				}
				if(c>0&&s){
					break;
				}
			}
			if(c==1){
				int g = -1;
				if(a==0||a==3||a==6){
					g=r;
				}else if(a==1||a==4||a==7){
					g=r+9;
				}else if(a==2||a==5||a==8){
					g=r+18;
				}
				int w = 0;
				for(int i = g; i <= 56+g;){
					if(a<=2&&i==g){
						i=g+27;
						w = 3;
					}else if(a<=5&&a>=3&&i==g+27){
						i=g+54;
						w += 3;
					}else if(a>=6&&i==g+54){
						break;
					}
					for(int j = 0; j < h.get(i).size(); j++){
						if((Integer)h.get(i).get(j)==m){
							h.get(i).remove(j);
						}
					}
					w++;
					if(w==3){
						i = i+24;
					}else if(w==6){
						i = i+24;
					}
					i++;
				}
			}
		}
	}

	private void a6s1(int gv){
		
		if(r==1&&!(a6.size()>0)){
			if(q22<8){
				q22++;
			}else if(q11<8){
				q22=0;
				q11++;
			}
			r=0;
			m++;
			f--;
		}
		if(!(a6.size()>0)){
			a6.addAll(h.get(gv));
			a6.add(0, 0);
			r = 1;
		}
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				temp3[i][j] = b[i][j];
				temp1[i][j] = 0;
				temp2[i][j] = 0;
			}
		}
		b[q11][q22]=a6.get(a6.size()-1);
		a6.remove(a6.size()-1);
		for(int i = 1; i <= 81; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(h.get(i));
			t3.put(i, temp);				
		}
		sssm=m;
		sssf=f;
		h.put(gv, l);
		this.m--;
		f++;
		for (int j2 = box(q11,q22)*9+1; j2 <= box(q11,q22)*9+9; j2++) {
			for (int i2 = 0; i2 < h.get(j2).size(); i2++) {
				if((Integer)h.get(j2).get(i2)==b[q11][q22]){
					h.get(j2).remove(i2);
				}
			}
		}
	}
	
	private void a6s2(int gv){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				b[i][j] = temp3[i][j];
			}
		}
		for(int i = 1; i <= 81; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(t3.get(i));
			h.put(i, temp);				
		}
		m=sssm;
		f=sssf;
	}
	
	private void a7s1(){
		boolean a = true;
		a7r = true;
		int t = 0;
		while(a&&t<100){
			int gv = 0;
			t++;
			qv=0;
			if(q2<=2){
				gv = (q2+1)+3*q1;
			}else if(q2<=5){
				gv = (q2+1)+3*q1+24;
			}else if(q2<=8){
				gv = ((q2+1)+3*q1)+24*2;
			}
			if(b[q1][q2]==0&&h.get(gv).size()==2){
				a=false;
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						temp1[i][j] = b[i][j];
					}
				}
				b[q1][q2]=(Integer)h.get(gv).get(qv);
				for(int i = 1; i <= 81; i++){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(h.get(i));
					t1.put(i, temp);				
				}
				if(gv==54){
					System.out.println("");
				}
				sm=m;
				sf=f;
				h.put(gv, l);
				this.m--;
				f++;
				for (int j2 = box(q1,q2)*9+1; j2 <= box(q1,q2)*9+9; j2++) {
					for (int i2 = 0; i2 < h.get(j2).size(); i2++) {
						if((Integer)h.get(j2).get(i2)==b[q1][q2]){
							h.get(j2).remove(i2);
						}
					}
				}
			}
			if(a){
				if(q2<8){
					q2++;
				}else if(q1<8&&q2==8){
					q2=0;
					q1++;
				}else{
					a7 = false;
				}
			}
		}
		a71 = false;
	}
	
	private void a7s2(){
		int gv = 0;
		qv=1;
		if(q2<=2){
			gv = (q2+1)+3*q1;
		}else if(q2<=5){
			gv = (q2+1)+3*q1+24;
		}else if(q2<=8){
			gv = ((q2+1)+3*q1)+24*2;
		}
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				temp2[i][j] = b[i][j];
				b[i][j] = temp1[i][j];
			}
		}
		for(int i = 1; i <= 81; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			ArrayList<Integer> temp2 = new ArrayList<Integer>();
			temp.addAll(h.get(i));
			temp2.addAll(t1.get(i));
			t2.put(i, temp);
			h.put(i, temp2);				
		}
		ssf=f;
		ssm=m;
		f=sf;
		m=sm;
		if(gv==50){
			System.out.println("");
		}
		if(b[q1][q2]==0&&h.get(gv).size()==2){
			a71 = true;
			b[q1][q2]=(Integer)h.get(gv).get(qv);
			h.put(gv, l);
			this.m--;
			f++;
			for (int j2 = box(q1,q2)*9+1; j2 <= box(q1,q2)*9+9; j2++) {
				for (int i2 = 0; i2 < h.get(j2).size(); i2++) {
					if((Integer)h.get(j2).get(i2)==b[q1][q2]){
						h.get(j2).remove(i2);
					}
				}
			}
		}
		if(q2<8){
			q2++;
		}else if(q1<8){
			q2=0;
			q1++;
		}else{
			a7 = false;
		}
	}
	 
	private int box(int p1,int p2){
		int u = 0,k = 0;
		if((p1)<=2){
			u=0;
		}
		else if((p1)<=5){
			u=1;
		}
		else if((p1)<=8){
			u=2;
		}
		if((p2)<=2){
			k=0;
		}
		else if((p2)<=5){
			k=3;
		}
		else if((p2)<=8){
			k=6;
		}
		return (u+k);
	}
	
	public void print(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(b[i][j]+" ");
				if(j==2||j==5){
					System.out.print("  ");
				}
			}
			if(i==2||i==5){
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("Found:"+f+" "+"Missing:"+m+" "+"Count:"+(c));
	}
	
	public void r1(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				a1(i, j);
				a3c(i, j);
				a3r(i, j);
			}
		}
	}
	
	public void r2(){
		for(int i = 0; i <= 8; i++){
			a2(i);
			a3cc(i);
			a3rc(i);
		}
	}
	
	public void r3(){
		if(m==m2&&!a71){
			
		}
		if(m==m2&&a7&&m<20&&a71&&a7r&&!a7s2k){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					b[i][j] = temp2[i][j];
				}
			}
			for(int i = 1; i <= 81; i++){
				h.put(i, t2.get(i));
			}
			m=ssm;
			ssm = ssm + 25;
			f=ssf;
		}else if(m==m2&&a7&&a71&&a7r&&!a7s2k){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					b[i][j] = temp1[i][j];
				}
			}
			for(int i = 1; i <= 81; i++){
				h.put(i, t1.get(i));
			}
			m=sm;
			f=sf;
		}else if(m==m2&&a7&&!a71&&a7r&&m<15){
			a7s2k = true;
			a7s2h = false;
		}
		if(a7s2h&&a7s2k&&m==m2){
			a7s2k=false;
		}
		a7s2h = true;
		if(m==m2&&a7&&a71){
			a77 = true;;
			a7s1();
		}
		if(m==m2&&a7&&!a71){
			a7s2();
		}
	}
	
	public boolean r4(){
		c++;
		print();
		System.out.println(h);
		if(m==0){
			System.out.println("Solved");
			return false;
		}else if(m==m2&&c>2000){
			return false;
		}else{
			m2 = m;
			return true;
		}
	}
	
	public void r5(){
		int gv = 0;
		if(q22<=2){
			gv = (q22+1)+3*q11;
		}else if(q22<=5){
			gv = (q22+1)+3*q11+24;
		}else if(q22<=8){
			gv = ((q22+1)+3*q11)+24*2;
		}
//		if(m==m2&&m!=0&&a66&&h.get(gv).size()==0){
//			b[q11][q22]=0;
//			if(q22<8){
//				q22++;
//			}else if(q11<8){
//				q22=0;
//				q11++;
//			}
//		}
		if(!a7){
			a66 = true;
			q1=0;
			q2=0;
			boolean a = true;
			if(m<15&&a6.size()>0){
				for (int j2 = box(q11,q22)*9+1; j2 <= box(q11,q22)*9+9; j2++) {
					for (int i2 = 0; i2 < t3.get(j2).size(); i2++) {
						if((Integer)t3.get(j2).get(i2)==b[q11][q22]){
							t3.get(j2).remove(i2);
						}
					}
				}
			}
			if(a6.size()==1){
				System.out.println();
			}
			if(a6.size()>0){
				a6s2(gv);
				a6s1(gv);
				a = false;
				a7 = true;
				a71 = true;
				a7r = false;
			}
			while(a){
				if(q22<=2){
					gv = (q22+1)+3*q11;
				}else if(q22<=5){
					gv = (q22+1)+3*q11+24;
				}else if(q22<=8){
					gv = ((q22+1)+3*q11)+24*2;
				}
				if(b[q11][q22]==0&&h.get(gv).size()>2){
					a = false;
					a7 = true;
					a71 = true;
					a7r = false;
					a6s1(gv);
				}else{
					if(q22<8){
						q22++;
					}else if(q11<8){
						q22=0;
						q11++;
					}else{
						a=false;
					}
				}
			}
		}
	}
	
	public int getf(){
		return f;
	}
	public int getm(){
		return m;
	}
	public int getc(){
		return c;
	}
	public int getb(int i, int j){
		return b[i][j];
	}
	public boolean geta6(){
		return a66;
	}
	public boolean geta7(){
		return a77;
	}
	
	public static void main(String[] args) {
		int[][] e=	{{2,0,0,5,1,0,0,7,0},
					{0,0,0,0,0,0,4,6,0},
					{4,0,5,0,6,0,0,0,8},
					{0,0,8,4,7,0,2,0,0},
					{0,0,0,6,0,1,0,0,0},
					{0,0,2,0,5,8,3,0,0},
					{8,0,0,0,9,0,6,0,1},
					{0,5,3,0,0,0,0,0,0},
					{0,9,0,0,8,5,0,0,0}};
		int[][] e2=	{{0,0,0,0,0,4,8,7,0},
					{0,7,0,6,2,0,1,5,0},
					{0,2,0,7,0,0,9,0,6},
					{0,6,0,9,3,0,0,4,1},
					{1,0,0,2,0,7,0,0,5},
					{2,3,0,0,6,1,0,9,0},
					{6,0,7,0,0,2,0,1,0},
					{0,8,1,0,7,6,0,2,0},
					{0,5,2,1,0,0,0,0,0}};
		int[][] e3=	{{0,0,0,5,1,0,0,7,0},
					{0,0,0,0,0,0,4,6,0},
					{4,0,5,0,6,0,0,0,8},
					{0,0,8,4,7,0,2,0,0},
					{0,0,0,6,0,1,0,0,0},
					{0,0,2,0,5,8,3,0,0},
					{8,0,0,0,9,0,6,0,1},
					{0,5,3,0,0,0,0,0,0},
					{0,9,0,0,8,5,0,0,0}};
		int[][] e4=	{{0,0,7,0,4,0,0,0,3},
					{0,0,0,6,0,0,7,0,9},
					{0,0,0,8,3,0,0,4,0},
					{4,5,1,0,2,0,6,7,8},
					{6,2,0,0,0,0,0,9,5},
					{9,7,8,0,6,0,3,2,1},
					{0,9,0,0,5,8,0,0,0},
					{1,0,2,0,0,3,0,0,0},
					{3,0,0,0,9,0,8,0,0}};
		int[][] e5=	{{0,0,0,0,3,0,1,5,0},
					{0,0,0,0,7,8,6,0,9},
					{2,9,0,0,0,0,0,0,7},
					{0,0,0,0,6,0,2,0,3},
					{0,1,3,7,2,9,4,8,0},
					{4,0,2,0,8,0,0,0,0},
					{3,0,0,0,0,0,0,6,4},
					{8,0,6,3,9,0,0,0,0},
					{0,7,1,0,4,0,0,0,0}};
		int[][] e6=	{{0,1,0,3,0,0,0,7,8},
					{0,9,8,0,5,0,0,0,0},
					{3,7,0,0,8,6,5,0,0},
					{7,5,0,0,0,0,0,0,0},
					{0,0,1,6,4,5,9,0,0},
					{0,0,0,0,0,0,0,5,1},
					{0,0,9,8,6,0,0,2,5},
					{0,0,0,0,2,0,8,4,0},
					{2,8,0,0,0,4,0,9,0}};
		int[][] e7=	{{0,3,0,0,0,4,0,0,0},
					{0,0,0,5,6,0,4,7,0},
					{4,0,7,0,9,0,0,0,2},
					{0,0,9,6,0,0,0,0,0},
					{3,2,0,8,0,5,0,9,6},
					{0,0,0,0,0,9,8,0,0},
					{6,0,0,0,8,0,5,0,9},
					{0,4,8,0,5,2,0,0,0},
					{0,0,0,1,0,0,0,4,0}};
		int[][] e8=	{{1,3,0,0,0,4,0,0,0},
					{0,0,0,5,6,0,4,7,0},
					{4,0,7,0,9,0,0,0,2},
					{0,0,9,6,0,0,0,0,0},
					{3,2,0,8,0,5,0,9,6},
					{0,0,0,0,0,9,8,0,0},
					{6,0,0,0,8,0,5,0,9},
					{0,4,8,0,5,2,0,0,0},
					{0,0,0,1,0,0,0,4,0}};
		int[][] e9=	{{0,8,5,6,0,3,0,0,4},
					{0,0,2,0,0,1,0,0,0},
					{0,0,3,5,0,0,1,6,0},
					{0,4,0,0,5,0,3,8,0},
					{0,0,9,3,2,8,4,0,0},
					{0,5,8,0,1,0,0,7,0},
					{0,3,7,0,0,5,9,0,0},
					{0,0,0,2,0,0,8,0,0},
					{5,0,0,8,0,9,6,3,0}};
		int[][] e10={{0,0,0,6,0,8,3,0,0},
					{0,1,0,7,0,0,0,0,6},
					{0,8,0,0,1,0,0,5,9},
					{0,0,0,0,6,1,2,3,5},
					{0,0,0,0,0,0,0,0,0},
					{2,5,4,8,3,0,0,0,0},
					{5,3,0,0,8,0,0,9,0},
					{9,0,0,0,0,3,0,6,0},
					{0,0,8,9,0,4,0,0,0}};
		int[][] e11={{6,4,0,9,0,0,0,3,0},
					{0,0,8,3,6,0,0,4,0},
					{0,0,7,0,0,0,0,0,6},
					{5,0,0,2,0,0,4,0,0},
					{0,7,1,0,0,0,3,2,0},
					{0,0,3,0,0,7,0,0,5},
					{7,0,0,0,0,0,1,0,0},
					{0,8,0,0,5,2,6,0,0},
					{0,1,0,0,0,9,0,5,4}};
		int[][] e12={{0,0,0,0,3,0,1,5,0},
					{0,0,0,0,7,8,6,0,9},
					{2,9,0,0,0,0,0,0,7},
					{0,0,0,0,6,0,2,0,3},
					{0,1,3,7,2,9,4,8,0},
					{4,0,2,0,8,0,0,0,0},
					{3,0,0,0,0,0,0,6,4},
					{8,0,6,3,9,0,0,0,0},
					{0,7,1,0,4,0,0,0,0}};
		int[][] e13={{0,0,0,5,2,0,0,0,0},
					{7,1,0,0,0,8,0,0,0},
					{3,9,0,0,0,0,0,4,0},
					{5,0,0,0,0,9,7,0,0},
					{0,0,9,0,8,0,2,0,0},
					{0,0,8,1,0,0,0,0,3},
					{0,2,0,0,0,0,0,3,5},
					{0,0,0,8,0,0,0,9,1},
					{0,0,0,0,5,6,0,0,0}};
		int[][] e14={{0,0,0,0,6,7,0,0,5},
					{6,0,5,2,0,0,0,0,0},
					{0,0,0,4,9,0,0,8,0},
					{0,0,3,0,0,0,0,0,6},
					{5,0,0,8,0,1,0,0,7},
					{1,0,0,0,0,0,2,0,0},
					{0,6,0,0,4,2,0,0,0},
					{0,0,0,0,0,8,4,0,2},
					{7,0,0,3,5,0,0,0,0}};
		int[][] e15={{0,0,0,9,0,0,5,0,0},
					{2,0,0,5,0,0,0,1,0},
					{0,0,0,0,4,0,0,9,3},
					{0,6,0,7,0,0,1,0,0},
					{0,0,4,6,0,2,7,0,0},
					{0,0,7,0,0,3,0,6,0},
					{3,8,0,0,6,0,0,0,0},
					{0,5,0,0,0,4,0,0,1},
					{0,0,9,0,0,1,0,0,0}};
		int[][] e16={{0,0,5,0,0,0,2,0,0},
					{0,2,0,3,6,0,0,0,0},
					{0,0,0,0,0,2,0,0,9},
					{7,0,0,0,4,0,0,1,0},
					{5,0,2,0,1,0,9,0,3},
					{0,6,0,0,9,0,0,0,2},
					{8,0,0,7,0,0,0,0,0},
					{0,0,0,0,2,4,0,7,0},
					{0,0,1,0,0,0,4,0,0}};
		int[][] e17={{7,0,0,0,0,3,0,0,0},
					{8,6,0,0,0,2,1,9,0},
					{0,0,9,0,0,0,0,0,0},
					{0,0,0,3,2,0,6,0,0},
					{4,0,0,0,0,0,0,0,1},
					{0,0,2,0,5,1,0,0,0},
					{0,0,0,0,0,0,7,0,0},
					{0,3,5,8,0,0,0,1,4},
					{0,0,0,9,0,0,0,0,5}};
		int[][] e18={{2,0,0,0,0,6,0,0,0},
					{0,0,0,0,9,0,0,0,2},
					{0,0,0,4,8,0,9,0,1},
					{1,2,0,0,0,7,0,5,0},
					{0,0,5,0,0,0,7,0,0},
					{0,3,0,2,0,0,0,1,9},
					{5,0,2,0,7,3,0,0,0},
					{6,0,0,0,2,0,0,0,0},
					{0,0,0,8,0,0,0,0,4}};
		
		A t = new A(e18);
		t.print();
		while(t.r4()){
			t.r1();
			
			t.r2();
			
			t.r3();
			
			t.r5();
		}	
	}
}
