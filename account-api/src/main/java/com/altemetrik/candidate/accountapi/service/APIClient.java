package com.altemetrik.candidate.accountapi.service;

import com.altemetrik.candidate.accountapi.entity.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface APIClient {
    @GetMapping("/api/v1/user/email/{email}")
    UserDto getUserByEmail(@PathVariable("email") String email);

}
