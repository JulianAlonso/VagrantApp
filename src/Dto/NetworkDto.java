/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dto;

/**
 *
 * @author julianalonso
 */
public class NetworkDto {
   
    private String network;
    private String type;
    private String ip;
    private String guestPort;
    private String hostPort;

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGuestPort() {
        return guestPort;
    }

    public void setGuestPort(String guestPort) {
        this.guestPort = guestPort;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }
    
    
    
}
