import java.net.*;  
import java.io.*;  
import java.util.Scanner;


/*                          @Author : Maniram Yadav                */


class TcpClient{  
public static void main(String args[])throws Exception{  

Socket s=new Socket("localhost",3333);  

DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2=""; 
 System.out.println();
while(!str.equals("stop")){ 
 
str=br.readLine();  
dout.writeUTF(str);  
dout.flush(); 
 
str2=din.readUTF();  
System.out.println("User 2 says: "+str2);  
}  
  
dout.close();  
s.close();  
}}  
