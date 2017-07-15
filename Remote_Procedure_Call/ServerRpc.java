
import java.io.*;
import java.net.*;
class ServerRpc
{ 
 public static void main(String[] args) throws Exception 
 { 
  ServerSocket serSocket = new ServerSocket(3333); 
  System.out.println("Now Server is  ready"); 
  Socket socket = serSocket.accept( ); 
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
  OutputStream ostream = socket.getOutputStream(); 
  PrintWriter prtWrt = new PrintWriter(ostream, true);  
  InputStream istream = socket.getInputStream(); 
  BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));   
  String receiveMessage, sendMessage,procedure;
  int a,b,c;
  while(true) 
  {
   procedure = receiveRead.readLine();
   if(procedure != null) 
    System.out.println("Procedure Calling: "+procedure);
	
	if(procedure.compareTo("close")==0)
   {
   serSocket.close();
   socket.close();
   break;
   }
   
   a = Integer.parseInt(receiveRead.readLine());
   b = Integer.parseInt(receiveRead.readLine());
   System.out.println("Parameter received : "+a+ " , "+b);
   if(procedure.compareTo("addition")==0)
   {
    c=a+b;
    System.out.println("Addition = "+c);
    prtWrt.println("Addition = "+c); 
   }
   if(procedure.compareTo("substract")==0)
   {
    c=a-b;
    System.out.println("Substraction = "+c);
    prtWrt.println("Substraction = "+c); 
   }
   if(procedure.compareTo("multiply")==0)
   {
    c=a*b;
    System.out.println("Multiplication = "+c);
    prtWrt.println("Multiplication = "+c); 
   }
   if(procedure.compareTo("division")==0)
   {
    c=a/b;
    System.out.println("Division = "+c);
    prtWrt.println("Division = "+c); 
   }
   
   System.out.flush();
  } 
 } 
}