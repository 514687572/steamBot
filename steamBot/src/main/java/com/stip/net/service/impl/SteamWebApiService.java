package com.stip.net.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ibasco.agql.examples.base.BaseWebApiAuthExample;
import com.ibasco.agql.protocols.valve.steam.webapi.SteamWebApiClient;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamApps;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamEconItems;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamEconomy;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamNews;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamPlayerService;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamStorefront;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUser;
import com.ibasco.agql.protocols.valve.steam.webapi.interfaces.SteamUserStats;
import com.stip.net.utils.Constant;

@Service
public class SteamWebApiService  extends BaseWebApiAuthExample{
	private static final Logger log = LoggerFactory.getLogger(SteamWebApiService.class);
    private SteamWebApiClient apiClient;
    public SteamApps steamApps;
    public SteamNews steamNews;
    public SteamUserStats steamUserStats;
    public SteamPlayerService playerService;
    public SteamUser steamUser;
    public SteamEconomy steamEconomy;
    public SteamStorefront storeFront;
    public SteamEconItems steamEconItems;
    public SteamTradeService steamTradeService ;
    

	public SteamWebApiService() {
		super();
		String authToken = Constant.steamKey;
		apiClient = new SteamWebApiClient(authToken);
	    steamApps = new SteamApps(apiClient);
	    steamNews = new SteamNews(apiClient);
	    steamUserStats = new SteamUserStats(apiClient);
	    playerService = new SteamPlayerService(apiClient);
	    steamUser = new SteamUser(apiClient);
	    steamEconomy = new SteamEconomy(apiClient);
	    storeFront = new SteamStorefront(apiClient);
	    steamEconItems = new SteamEconItems(apiClient);
	    steamTradeService = new SteamTradeService(apiClient);
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
