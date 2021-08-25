package org.journey.tridy_android.signup.controller

import io.reactivex.Completable
import org.journey.tridy_android.signup.controller.SignupController
import javax.inject.Inject

class SignupControllerImpl @Inject constructor(
): SignupController {
    override fun checkNickNameQualification(nickname: String): Completable {
        TODO("Not yet implemented")
    }

    override fun checkNickNameRepetition(nickname: String): Completable {
        TODO("Not yet implemented")
    }
}