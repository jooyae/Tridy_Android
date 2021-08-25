package org.journey.tridy_android.signup.controller

import io.reactivex.Completable

interface SignupController {
    fun checkNickNameQualification(nickname: String): Completable
    fun checkNickNameRepetition(nickname: String) : Completable
}