package org.foo.net.lib;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;

import org.onosproject.net.Device;
import org.onosproject.net.device.DeviceService;
import org.onosproject.utils.Comparators;

public class ListSwitchs {
	private static final String FMT_SHORT =
            "id=%s, available=%s, role=%s, type=%s";
	
	public static List<Device> getSortedDevices(DeviceService service) {
        List<Device> devices = newArrayList(service.getDevices());
        Collections.sort(devices, Comparators.ELEMENT_COMPARATOR);
        return devices;
    }
	
	public static void printDevice(DeviceService deviceService, Device device) {
		if (device != null) {
            System.out.format(FMT_SHORT, device.id(), deviceService.isAvailable(device.id()),
	            deviceService.getRole(device.id()), device.type());
		}
	}
	
}
