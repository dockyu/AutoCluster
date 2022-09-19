package org.foo.app;

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


@Service
@Command(scope = "onos", name = "getall",
         description = "Sample Apache Karaf CLI command")
public class GetAll extends AbstractShellCommand {
	List<Host> hosts;
	List<Device> devices;
	
	@Override
    protected void doExecute() {
		this.create();
		this.ready();
		this.start();
	}
	
	private void create() {
		this.hosts = new ArrayList<Host>();
		this.devices = new ArrayList<Device>();
	}
	
	private void ready() {
		HostService service = get(HostService.class);
		this.hosts = ListHosts.getSortedHosts(service);
		DeviceService deviceService = get(DeviceService.class);
		this.devices = ListSwitchs.getSortedDevices(deviceService);
	}
	
	private void start() {
		for (Host host : hosts) {
            ListHosts.printHost(host);
        }
		DeviceService deviceService = get(DeviceService.class);
		for (Device device : devices) {
            ListSwitchs.printDevice(deviceService, device);
        }
	}
	
	
	

}
