package br.com.academiadev.projetocoders.reembolsocoders.common;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;

import javax.servlet.http.HttpServletRequest;

public class DeviceProvider {
    public Device getDispositivo(HttpServletRequest request) {
        return DeviceUtils.getCurrentDevice(request);
    }

}
