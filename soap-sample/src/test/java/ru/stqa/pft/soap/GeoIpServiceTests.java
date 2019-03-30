package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){

        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("93.92.204.80");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }

    }

