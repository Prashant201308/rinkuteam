package com.user.userdetails.clients;

import com.user.userdetails.dto.MemberDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RinkuClient{


    private WebClient webClient;

    public RinkuClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://RINKUTEAM").build();
    }

    @CircuitBreaker(
            name = "rinkuService",
            fallbackMethod = "rinkuServiceFallback"
    )
    public MemberDto getMemberFromRinkuService(int id){
        MemberDto resdto = webClient.get().uri("/gangs/gangsters/{id}",id).retrieve().bodyToMono(MemberDto.class).block();
        return resdto;

    }

    public MemberDto rinkuServiceFallback(int id, Throwable ex) {

        System.out.println("RinkuService is down: " + ex.getMessage());w

        return new MemberDto(12, "Rinku Down", 28);
    }

}
