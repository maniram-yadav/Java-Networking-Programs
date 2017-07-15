import java.io.*;
import java.net.*;


/*                          @Author : Maniram Yadav                */


class UdpServer{

public static void main(String[] args) throws Exception{
 DatagramSocket udpconnect=new DatagramSocket(3000);
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try{
   InetAddress ip=InetAddress.getByName("localhost");
   byte[] sendData=new byte[1024];
   byte[] receiveData=new byte[1024];
   
   while(true){
    DatagramPacket getserver=new DatagramPacket(receiveData,receiveData.length);
	 udpconnect.receive(getserver);
	 String getmsg=new String(getserver.getData());
	 System.out.println("Client Msg :  "+getmsg);

   String msg=br.readLine();
   sendData=msg.getBytes();
   DatagramPacket udppacket=new DatagramPacket(sendData,sendData.length,getserver.getAddress(),getserver.getPort());
   udpconnect.send(udppacket);
     
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
