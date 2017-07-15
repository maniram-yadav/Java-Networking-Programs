import java.io.*;
import java.net.*;


/*                          @Author : Maniram Yadav                */


class UdpClient{

public static void main(String[] args) throws Exception{

   DatagramSocket udpconnect=new DatagramSocket();
   
   
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try{
   InetAddress ip=InetAddress.getByName("localhost");
   while(true){
   byte[] sendData=new byte[1024];
   byte[] receiveData=new byte[1024];
   
   String msg=br.readLine();
   sendData=msg.getBytes();
   DatagramPacket udppacket=new DatagramPacket(sendData,sendData.length,ip,3000);
   udpconnect.send(udppacket);
   
     DatagramPacket getserver=new DatagramPacket(receiveData,receiveData.length);
	 udpconnect.receive(getserver);
	 
	 String getmsg=new String(getserver.getData());
	 System.out.println("Server Msg :  "+getmsg);
}


}
catch(Exception e){
System.out.println("Exception : "+e.toString());
}
   
finally{
udpconnect.close();
}

}
}
