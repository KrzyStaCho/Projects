public class BinaryIP
{
    public static String ToBinary(String IP)
    {
        int Address[] = ConvertString(IP);
        int i=128;
        String binIP="";
        for(int k=0;k<4;k++)
        {
            int addressIP = Address[k];
            while(i>=1)
            {
                if(addressIP-i>=0)
                {
                    addressIP-=i;
                    binIP+="1";
                }
                else
                {
                    binIP+="0";
                }
                i/=2;
            }
            if(k!=3)
            {
                binIP+=".";
            }
            i=128;
        }
        return binIP;
    }
    public static String FromBinary(String binIP)
    {
        String binAddress[] = binIP.split("\\.");
        int i=128;
        String IP="";
        for(int j=0;j<4;j++)
        {
            int tmpIP=0;
            for(int k=0;k<binAddress[j].length();k++)
            {
                if(binAddress[j].toCharArray()[k]=='1')
                {
                    tmpIP+=i;
                }
                i/=2;
            }
            IP+=Integer.toString(tmpIP);
            if(j!=3)
            {
                IP+=".";
            }
            i=128;
        }
        return IP;
    }
    private static int[] ConvertString(String IP)
    {
        String[] sAddress = IP.split("\\.");
        int Address[] = new int[4];
        for(int i=0;i<4;i++)
        {
            Address[i]=Integer.parseInt(sAddress[i]);
        }
        return Address;
    }
}
