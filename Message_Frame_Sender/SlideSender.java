import java.net.*;
import java.io.*;
import java.rmi.*;


/*                          @Author : Maniram Yadav                */


class SlideSender
{
public static void main(String a[])throws Exception
{
int sptr=0,size=8,nf,ano,i;
String ch;
Socket socket=new Socket(InetAddress.getLocalHost(),3333);
BufferedReader in=new BufferedReader( new InputStreamReader(System.in));
BufferedReader in1=new BufferedReader(new InputStreamReader(socket.getInputStream()));
String strBuffer[]=new String[8];
PrintStream prtStr;
System.out.print("Enter the number of frames : ");
nf=Integer.parseInt(in.readLine());
do
{
prtStr=new PrintStream(socket.getOutputStream());
prtStr.println(nf);
if(nf<=size-1)
{

System.out.println("Enter "+nf+" Messages :\n");
for(i=1;i<=nf;i++)
{
strBuffer[sptr]=in.readLine();
prtStr.println(strBuffer[sptr]);
sptr=++sptr%8;
}
size-=nf;
System.out.println("waiting for acknowledge");
Thread.sleep(1700);
System.out.print("Acknowledgment received from server");
ano=Integer.parseInt(in1.readLine());
System.out.println(" for "+ano+" frames");
size+=nf;
}
else
{
System.out.println("Frames size exceeds window size");
break;
}
System.out.print("\nDo you wants to send some more frames yes or no : ");
ch=in.readLine();
 prtStr.println(ch);
}
while(ch.equals("yes"));
socket.close();
}
}
