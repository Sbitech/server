package com.sbitech.service;

import com.sbitech.entity.DiffTransitionResult;

public interface DiffTransitionResultService {
    boolean upDiffTransitionResult(DiffTransitionResult diffTransitionResult);

    DiffTransitionResult getDiffTransitionResult();
}
