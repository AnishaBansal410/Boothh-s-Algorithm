package boothalgo;
import java.util.*;
public class booth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long md=s.nextLong();
		long mr=s.nextLong();
		String a=binGen(0,n);
		String MR;
		String MD;
		if(md<0) { MD=binGen(md,n); }
		else { MD=binGen(md,n);}
		if(mr<0) {MR=binGen(mr,n);}
		else { MR=binGen(mr,n);}
		System.out.println("MULTIPLICAND="+MD);System.out.println("MULTIPLIER=Q="+MR);
		String[] A=new String[n]; 
		String[] Q=new String[n]; 
		for(int i=0;i<n-1;i++)
		{
			A[i]=a.substring(i,i+1);
		}
		A[n-1]=a.substring(n-1);
		for(int i=0;i<n-1;i++)
		{
			Q[i]=MR.substring(i,i+1);
		}
		Q[n-1]=MR.substring(n-1);
		String[] C=new String[2*n+1];
		for(int i=0;i<A.length;i++)
    	{
    		C[i]=A[i];
    	}
    	for(int i=A.length;i<C.length-1;i++)
    	{
    		C[i]=Q[i-Q.length];
    	}
		C[C.length-1]="0";
		System.out.println("A"+"       "+"Q"+"    "+"Q0");
		 for(int i=0;i<Q.length;i++) {System.out.print(A[i]);} System.out.print("  ");
		   for(int i=0;i<Q.length;i++) {System.out.print(Q[i]);}System.out.print("  ");  System.out.print(C[C.length-1]);System.out.println();
		  	
		while(n!=0)
		{
			String str=C[C.length-2]+C[C.length-1];
			if(str.contentEquals("00")|| str.contentEquals("11"))
				{
				   C=ASR(A,Q,C);
				   for(int i=0;i<A.length;i++) {A[i]=C[i];}
				   for(int i=0;i<Q.length;i++) {Q[i]=C[i+A.length];}
				   for(int i=0;i<Q.length;i++) {System.out.print(A[i]);} System.out.print("  ");
				   for(int i=0;i<Q.length;i++) {System.out.print(Q[i]);}System.out.print("  ");  System.out.print(C[C.length-1]);System.out.println();
				  	}
			else if(str.contentEquals("01"))
			{
				A=binAdd(A,MD);
				C=ASR(A,Q,C);

				   for(int i=0;i<A.length;i++) {A[i]=C[i];}
				   for(int i=0;i<Q.length;i++) {Q[i]=C[i+A.length];}
				   for(int i=0;i<Q.length;i++) {System.out.print(A[i]);} System.out.print("  ");
				   for(int i=0;i<Q.length;i++) {System.out.print(Q[i]);}  System.out.print("  ");  System.out.print(C[C.length-1]);System.out.println();
				
			}
			else
			{
				A=binSub(A,MD);
				C=ASR(A,Q,C);
				
				   for(int i=0;i<A.length;i++) {A[i]=C[i];}
				   for(int i=0;i<Q.length;i++) {Q[i]=C[i+A.length];}
				   for(int i=0;i<Q.length;i++) {System.out.print(A[i]);}
				   System.out.print("  ");
				   for(int i=0;i<Q.length;i++) {System.out.print(Q[i]);}System.out.print("  ");  System.out.print(C[C.length-1]); System.out.println();
				
			}
			n--;
		}
		String st1="";
		String st2="";
		for(int i=0;i<A.length;i++) {st1=st1+A[i];st2=st2+Q[i];}
		System.out.println("FINAL ANSWER :-");
		System.out.println(st1+st2);
		if((md<0 && mr<0)|| (md>=0 && mr>=0) ) {System.out.println(Long.parseLong(st1+st2,2));}
		else if((md<0 && mr>0)||(md>0&&mr<0)) {System.out.println(0-Long.parseLong((twocomp(st1+st2)),2));}
		
	}
     static String[] ASR(String[] A,String[] Q,String[] C)
    {
    	
    	C[0]=A[0];
    	for(int i=0;i<A.length;i++)
    	{
    		C[i+1]=A[i];
    	}
    	for(int i=A.length+1;i<C.length;i++)
    	{
    		C[i]=Q[i-Q.length-1];
    	}
    	return C;
    }
    
     static String binGen(long i,int n) {
  		
		String op = Long.toBinaryString(i);
        if(op.length()<n){while(op.length()<n) {
			op = "0"+op;
        }}
        else
        {
         op=op.substring(op.length()-n);
        }
		return op;
	}
      
     static String twocomp(String str)
     {
    	 int n = str.length(); 
         int j=-1;
         int i;
         for (i = n-1 ; i >=0 ; i--) 
             {
        	 	if (str.charAt(i) == '1') 
        	 		{j=0; break;}
             }
         if (j==-1) 
             {return "1" + str; }
         String str1=str.substring(0,i);
         String str2=str.substring(i);
         for (int k = i-1 ; k >= 0; k--) 
         { 
            
             if (str1.charAt(k) == '1') 
                 str1=replacechar(str1, k, '0'); 
             else
                 str1=replacechar(str1, k, '1'); 
         } 
         String str3=str1+str2;
         return str3; 
     } 

     static String replacechar(String x,int i,char a)
     {
    	 x=x.substring(0,i)+a+x.substring(i+1);
    	 return x;
     }
    
     static String[] binAdd(String[] A, String m )
     {   
    	 String s="";
    	 for(int i=0;i<A.length;i++)
    	 {
    		 s=s+A[i];
    	 }
    	 long n1=Long.parseLong(s,2);
    	 long n2=Long.parseLong(m,2);
    	 long n3=n1+n2;
    	 String s1=binGen(n3,A.length);
    	 for(int i=0;i<A.length;i++)
    	 {
    		 A[i]=Character.toString(s1.charAt(i));
    	 }
    	 return A;
     }
     static String[] binSub(String[] A, String m )
     {   
    	 String s="";
    	 for(int i=0;i<A.length;i++)
    	 {
    		 s=s+A[i];
    	 }
    	 long n1=Long.parseLong(s,2);
    	 long n2=Long.parseLong(m,2);
    	 long n3=n1-n2;
    	 String s1=binGen(n3,A.length);
    	 for(int i=0;i<A.length;i++)
    	 {
    		 A[i]=Character.toString(s1.charAt(i));
    	 }
    	 return A;
     }
}
