package com.stip.net.steam.trade;

import com.ibasco.agql.protocols.valve.steam.webapi.requests.SteamEconomyRequest;

public class StartTrade extends SteamEconomyRequest {

	public StartTrade(String apiMethod, int apiVersion) {
		super(apiMethod, apiVersion);
	}

}
