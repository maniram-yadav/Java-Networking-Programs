import java.net.*;
import java.util.Scanner;
import java.net.InetAddress;
import java.io.*;

/*                          @Author : Maniram Yadav                */

class IpAddress     {
public static void main(String[] args) throws UnknownHostException{
InetAddress Address=InetAddress.getLocalHost();
Scanner sc=new Scanner(System.in);
System.out.println("Enter Web Url : ");
String addr=sc.nextLine();
Address=InetAddress.getByName(addr);
   System.out.println("****************************************************************************");
 String Host=Address.getHostAddress();
 String Hostname=Address.getHostName();
 System.out.println("Host Address : "+Host);
 System.out.println("Hostname     : "+Hostname);

      }}
