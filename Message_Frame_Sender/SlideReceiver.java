import java.io.*;
import java.net.*;
class SlideReceiver
{
public static void main(String a[])throws Exception
{
int i=0,rptr=-1,nf,rws=8,size=8;
String strBuffer[]=new String[size];
String ch;
ServerSocket serSocket=new ServerSocket(3333);
Socket s=serSocket.accept();
 BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
PrintStream p=new PrintStream(s.getOutputStream());
System.out.println();
do
{
nf=Integer.parseInt(in.readLine());
if(nf<=rws-1)
{
for(i=1;i<=nf;i++)
{
rptr=++rptr%size;
strBuffer[rptr]=in.readLine();
System.out.println("The received Frame " +rptr+" is : "+strBuffer[rptr]);
}
rws-=nf;
System.out.println("\nAcknowledgment sent\n");
p.println(nf); rws+=nf; }
else
break;
ch=in.readLine();
}
while(ch.equals("yes"));
}
}