import java.net.*;  
import java.io.*; 



/*                          @Author : Maniram Yadav                */


class TcpServer{  
public static void main(String args[])throws Exception{  

ServerSocket ss=new ServerSocket(3333);  
Socket s=ss.accept();  

DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  System.out.println();
String str="",str2="";  
while(!str.equals("stop")){
  
str=din.readUTF();  
System.out.println("User 1 says: "+str);  
str2=br.readLine();  
dout.writeUTF(str2); 
 
dout.flush();  
}  
din.close();  
s.close();  
ss.close();  
}}  
