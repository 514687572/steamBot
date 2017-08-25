package com.stip.net.steam.trade;

import com.ibasco.agql.protocols.valve.steam.webapi.requests.SteamEconomyRequest;

public class GetTradeStatus extends SteamEconomyRequest {
	public GetTradeStatus(String apiMethod, int apiVersion) {
		super(apiMethod, apiVersion);
	}
	
	public GetTradeStatus(int apiVersion,String tradeid) {
		super("GetTradeStatus", apiVersion);
		urlParam("tradeid", tradeid);
		urlParam("get_descriptions", true);
		urlParam("language", "english");
	}

}
