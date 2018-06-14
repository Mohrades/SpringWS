package com.mycompany.hr.ws;

import marshalling.GetHolidayRequest;

import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.mycompany.hr.service.HumanResourceService;

@SuppressWarnings("deprecation")
public class MarshallingHolydayRequestEndpoint extends AbstractMarshallingPayloadEndpoint{
	
	private HumanResourceService humanResourceService;

	@Override
	protected Object invokeInternal(Object object) throws Exception {
		// TODO Auto-generated method stub
		GetHolidayRequest request = (GetHolidayRequest) object;
		return null;
	}

	public HumanResourceService getHumanResourceService() {
		return humanResourceService;
	}

	public void setHumanResourceService(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService;
	}

}
