package com.stip.net.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibasco.agql.protocols.valve.steam.webapi.pojos.SteamPlayerProfile;
import com.stip.net.service.impl.SteamWebApiService;

@RestController
public class SteamController extends AbstractController{
	private static final Logger log = LoggerFactory.getLogger(SteamController.class);
	
	@Resource
	public SteamWebApiService steamWebApiService;
	
	@RequestMapping(value = "/getUserLevel.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> getSteamLevel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		result = new HashMap<String, Object>();
		String steamId=request.getParameter("steamId");
		steamWebApiService.playerService.getSteamLevel(Long.parseLong(steamId)).thenAccept(new Consumer<Integer>() {
		    public void accept(Integer integer) {
		        log.info("Steam Level : {}", integer);
		        result.put("level", integer);
		    }
		}).join();
		
		return result;
	}
	
	@RequestMapping(value = "/getPlayerProfiles.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> getSteamItems(HttpServletRequest request, HttpServletResponse response) throws Exception{
		result = new HashMap<String, Object>();
		String steamId=request.getParameter("steamId");
		steamWebApiService.steamUser.getPlayerProfiles(Long.parseLong(steamId)).thenAccept(new Consumer<List<SteamPlayerProfile>>() {
		    public void accept(List<SteamPlayerProfile> steamPlayerProfiles) {
		        steamPlayerProfiles.forEach(p -> log.info("{}", p));
		        result.put("info", steamPlayerProfiles);
		    }
		}).join();
		
		return result;
	}
	
	@RequestMapping(value = "/createOrder.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> createOrder(HttpServletRequest request, HttpServletResponse response) throws Exception{
		result = new HashMap<String, Object>();
		String steamId=request.getParameter("steamId");
		
		return result;
	}
	
}
