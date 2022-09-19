package org.foo.net.lib;


import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;

import org.onosproject.net.Host;
import org.onosproject.net.host.HostService;
import org.onosproject.utils.Comparators;

public class ListHosts {
	
	private static final String FMT =
            "id=%s, mac=%s, locations=%s, vlan=%s, ip(s)=%s%s, innerVlan=%s, outerTPID=%s, " +
                    "provider=%s:%s, configured=%s";

        private static final String FMT_SHORT =
            "id=%s, mac=%s, locations=%s, vlan=%s, ip(s)=%s";
	
	public static List<Host> getSortedHosts(HostService service) {
                List<Host> hosts = newArrayList(service.getHosts());
                Collections.sort(hosts, Comparators.ELEMENT_COMPARATOR);
                return hosts;
        }
	
	public static void printHost(Host host) {
		System.out.format(FMT_SHORT, host.id(), host.mac(),
                host.locations(),
                host.vlan(), host.ipAddresses());
	}
}
