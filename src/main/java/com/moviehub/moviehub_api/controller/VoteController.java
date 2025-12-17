package com.moviehub.moviehub_api.controller;

import com.moviehub.moviehub_api.domain.entity.User;
import com.moviehub.moviehub_api.dto.vote.VoteRequestDTO;
import com.moviehub.moviehub_api.service.VoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.moviehub.moviehub_api.security.AuthenticatedUserService;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;
    private final AuthenticatedUserService authenticatedUserService;

    @PostMapping
    public void vote(@RequestBody @Valid VoteRequestDTO dto) {
        voteService.vote(authenticatedUserService.get(), dto);
    }
}
