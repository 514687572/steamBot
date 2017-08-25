package com.stip.net.service.impl;

import java.util.concurrent.CompletableFuture;

import com.google.gson.JsonObject;
import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiClient;
import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiInterface;
import com.stip.net.steam.trade.GetTradeStatus;

public class SteamTradeService extends SteamWebApiInterface {

	public SteamTradeService(SteamWebApiClient client) {
		super(client);
		// TODO Auto-generated constructor stub
	}
	
    public CompletableFuture<JsonObject> GetTradeStatus(String tradeid) {
        CompletableFuture<JsonObject> json = sendRequest(new GetTradeStatus(VERSION_1, tradeid));
        return json.thenApply(root -> root.getAsJsonObject("response"));
    }

}
