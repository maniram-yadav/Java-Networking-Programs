import java.io.*;
import java.net.*;
class ClientRpc
{
 public static void main(String[] args) throws Exception
 {
  Socket socket = new Socket("localhost", 3333); 
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
  OutputStream ostr = socket.getOutputStream();    
  InputStream istr = socket.getInputStream(); 
  BufferedReader readMsg = new BufferedReader(new InputStreamReader(istr));   
  PrintWriter prtWrt = new PrintWriter(ostr, true); 
  System.out.println(" : Client is ready now for RPC procedure : ");
  String recMsg, sndMsg,temp; 
  while(true) 
  {
   System.out.println("\nEnter (addition,substract,multiply,division ,close) operation to perform :- ");
   temp = input.readLine();
   sndMsg=temp.toLowerCase(); 
   prtWrt.println(sndMsg);
   if(sndMsg.equals("close"))
   {
   socket.close();
   break ;
   }
   System.out.println("Enter first parameter :");
   sndMsg = input.readLine(); 
   prtWrt.println(sndMsg);
   System.out.println("Enter second parameter : ");
   sndMsg = input.readLine(); 
   prtWrt.println(sndMsg);
   System.out.flush(); 
   if((recMsg = readMsg.readLine()) != null) 
    System.out.println(recMsg); 
  }
  
 }
}