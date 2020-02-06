public class NetworkAddressCalculation
{
    String AddressIP;
    String binAddressIP;
    String NetMask;
    String binNetMask;
    String binNetworkAddressIP;
    String NetworkAddressIP;
    String binBroadcastAddressIP;
    String BroadcastAddressIP;
    int ShortNetMask;
    int MaxHosts;
    String FirstHost;
    String LastHost;
    public NetworkAddressCalculation(String addressIP, String netMask)
    {
        AddressIP = addressIP;
        binAddressIP = BinaryIP.ToBinary(AddressIP);
        NetMask = netMask;
        binNetMask = BinaryIP.ToBinary(NetMask);
    }
    public void Start()
    {
        AND();
        NetworkAddressIP = BinaryIP.FromBinary(binNetworkAddressIP);

        NOT();
        binBroadcastAddressIP = BinaryIP.ToBinary(BroadcastAddressIP);

        CountShortNetMask();
        MaxHostsInNetwork();
        FirstLastHost();
        Print();
    }
    public void Print()
    {
        System.out.print("Adres Sieci: ");
        System.out.println(NetworkAddressIP);
        System.out.print("Adres Rozgłoszeniowy: ");
        System.out.println(BroadcastAddressIP);
        System.out.print("Liczba Hostów: ");
        System.out.println(MaxHosts);
        System.out.print("Pierwszy Host: ");
        System.out.println(FirstHost);
        System.out.print("Ostatni Host: ");
        System.out.println(LastHost);
    }
    private void AND()
    {
        String networkIP="";
        for(int i=0;i<binAddressIP.length();i++)
        {
            if(binAddressIP.toCharArray()[i]=='.')
            {
                networkIP+=".";
            }
            else if(binAddressIP.toCharArray()[i]=='1' && binNetMask.toCharArray()[i]=='1')
            {
                networkIP+="1";
            }
            else
            {
                networkIP+="0";
            }
        }
        binNetworkAddressIP = networkIP;
    }
    private void NOT()
    {
        String broadcastIP="";
        for(int i=0;i<binNetMask.length();i++)
        {
            if(binNetMask.toCharArray()[i]=='1')
            {
                broadcastIP+="0";
            }
            else if(binNetMask.toCharArray()[i]=='0')
            {
                broadcastIP+="1";
            }
            else if(binNetMask.toCharArray()[i]=='.')
            {
                broadcastIP+=".";
            }
        }
        broadcastIP = BinaryIP.FromBinary(broadcastIP);
        int[] networkAddressIP = ConvertString(NetworkAddressIP);
        int[] broadcast = ConvertString(broadcastIP);
        int[] broadcastAddressIP = new int[4];
        String tmpBroadcastAddressIP="";
        for(int i=0;i<4;i++)
        {
            broadcastAddressIP[i] = networkAddressIP[i] + broadcast[i];
            tmpBroadcastAddressIP+=Integer.toString(broadcastAddressIP[i]);
            if(i!=3)
            {
                tmpBroadcastAddressIP+=".";
            }
        }
        BroadcastAddressIP = tmpBroadcastAddressIP;
    }
    private int[] ConvertString(String IP)
    {
        String[] sAddress = IP.split("\\.");
        int Address[] = new int[4];
        for(int i=0;i<4;i++)
        {
            Address[i]=Integer.parseInt(sAddress[i]);
        }
        return Address;
    }
    private String ConvertInt(int[] Address)
    {
        String tmpAddress="";
        for(int i=0;i<4;i++)
        {
            tmpAddress+=Integer.toString(Address[i]);
            if(i!=3)
            {
                tmpAddress+=".";
            }
        }
        return tmpAddress;
    }
    private void CountShortNetMask()
    {
        int shortNetMask=0;
        for(int i=0;i<binNetMask.length();i++)
        {
            if(binNetMask.toCharArray()[i]=='1')
            {
                shortNetMask++;
            }
        }
        ShortNetMask = shortNetMask;
    }
    private void MaxHostsInNetwork()
    {
        MaxHosts = (int)Math.pow(2,32-ShortNetMask)-2;
    }
    private void FirstLastHost()
    {
        int[] networkAddressIP = ConvertString(NetworkAddressIP);
        int[] broadcastAddressIp = ConvertString(BroadcastAddressIP);
        int[] firstHost = networkAddressIP.clone();
        int[] lastHost = broadcastAddressIp.clone();
        if(networkAddressIP[3]+1>255)
        {
            firstHost[3]=0;
            firstHost[2]+=1;
        }
        else
        {
            firstHost[3]+=1;
        }
        if(lastHost[3]-1<0)
        {
            lastHost[2]-=1;
            lastHost[3]=255;
        }
        else
        {
            lastHost[3]-=1;
        }
        FirstHost = ConvertInt(firstHost);
        LastHost = ConvertInt(lastHost);
    }
}
