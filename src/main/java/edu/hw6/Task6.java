package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {

    private final static int PORT_COUNT = 49151;
    private final static String BLANK = "    ";
    private final static Logger LOGGER = LogManager.getLogger();
    Map<Integer, String> map;

    @SuppressWarnings("MagicNumber")
    Task6() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(135, "EPMAP");
        hashMap.put(137, "Служба имен NetBIO");
        hashMap.put(138, "Служба датаграмм NetBIOS");
        hashMap.put(139, "Служба сеансов NetBIOS");
        hashMap.put(445, "Microsoft-DS Active Directory");
        hashMap.put(500, "Internet Key Exchange protocol for VPN connections");
        hashMap.put(843, "Adobe Flash");
        hashMap.put(1900, "Simple Service Discovery Protocol (SSDP)");
        hashMap.put(3702, "Динамическое обнаружение веб-служб");
        hashMap.put(5353, "Многоадресный DNS");
        hashMap.put(5355, "Link-Local Multicast Name Resolution (LLMNR)");
        hashMap.put(17500, "Dropbox");
        hashMap.put(27017, "MongoDB");
        this.map = hashMap;
    }

    void globalCheck() {
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str = checkTcp(str);
        str = checkUdp(str);
        LOGGER.info(str);
    }

    StringBuilder checkTcp(StringBuilder ans) {
        ServerSocket server;
        for (int i = 0; i <= PORT_COUNT; i++) {
            try {
                server = new ServerSocket(i);
                server.close();
            } catch (IOException e) {
                String purpose;
                ans.append("TCP       ").append(i);
                if (map.containsKey(i)) {
                    purpose = map.get(i);
                    ans.append(BLANK).append(purpose);
                }
                ans.append('\n');
            }
        }
        return ans;
    }

    StringBuilder checkUdp(StringBuilder ans) {
        DatagramSocket datagram;
        for (int i = 0; i <= PORT_COUNT; i++) {
            try {
                datagram = new DatagramSocket(i);
                datagram.close();
            } catch (IOException e) {
                String purpose;
                ans.append("UDP       ").append(i);
                if (map.containsKey(i)) {
                    purpose = map.get(i);
                    ans.append(BLANK).append(purpose);
                }
                ans.append('\n');
            }
        }
        return ans;
    }
}
