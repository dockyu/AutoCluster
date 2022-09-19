package org.foo.task;

import org.foo.app.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.foo.net.lib.*;

import org.onosproject.net.device.DeviceService;
import org.onosproject.net.Device;
import org.onosproject.net.host.HostService;
import org.onosproject.net.Host;

import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import org.onosproject.cli.AbstractShellCommand;

import java.util.Timer;

public class TimerTaskTest extends java.util.TimerTask{
    private final Logger log = LoggerFactory.getLogger(getClass());

    String[] classA = new String[] {"00:01:00:00:00:3B", "00:01:00:00:00:37"};
    String[] classB = new String[] {"00:01:00:00:00:38", "00:01:00:00:00:39", "00:01:00:00:00:3A"};

    List<Host> two_hosts;
    List<Host> hosts;

    public TimerTaskTest(List<Host> two_hosts){
        this.two_hosts = two_hosts;
    }
    // public TimerTaskTest(){
    //     this.hosts = new ArrayList<Host>();
    // }
    

    // my task -> to get host
    @Override
    public void run() {
        this.task();
    }

    public void task() {
        HostService service = AbstractShellCommand.get(HostService.class);
        this.hosts = ListHosts.getSortedHosts(service);
        

        String macAtemp = new String("");
        String macBtemp = new String("");

        // for (String macA : classA){
        //     for (Host host : hosts){
        //         log.info("macA: " + macA + "host mac: " + host.mac().toString());
        //     }
        // }

        this.two_hosts.clear();

        for (String macA : classA){
            for (Host host : hosts){
                if (macAtemp.isEmpty() && macA.equals(host.mac().toString())){
                    macAtemp = new String(macA);
                    this.two_hosts.add(host);
                }
            }
        }
        for (String macB : classB){
            for (Host host : hosts){
                if (macBtemp.isEmpty() && macB.equals(host.mac().toString())){
                    macBtemp = new String(macB);
                    this.two_hosts.add(host);
                }
            }
        }
        log.info("host num:"+hosts.size());
        log.info("ClassA:"+macAtemp+"ClassB:"+macBtemp);
    }

}


