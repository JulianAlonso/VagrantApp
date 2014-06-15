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
public class VagrantfileDto {
    
    private String boxName;
    private NetworkDto netWorkDto;

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public NetworkDto getNetWorkDto() {
        return netWorkDto;
    }

    public void setNetWorkDto(NetworkDto netWorkDto) {
        this.netWorkDto = netWorkDto;
    }
    
    public String getBoxConfig() {
        String line = "config.vm.box = ";
        
        line += "\""+this.boxName+"\"";
        
        return line;
    }
    
    public String getNetworkConfig() {
        String line = "config.vm.network";
        String selectedNetwork = this.netWorkDto.getNetwork();
        if (selectedNetwork.equals("private_network")) {
            line += " \"private_network\",";
            
            String type = this.netWorkDto.getType();
            if (type.equals("dhcp")) {
                line += " type: \"dchp\" ";
            } else {
                line += " ip: \""+this.netWorkDto.getIp()+"\"";
            }
        } else {
            line += " \"forwarded_port\", guest: "+this.netWorkDto.getGuestPort()+", "
                    + "host: " + this.netWorkDto.getHostPort();
        }
        return line;
    }
    
}
